package com.cheng.experimentapp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import java.io.FileNotFoundException
import java.lang.RuntimeException

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class WriteFileConcurrencyTest {

    @Test
    fun readAndWriteInTwoThreads() {
        runBlocking {
            val contentToWrite = FilePersistenceHelper.readFile("src/test/java/com/cheng/experimentapp/TheGreatGatsby_chapter_1.txt")
            repeat(10_000) {
                launch(Dispatchers.Default) {
                    val writeResult = FilePersistenceHelper.atomicWriteFile("writeFileTest/0.txt", contentToWrite)
                    Assert.assertTrue(writeResult)
                    try {
                        val contentReadOut = FilePersistenceHelper.readFile("writeFileTest/0.txt")
                        Assert.assertEquals(contentToWrite, contentReadOut)
                    } catch (e: FileNotFoundException) {
                        println("The file does not exist, because being written in another thread.")
                    }
                }
                launch(Dispatchers.IO) {
                    val writeResult = FilePersistenceHelper.atomicWriteFile("writeFileTest/0.txt", contentToWrite)
                    Assert.assertTrue(writeResult)
                }
                delay(1)
            }
        }
    }

}
