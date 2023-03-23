package System.Elevator_Menagment

import System.Elevator.Elevator
import System.Enums.{Direction, STILL}

import scala.collection.mutable

object ElevatorSystem {

}

class ElevatorSystem(elevatorsNumber: Int, floors: Int, floorsPerStep: Int){

  val observer = new Observer()

  val elevators: mutable.Set[Elevator] = (for (i <- 0 until elevatorsNumber)
    yield new Elevator(i, 0, STILL, observer)).to(collection.mutable.Set)

  observer.addElevatorSet(elevators)

  def pickup(floor: Int, num: Int): Unit = {
//    observer.getElevatorForPickup(floor, Direction.mapIntToDirection(num)).addFloorToVisit(floor)
    observer.addPickup(Pickup(floor, Direction.mapIntToDirection(num)))
  }

  def checkPickups(): Unit = {
    val awaitingPickups = observer.getPickups()

    awaitingPickups.foreach(pickup =>{

    })
  }

  def update(elevatodId: Int, floor: Int, direction: Int, queue: mutable.Queue[Int] = mutable.Queue()): Unit = ???

  def step(): Unit = {
    checkPickups()

    elevators.foreach(elevators => elevators.step())
  }




//  TODO: moze coś w stylu elevator_status zamiast całej klasy?
  def status(): Array[String] = elevators.toArray.map(elevator => elevator.getStatus)

  def printStatus(): Unit = {
    println(status().mkString("Array(", ", ", ")"))
  }


}