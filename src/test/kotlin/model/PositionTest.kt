package model

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PositionTest() {

    @Test
    fun `should return rowNumber of position`() {
        val position = Position(1,2)

        val rowNumber = position.getRowNumber()

        assertEquals(1, rowNumber)
    }

    @Test
    fun `should return columnNumber of position`() {
        val position = Position(1,2)

        val columnNumber = position.getColumnNumber()

        assertEquals(2, columnNumber)
    }

}