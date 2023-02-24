package model

class Cell(private var lifeStatus: LifeStatus = LifeStatus.DEAD) {

    fun getLifeStatus() = lifeStatus
    fun updateLifeStatus(neighbours: List<Cell>): LifeStatus {

        var numberOfLiveNeighbours = 0
        neighbours.forEach{
            if(it.lifeStatus == LifeStatus.LIVE) {
                numberOfLiveNeighbours++
            }
        }

        when(numberOfLiveNeighbours) {
            in 0..2 -> {
                lifeStatus = LifeStatus.LIVE
            }
            in 3..Int.MAX_VALUE -> {
                lifeStatus = LifeStatus.DEAD
            }
        }

        return lifeStatus
    }

}
