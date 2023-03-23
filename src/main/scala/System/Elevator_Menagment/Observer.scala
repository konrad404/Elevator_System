package System.Elevator_Menagment

import System.Elevator.{Elevator, ElevatorApi}
import System.Enums.Direction

import scala.collection.mutable

object Observer {

}

class Observer(){
//  not needed?
  var pickups: mutable.Set[Pickup] = mutable.Set()

  var elevators: mutable.Set[ElevatorApi] = mutable.Set()

  def addElevator(elevator: ElevatorApi): Unit = elevators.add(elevator)

  def addElevatorSet(elevators: mutable.Set[ElevatorApi]): Unit = this.elevators = this.elevators ++ elevators

  def addPickup(pickup: Pickup): Unit = pickups.add(pickup)

  def getPickups: mutable.Set[Pickup] = pickups

  def setPickups(newPickups: mutable.Set[Pickup]): Unit = pickups = newPickups

  def passPickup(pickup: Pickup): Unit = if(!pickups.contains(pickup)) pickups.add(pickup)



}
