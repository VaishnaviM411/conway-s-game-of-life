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

//    fun getNeighbours(rowNumber: Int, columnNumber: Int): List<Cell> {
//        val neighbours = mutableListOf<Cell>()
//
//        if (isCellPositionValid(rowNumber - 1, columnNumber - 1))
//            neighbours.add(getCell(rowNumber - 1, columnNumber - 1))
//
//        if (isCellPositionValid(rowNumber - 1, columnNumber))
//            neighbours.add(getCell(rowNumber - 1, columnNumber))
//
//        if (isCellPositionValid(rowNumber - 1, columnNumber + 1))
//            neighbours.add(getCell(rowNumber - 1, columnNumber + 1))
//
//        if (isCellPositionValid(rowNumber, columnNumber - 1))
//            neighbours.add(getCell(rowNumber, columnNumber - 1))
//
//        if (isCellPositionValid(rowNumber, columnNumber + 1))
//            neighbours.add(getCell(rowNumber, columnNumber + 1))
//
//        if (isCellPositionValid(rowNumber + 1, columnNumber - 1))
//            neighbours.add(getCell(rowNumber + 1, columnNumber - 1))
//
//        if (isCellPositionValid(rowNumber + 1, columnNumber))
//            neighbours.add(getCell(rowNumber + 1, columnNumber))
//
//        if (isCellPositionValid(rowNumber + 1, columnNumber + 1))
//            neighbours.add(getCell(rowNumber + 1, columnNumber + 1))
//
//
//
//        return neighbours
//    }

    fun isCellPositionValid(rowNumber: Int, columnNumber: Int): Boolean {
        return rowNumber in 0..cellGrid.size && columnNumber in 0..cellGrid.size
    }

}
