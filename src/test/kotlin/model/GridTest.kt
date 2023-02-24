package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GridTest {

    @Test
    fun `should create a Grid with given dimension`() {
        val numberOfCells = 100
        val cells = List(numberOfCells) { List(numberOfCells) { Cell() } }

        val grid = Grid(cells)

        assertEquals(100, grid.getNumberOfCells())
    }

    @Test
    fun `should return true if position of cell is inside the grid`() {
        val numberOfCells = 100
        val cells = List(numberOfCells) { List(numberOfCells) { Cell() } }
        val grid = Grid(cells)
        val rowNumber = 3
        val columnNumber = 3

        val response = grid.isCellPositionValid(rowNumber, columnNumber)

        assertTrue(response)
    }

    @Test
    fun `should return false if position of cell is outside the grid`() {
        val numberOfCells = 100
        val cells = List(numberOfCells) { List(numberOfCells) { Cell() } }
        val grid = Grid(cells)
        val rowNumber = -3
        val columnNumber = 100

        val response = grid.isCellPositionValid(rowNumber, columnNumber)

        assertFalse(response)
    }

    @Test
    fun `should return cell at given position`() {
        val numberOfCells = 100
        val cells = List(numberOfCells) { List(numberOfCells) { Cell() } }
        val grid = Grid(cells)

        val cell = grid.getCell(0, 0)

        assertEquals(cells[0][0], cell)
    }

    @Test
    fun `should throw exception if cell is outside grid`() {
        val numberOfCells = 100
        val cells = List(numberOfCells) { List(numberOfCells) { Cell() } }
        val grid = Grid(cells)

        assertThrows(Exception()::class.java) { grid.getCell(-1, -1) }
    }

}