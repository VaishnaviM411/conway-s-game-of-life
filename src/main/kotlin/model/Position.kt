package model

class Position(private val rowNumber: Int, private val columnNumber: Int) {
    fun getRowNumber() = rowNumber

    fun getColumnNumber() = columnNumber
}