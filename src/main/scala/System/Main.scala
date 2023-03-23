package System

import System.Elevator_Menagment.{ElevatorSystem, Pickup}
import System.Enums.{Direction, UP}

import scala.collection.mutable


object Main extends App{
  println("hello")

  val upNum = 1
  val downNum = -1

  println("Elevators number:")
  val elevatorsNumber = scala.io.StdIn.readInt()
  println("Floors:")
  val floors = scala.io.StdIn.readInt()

  val system: ElevatorSystem = new ElevatorSystem(elevatorsNumber,floors)

  system.printStatus()

  var stillGoing: Int = 0

  while (stillGoing == 0){
    println("1: do step; 2: pickup; 3: update elevator; 4: exit")
    val input = scala.io.StdIn.readLine().toInt
    input match {
      case 1 => system.step()
      case 2 => {
        println("floor:")
        val floor = scala.io.StdIn.readInt()
        println("up: 1, down: -1")
        val direction = scala.io.StdIn.readInt()
        println("destination:")
        val dest = scala.io.StdIn.readInt()
        system.pickup(floor, direction, dest)
      }
      case 3 => {
        println("elevatorId:")
        val id = scala.io.StdIn.readInt()
        println("floor:")
        val floor = scala.io.StdIn.readInt()
        println("direction: -1 -> DOWN; 0 -> STILL; 1 -> UP")
        val direction = scala.io.StdIn.readInt()
        system.update(id, floor, Direction.mapIntToDirection(direction))
      }
      case 4 => stillGoing = 1
      case _ => println("wrong command")
    }
    system.printStatus()
  }
}
