package model

import java.lang.Exception

class Grid(private val cellGrid: List<List<Cell>>) {

    fun getNumberOfCells() = cellGrid.size

    fun getCell(position: Position): Cell {
        if (isCellPositionValid(position)) {
            return cellGrid[position.getRowNumber()][position.getColumnNumber()]
        }
        throw Exception("RowNumber & ColumnNumber is outside the grid")
    }


    fun isCellPositionValid(position: Position): Boolean {
        return position.getRowNumber() in 0..cellGrid.size && position.getColumnNumber() in 0..cellGrid.size
    }

}
