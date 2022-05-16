/*
 * @author Chandler Cheng (chandler.cheng@smartpay.co.nz)
 *
 * Copyright © 2022 Smartpay Limited. All rights reserved.
 */

package com.cheng.experimentapp

import androidx.core.util.AtomicFile
import java.io.*
import java.lang.RuntimeException
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

object FilePersistenceHelper {

    fun readFile(readFilePath: String): String {
        val reader = FileReader(readFilePath)
        val text = reader.readText()
        reader.close()

        return text
    }

    fun atomicWriteFile(writeFilePath: String, content: String): Boolean {
        val atomicFile = AtomicFile(File(writeFilePath))
        var fos: FileOutputStream? = null
        return try {
            synchronized(this) {
                atomicFile.delete()
                fos = atomicFile.startWrite()
                fos?.write(content.toByteArray())
                atomicFile.finishWrite(fos)

                true
            }
        } catch (e: Exception) {
            println("Can not write file: $e")
            atomicFile.failWrite(fos)

            false
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
