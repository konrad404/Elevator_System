package System.Elevator_Menagment

import System.Elevator.Elevator
import System.Enums.Direction

import scala.collection.mutable

object Observer {

}

class Observer(){
//  not needed?
  val pickups: mutable.Set[Pickup] = mutable.Set()

  var elevators: mutable.Set[Elevator] = mutable.Set()

  def addElevator(elevator: Elevator): Unit = elevators.add(elevator)

  def addElevatorSet(elevators: mutable.Set[Elevator]): Unit = this.elevators = this.elevators ++ elevators

  def updateElevator(elevator: Elevator): Unit = ???

  def addPickup(pickup: Pickup): Unit = pickups.add(pickup)

  def getElevatorForPickup(floor: Int, direction: Direction): Elevator = elevators.head

  def getPickups(): mutable.Set[Pickup] = pickups

  def passPickup(pickup: Pickup): Unit = if(!pickups.contains(pickup)) pickups.add(pickup)



}
