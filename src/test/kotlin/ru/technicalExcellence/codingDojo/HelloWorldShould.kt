package ru.technicalExcellence.codingDojo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HelloWorldShould {

    @Test
    fun returnHelloWorld() {
        val expected = "Hello World!"

        val actual = HelloWorld().helloWorld();

        assertEquals(expected, actual)
    }
}

