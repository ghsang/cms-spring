package com.utools.cms.domain.value

import com.utools.cms.domain.values.Price
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class PriceTests {
    @Test
    fun `Price given negative value will throw IllegalArgumentException`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Price(-1)
        }

        assertEquals(exception.message, "Price should be greater than zero")
    }
}
