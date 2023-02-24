package model

import java.lang.Exception

class Grid(private val cellGrid: List<List<Cell>>) {

    fun getNumberOfCells() = cellGrid.size

    fun getCell(rowNumber: Int, columnNumber: Int): Cell {
        if (isCellPositionValid(rowNumber, columnNumber)) {
            return cellGrid[rowNumber][columnNumber]
        }
        throw Exception("RowNumber & ColumnNumber is outside the grid")
    }

    fun isCellPositionValid(rowNumber: Int, columnNumber: Int): Boolean {
        return rowNumber in 0..cellGrid.size && columnNumber in 0..cellGrid.size
    }

}
