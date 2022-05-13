/*
 * @author Chandler Cheng (chandler.cheng@smartpay.co.nz)
 *
 * Copyright © 2022 Smartpay Limited. All rights reserved.
 */

package com.cheng.experimentapp

import java.io.File
import java.io.FileReader
import java.io.FileWriter

object FilePersistenceHelper {

    fun readFile(readFilePath: String): String {
        val reader = FileReader(readFilePath)
        val text = reader.readText()
        reader.close()

        return text
    }

    fun writeFile(writeFilePath: String, content: String): Boolean {
        return try {
            File(writeFilePath).parentFile?.mkdirs()
            val writer = FileWriter(writeFilePath)
            writer.write(content)
            writer.close()
            true
        } catch (e: Exception) {
            println("writeFile error: ${e.localizedMessage}")
            false
        }
    }
}
