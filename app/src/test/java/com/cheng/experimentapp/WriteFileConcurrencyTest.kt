package com.cheng.experimentapp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

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
                    val contentReadOut = FilePersistenceHelper.readFile("writeFileTest/0.txt")
                    Assert.assertEquals(contentToWrite, contentReadOut)
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
