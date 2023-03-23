import System.Elevator.Elevator
import System.Utils.{DOWN, Direction, Pickup, STILL, UP}
import org.scalatest.funsuite.AnyFunSuite

class ElevatorTests extends AnyFunSuite{
  test("moving") {
    val elevator: Elevator = new Elevator(1, 0, STILL,10, null)
    elevator.moveUp()
    elevator.moveUp()
    assert(elevator.getFloor == 2)
  }

  test("changing direction") {
    val elevator: Elevator = new Elevator(1, 0, STILL, 10, null)
    elevator.addNewPickup(Pickup(10,DOWN, 0))
    elevator.step()
    assert(elevator.getDirection == UP)
  }
}
