package System

import System.Elevator_Menagment.{ElevatorSystem, Pickup}
import System.Enums.{Direction, UP}

import scala.collection.mutable


object Main extends App{
  println("hello")

  val floorsPerStep = 3

  val system: ElevatorSystem = new ElevatorSystem(5,12, floorsPerStep)

//  system.printStatus()
//
//  system.pickup(0,8)
//  system.step()
//  system.printStatus()
//
//  system.step()
//  system.printStatus()
//
//  system.pickup(2,9)
//  system.step()
//  system.printStatus()
//  system.step()
//  system.printStatus()
//  system.step()
//  system.printStatus()


}
