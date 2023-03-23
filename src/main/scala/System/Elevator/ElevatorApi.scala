package System.Elevator

import System.Enums.Direction

trait ElevatorApi {
  def getFloor: Int

  def getDirection: Direction.type

  def getId: Int

  def getStatus: String

  def addFloorToVisit(destFloor: Int): Unit

  def step(): Unit
}
