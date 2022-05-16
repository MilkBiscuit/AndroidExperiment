/*
 * @author Chandler Cheng (chandler.cheng@smartpay.co.nz)
 *
 * Copyright © 2022 Smartpay Limited. All rights reserved.
 */

package com.cheng.experimentapp

import androidx.core.util.AtomicFile
import java.io.File
import java.io.FileOutputStream
import java.io.FileReader
import java.io.FileWriter
import java.util.concurrent.locks.ReentrantReadWriteLock

object FilePersistenceHelper {

    private val lock = ReentrantReadWriteLock()
    private val readLock = lock.readLock()
    private val writeLock = lock.writeLock()

    fun readFile(readFilePath: String): String {
        try {
            readLock.lock()
            val reader = FileReader(readFilePath)
            val text = reader.readText()
            reader.close()

            return text
        } finally {
            readLock.unlock()
        }
    }

    fun atomicWriteFile(writeFilePath: String, content: String): Boolean {
        val atomicFile = AtomicFile(File(writeFilePath))
        var fos: FileOutputStream? = null
        return try {
            writeLock.lock()
            atomicFile.delete()
            fos = atomicFile.startWrite()
            fos.write(content.toByteArray())
            atomicFile.finishWrite(fos)

            true
        } catch (e: Exception) {
            println("Can not write file: $e")
            atomicFile.failWrite(fos)

            false
        } finally {
            writeLock.unlock()
        }
    }

    fun writeFile(writeFilePath: String, content: String): Boolean {
        return try {
            File(writeFilePath).parentFile?.mkdirs()
            val writer = FileWriter(writeFilePath)
            writer.write(content)
            writer.flush()
            writer.close()
            true
        } catch (e: Exception) {
            println("writeFile error: ${e.localizedMessage}")
            false
        }
    }
}
