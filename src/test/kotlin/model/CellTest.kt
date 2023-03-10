package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CellTest {

    @Test
    fun `Should return LIVE when lifeStatus is LIVE`() {
        val position = Position(0,0)
        val cell = Cell(LifeStatus.LIVE, position)

        val response = cell.getLifeStatus()

        assertEquals(LifeStatus.LIVE, response)
    }

    @Test
    fun `Should return DEAD when lifeStatus is DEAD`() {
        val position = Position(0,0)
        val cell = Cell(LifeStatus.DEAD, position)

        val response = cell.getLifeStatus()

        assertEquals(LifeStatus.DEAD, response)
    }

    @Test
    fun `Should change the lifeStatus to DEAD when cell has more than 3 live neighbours`() {
        val position = Position(0,0)
        val cell = Cell(LifeStatus.LIVE, position)
        val liveNeighbour = Cell(LifeStatus.LIVE, position)
        val neighbours = listOf(liveNeighbour, liveNeighbour, liveNeighbour, liveNeighbour)

        val updatedLifeStatus = cell.updateLifeStatus(neighbours)

        assertEquals(LifeStatus.DEAD, updatedLifeStatus)
    }

    @Test
    fun `Should change the lifeStatus to DEAD when cell has less than 2 live neighbours`() {
        val position = Position(0,0)
        val cell = Cell(LifeStatus.LIVE, position)
        val liveNeighbour = Cell(LifeStatus.LIVE, position)
        val neighbours = listOf(liveNeighbour)

        val updatedLifeStatus = cell.updateLifeStatus(neighbours)

        assertEquals(LifeStatus.LIVE, updatedLifeStatus)
    }

    @Test
    fun `Should change the lifeStatus to LIVE when cell has 2 live neighbours`() {
        val position = Position(0,0)
        val cell = Cell(LifeStatus.LIVE, position)
        val liveNeighbour = Cell(LifeStatus.LIVE, position)
        val neighbours = listOf(liveNeighbour, liveNeighbour)

        val updatedLifeStatus = cell.updateLifeStatus(neighbours)

        assertEquals(LifeStatus.LIVE, updatedLifeStatus)
    }

    @Test
    fun `Should change the lifeStatus to LIVE when cell has 3 live neighbours`() {
        val position = Position(0,0)
        val cell = Cell(LifeStatus.LIVE, position)
        val liveNeighbour = Cell(LifeStatus.LIVE, position)
        val neighbours = listOf(liveNeighbour, liveNeighbour, liveNeighbour)

        val updatedLifeStatus = cell.updateLifeStatus(neighbours)

        assertEquals(LifeStatus.LIVE, updatedLifeStatus)
    }

    @Test
    fun `Should change the lifeStatus of dead cell to LIVE when cell has 3 live neighbours`() {
        val position = Position(0,0)
        val cell = Cell(position = position)
        val liveNeighbour = Cell(LifeStatus.LIVE, position)
        val neighbours = listOf(liveNeighbour, liveNeighbour, liveNeighbour)

        val updatedLifeStatus = cell.updateLifeStatus(neighbours)

        assertEquals(LifeStatus.LIVE, updatedLifeStatus)
    }



}