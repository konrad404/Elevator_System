package System.ElevatorMenagment

import System.Elevator.{Elevator, ElevatorApi}
import System.Utils.{Direction, Pickup, STILL}

import scala.collection.mutable

object ElevatorSystem {

}

class ElevatorSystem(elevatorsNumber: Int, floors: Int){

  val observer = new Observer()

  var elevators: mutable.Set[ElevatorApi] = (for (i <- 0 until elevatorsNumber)
    yield new Elevator(i, 0, STILL, floors, observer)).to(collection.mutable.Set)

  observer.addElevatorSet(elevators)

  def pickup(floor: Int, num: Int, dest: Int): Unit = {
    observer.addPickup(Pickup(floor, Direction.mapIntToDirection(num), dest))
  }


  def elevatorDistance(pickup: Pickup, elevator: ElevatorApi): Int = (pickup.floor - elevator.getFloor).abs

  def getBestElevator(pickup: Pickup): ElevatorApi = {
    var bestElevator:ElevatorApi = null
    var bestElevatorDist: Int = Int.MaxValue

    elevators.foreach(elevator =>{
      if(elevator.isPickupPossible(pickup) && elevatorDistance(pickup, elevator) < bestElevatorDist){
        bestElevator = elevator
        bestElevatorDist = elevatorDistance(pickup, elevator)
      }
    })

    bestElevator
  }

  def checkPickups(): Unit = {
    val awaitingPickups = observer.getPickups
    val newAwaitingPickups: mutable.Set[Pickup] = mutable.Set()

    awaitingPickups.foreach(pickup =>{
      val elevator: ElevatorApi = getBestElevator(pickup)
      if(elevator != null) elevator.addNewPickup(pickup)
      else newAwaitingPickups.add(pickup)
    })

    observer.setPickups(newAwaitingPickups)
  }

  def update(elevatorId: Int, floor: Int, direction: Direction): Unit = {
    elevators.foreach(elevator => if (elevator.getId == elevatorId) {
        if (floor > 0 && floor <= this.floors)  elevator.setFloor(floor)
        elevator.setDirection(direction)
      })
  }

  def step(): Unit = {
    checkPickups()
    elevators.foreach(elevators => elevators.step())
  }

  def status(): Array[String] = elevators.toArray.map(elevator => elevator.getStatus)

  def printStatus(): Unit = {
    println(status().mkString("Array(", ", ", ")"))
  }


}