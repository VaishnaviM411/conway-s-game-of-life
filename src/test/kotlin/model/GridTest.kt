package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GridTest {

    @Test
    fun `should create a Grid with given dimension`() {
        val numberOfCells = 100
        val position = Position(0,0)
        val cells = List(numberOfCells) { List(numberOfCells) { Cell(position = position) } }

        val grid = Grid(cells)

        assertEquals(100, grid.getNumberOfCells())
    }

    @Test
    fun `should return true if position of cell is inside the grid`() {
        val numberOfCells = 100
        val rowNumber = 3
        val columnNumber = 3
        val position = Position(rowNumber,columnNumber)
        val cells = List(numberOfCells) { List(numberOfCells) { Cell(position = position) } }
        val grid = Grid(cells)


        val response = grid.isCellPositionValid(position)

        assertTrue(response)
    }

    @Test
    fun `should return false if position of cell is outside the grid`() {
        val numberOfCells = 100
        val rowNumber = -3
        val columnNumber = 100
        val position = Position(rowNumber,columnNumber)
        val cells = List(numberOfCells) { List(numberOfCells) { Cell(position = position) } }
        val grid = Grid(cells)

        val response = grid.isCellPositionValid(position)

        assertFalse(response)
    }

    @Test
    fun `should return cell at given position`() {
        val numberOfCells = 100
        val position = Position(0,0)
        val cells = List(numberOfCells) { List(numberOfCells) { Cell(position = position) } }
        val grid = Grid(cells)

        val cell = grid.getCell(position)

        assertEquals(cells[0][0], cell)
    }

    @Test
    fun `should throw exception if cell is outside grid`() {
        val numberOfCells = 100
        val position = Position(-2,100)
        val cells = List(numberOfCells) { List(numberOfCells) { Cell(position = position) } }
        val grid = Grid(cells)

        assertThrows(Exception()::class.java) { grid.getCell(position) }
    }
}