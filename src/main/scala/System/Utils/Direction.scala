package System.Utils

sealed trait Direction

object Direction {
  def mapIntToDirection(num: Int): Direction = {
    if(num < 0) DOWN
    else if (num == 0) STILL
    else UP
  }
  def getDirectionToMove(currFloor: Int, destinationFloor: Int): Direction = {
    val diff = destinationFloor - currFloor
    if(diff < 0) DOWN
    else if(diff == 0) STILL
    else UP
  }
}

case object UP extends Direction
case object STILL extends Direction
case object DOWN extends Direction
