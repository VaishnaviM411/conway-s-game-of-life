package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CellTest {

    @Test
    fun `Should return LIVE when lifeStatus is LIVE`() {
        val cell = Cell(LifeStatus.LIVE)

        val response = cell.getLifeStatus()

        assertEquals(LifeStatus.LIVE, response)
    }

    @Test
    fun `Should return DEAD when lifeStatus is DEAD`() {
        val cell = Cell(LifeStatus.DEAD)

        val response = cell.getLifeStatus()

        assertEquals(LifeStatus.DEAD, response)
    }

    @Test
    fun `Should change the lifeStatus to DEAD when cell has more than 3 live neighbours`() {
        val cell = Cell()
        val liveNeighbour = Cell(LifeStatus.LIVE)
        val neighbours = listOf(liveNeighbour, liveNeighbour, liveNeighbour)

        val updatedLifeStatus = cell.updateLifeStatus(neighbours)

        assertEquals(LifeStatus.DEAD, updatedLifeStatus)
    }

    @Test
    fun `Should change the lifeStatus to DEAD when cell has less than 2 live neighbours`() {
        val cell = Cell()
        val liveNeighbour = Cell(LifeStatus.LIVE)
        val neighbours = listOf(liveNeighbour)

        val updatedLifeStatus = cell.updateLifeStatus(neighbours)

        assertEquals(LifeStatus.LIVE, updatedLifeStatus)
    }

}