package com.cheng.experimentapp

import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import java.io.File
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.system.exitProcess

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class WriteFileAtomicTest {

    @Test
    fun writingFiles() {
        val contentToWrite = FilePersistenceHelper.readFile("src/test/java/com/cheng/experimentapp/TheGreatGatsby_chapter_1.txt")
        val testDirectory = File("writeFileTest")
        testDirectory.deleteRecursively()
        testDirectory.mkdirs()

        val numOfFiles = 100
        val service: ExecutorService = Executors.newFixedThreadPool(21)
        val latch = CountDownLatch(numOfFiles)
        for (i in 0 until numOfFiles) {
            service.execute {
                val file = File("$testDirectory/$i.txt")
                FilePersistenceHelper.writeFile(file.path, contentToWrite)
                latch.countDown()
            }
        }
        service.awaitTermination(2500, TimeUnit.MICROSECONDS)
        // Simulate the sudden power failure
        exitProcess(0)
    }

    @Test
    fun atomicWritingFiles() {
        val contentToWrite = FilePersistenceHelper.readFile("src/test/java/com/cheng/experimentapp/TheGreatGatsby_chapter_1.txt")
        val testDirectory = File("writeFileTest")
        testDirectory.deleteRecursively()
        testDirectory.mkdirs()

        val numOfFiles = 100
        val service: ExecutorService = Executors.newFixedThreadPool(21)
        val latch = CountDownLatch(numOfFiles)
        for (i in 0 until numOfFiles) {
            service.execute {
                val file = File("$testDirectory/$i.txt")
                FilePersistenceHelper.atomicWriteFile(file.path, contentToWrite)
                latch.countDown()
            }
        }
        service.awaitTermination(2500, TimeUnit.MICROSECONDS)
        // Simulate the sudden power failure
        exitProcess(0)
    }

}
