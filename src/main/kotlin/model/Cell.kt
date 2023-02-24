package model

class Cell(private var lifeStatus: LifeStatus = LifeStatus.DEAD) {

    fun getLifeStatus() = lifeStatus


    fun updateLifeStatus(neighbours: List<Cell>): LifeStatus {
        var numberOfLiveNeighbours = 0
        neighbours.forEach {
            if (it.lifeStatus == LifeStatus.LIVE) {
                numberOfLiveNeighbours++
            }
        }

        when (lifeStatus) {
            LifeStatus.LIVE ->
                updateStatusForLiveCell(numberOfLiveNeighbours)

            LifeStatus.DEAD -> {
                updateStatusForDeadCell(numberOfLiveNeighbours)
            }
        }

        return lifeStatus
    }

    private fun updateStatusForDeadCell(numberOfLiveNeighbours: Int) {
        when (numberOfLiveNeighbours) {
            3 -> lifeStatus = LifeStatus.LIVE
        }
    }

    private fun updateStatusForLiveCell(numberOfLiveNeighbours: Int) {
        when (numberOfLiveNeighbours) {
            in 0..1 -> {
                lifeStatus = LifeStatus.LIVE
            }

            2 -> {
                lifeStatus = LifeStatus.LIVE
            }

            3 -> {
                lifeStatus = LifeStatus.LIVE
            }

            in 4..Int.MAX_VALUE -> {
                lifeStatus = LifeStatus.DEAD
            }
        }
    }

}
