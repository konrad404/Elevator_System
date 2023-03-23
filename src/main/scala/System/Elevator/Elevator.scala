package System.Elevator

import System.Elevator_Menagment.{Observer, Pickup}
import System.Enums.{DOWN, Direction, STILL, UP}

import scala.collection.mutable

object Elevator{

}

class Elevator (id: Int, startFloor: Int, startDirection: Direction, observer: Observer) extends ElevatorApi {
  var currFloor: Int = startFloor
  var pickup: Pickup = null
  val floorsToVisit : mutable.Set[Int] = mutable.Set()
  var direction: Direction = startDirection
  var nextFloor: Int = -1

  def getFloor: Int = currFloor

  def getDirection: Direction.type = Direction

  def getId: Int = id

//  TODO: elevator status
  def getStatus: String = "id: " + id.toString + " floor: " + currFloor.toString + " direction: " +  direction.toString

//  Dodanie nowego miejsca odbioru pasażerów dla widny
  def addNewDest(pickup: Pickup): Unit = this.pickup = pickup

  def passPickup(): Unit = {
    observer.passPickup(pickup)
    pickup = null
  }

  def isNewPickupCloser(pickup: Pickup): Boolean = {
    val oldPickupFloorDiff = this.pickup.floor - currFloor
    val newPickupFloorDiff = pickup.floor - currFloor
    direction match {
      case UP => newPickupFloorDiff > 0 && newPickupFloorDiff < oldPickupFloorDiff
      case DOWN => newPickupFloorDiff < 0 && newPickupFloorDiff > oldPickupFloorDiff
    }
  }

  def isNewPickupOnRoute(pickup: Pickup): Boolean = {
    direction match {
      case UP => pickup.floor > currFloor && pickup.floor < floorsToVisit.max
      case DOWN => pickup.floor < currFloor && pickup.floor > floorsToVisit.min
    }
  }

//  Dodanie nowego piętra docelowego z środka windy
  def addFloorToVisit(destFloor: Int): Unit = {
    if(floorsToVisit.isEmpty) direction = Direction.getDirectionToMove(currFloor, destFloor)
    if(Direction.getDirectionToMove(currFloor, pickup.floor) != direction) {
      passPickup()
    }
    if (!floorsToVisit.contains(destFloor)) floorsToVisit.add(destFloor)
  }

  def isPickupPossible(pickup: Pickup): Boolean = {
    if(direction == STILL) true
    else if (floorsToVisit.nonEmpty){
      isNewPickupOnRoute(pickup)
    }
    else{
      isNewPickupCloser(pickup)
    }
  }

  def moveUp(): Unit = {
    currFloor+=1
  }

  def moveDown(): Unit = {
    currFloor-=1
  }

  def open(): Unit = {
    if(floorsToVisit.contains(currFloor)) floorsToVisit -= currFloor
    if(pickup.floor == currFloor) pickup = null // pickup done
//    TODO: opening doors
  }


  def step(): Unit = {
//    TODO: check if you need to teke pasangers or make move
    if(floorsToVisit.contains(currFloor) || pickup.floor == currFloor) {
//      można tu dodać jakiś posób na opóźnienie
      open()
    }
    else{
      direction match {
        case UP => moveUp()
        case DOWN => moveDown()
      }
    }

  }

}
