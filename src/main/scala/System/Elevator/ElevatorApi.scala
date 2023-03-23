package System.Elevator

import System.Utils.{Direction, Pickup}

trait ElevatorApi {
  def getFloor: Int

  def setFloor(floor: Int): Unit

  def getDirection: Direction

  def setDirection(direction: Direction): Unit

  def getId: Int

  def getStatus: String

  def addFloorToVisit(destFloor: Int): Unit

  def addNewPickup(pickup: Pickup): Unit

  def isPickupPossible(pickup: Pickup): Boolean

  def step(): Unit
}
