/* I received help on how to do Javadoc comments from
http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html#format
I know what the modulus '%' operator is and how it is used to test for even numbers from past programming experience. */

package Assignment02;

import R2LearnsJava.*;

public class Assignment02 extends Main {

    //CONSTANTS

    //IVARS
    private R2 r2;
    private boolean pickUpFlashlights = false;

    //CONSTRUCTORS

    //GETTERS

    //SETTERS

    //OTHER METHODS
    @Override
    public String getWorldUrl() {
        return "worlds/assignment02.world";
    }

    @Override
    public void runCommands() {
        r2 = new R2("R2", 1, 1, Dir.EAST, 0);
        r2.spawn();
        // Run ten laps around the rectangle
        traverseRectangularPath(40, 7, 5);
        // Run around the rectangle and collect flashlights
        pickUpFlashlights = true;
        traverseRectangularPath(4, 7, 5);
        // Move to the goal
        traverseRectangularPath(2, 8, 7);
    }

    /**
     * Allows R2 to move along a rectangular path whose size and shape is specified by rectSideLength1 and rectSideLength2.
     * R2 will begin moving along the side with rectSideLength1, so the two side lengths are not interchangeable.
     * Swapping the side lengths would produce a rectangle with different orientation.
     * R2 moves along the number of sides specified by numStraightLineMovements and turns when it reaches
     * the end of a rectangle's side.  Once it has moved along a straight line the number of times specified as it
     * traverses its rectangular path, it stops.
     * <p>
     * If pickUpFlashlights is true, R2 picks up one flashlight on all spaces containing flashlights which it occupies.
     * <p>
     * Precondition:  R2 has been spawned in the world.
     * <p>
     * Postcondition:  R2 has moved the amount specified by numStraightLineMovements along a rectangular path, or
     * has crashed at some point along its path due to an encounter with an obstacle.  If pickUpFlashlights is true,
     * R2 has also collected one flashlight on all spaces containing flashlights which it has visited.
     * @param numStraightLineMovements number of times R2 should move in a straight line as it moves according to a
     *                                 rectangular pattern
     * @param rectSideLength1          the side length which R2 travels first on the rectangular path
     * @param rectSideLength2          the side length which R2 travels second on the rectangular path
     */
    private void traverseRectangularPath(int numStraightLineMovements, int rectSideLength1, int rectSideLength2) {
        // Establishes a loop so that R2 will move along as many sides of the rectangle
        // as specified by the numStraightLineMovements variable.
        for (int i = 0; i < numStraightLineMovements; i++) {
            /* If the loop variable is even, R2 is on the side of the rectangle with length rectSideLength1.
                Otherwise, R2 is on the side with length rectSideLength2. It must move the appropriate number of spaces.
                The '-1' is due to the fact that we count R2's starting space as part of the rectangle, so R2 occupies
                one more than the number of spaces that it moves on a given side of the rectangle. */
            if (isEven(i)) {
                move(rectSideLength1 - 1);
            } else {
                move(rectSideLength2 - 1);
            }
            // After R2 moves along the path forming one side of the rectangle,
            // it must turn 90 degrees so that it can move along a path forming the next side.
            r2.turnLeft();
        }
    }

    /**
     * This method takes in a number and returns 'true' if the number is even, and 'false' otherwise.
     * <p>
     * Precondition:  The argument passed to this method must be an integer.
     * <p>
     * Postcondition:  The program will output 'true' or 'false' depending on whether the integer is even or odd.
     * @param num an integer of data type int
     * @return    a boolean value expressing whether or not the integer is even
     */
    private boolean isEven(int num) {
        return (num % 2 == 0);
    }

    /**
     * Causes an instance of the R2 class to move a specified number of spaces in the direction it is currently facing.
     * If pickUpFlashlights is true, it picks up one flashlight on every space that it moves over, if that space contains
     * any flashlights.
     * <p>
     * Precondition: An instance of the R2 class has been spawned.
     * <p>
     * Postcondition: The R2 object has either crashed at some point during its motion, or it has
     * moved the specified number of spaces in whatever direction it is facing.
     * If pickUpFlashlights is true, it has also picked up one flashlight on all spaces along its path
     * that contain flashlights.
     * @param numSpaces the number of spaces R2 will move
     */
    private void move(int numSpaces) {
        for (int i = 0; i < numSpaces; i++) {
            if (pickUpFlashlights) {
                getFlashlight();
            }
            r2.move();
        }
    }

    /**
     * Causes an instance of the R2 class to pick up a single flashlight on its current space, if there is one.
     * <p>
     * Precondition: An instance of the R2 class has been spawned.
     * <p>
     * Postcondition: R2 has collected any one of the flashlights on its space, or has done nothing if there are no
     * flashlights.
     */
    private void getFlashlight() {
        if (r2.hasFlashlight()) {
            r2.pickUpFlashlight();
        }
    }
} //END OF CLASS
