// I did not receive any outside help on this assignment.

package Assignment03;

import R2LearnsJava.*;

public class Assignment03 extends Main {

    //CONSTANTS

    //IVARS
    private R2 r2;

    //CONSTRUCTORS

    //GETTERS

    //SETTERS

    //OTHER METHODS
    @Override
    public String getWorldUrl() {
        return "worlds/clearhurdle.world";
    }

    @Override
    public void runCommands() {
        r2 = new R2("R2", 0, 0, Dir.EAST, 0);
        r2.spawn();
        move(3);
        clearHurdle();
        move(4);
    }

    /**
     * This method allows R2 to clear a vertical hurdle of any height.
     * <p>
     * Precondition: R2 has been spawned in the world and is adjacent to the bottom of the hurdle, facing east.
     * Additionally, R2 should be on the left of the hurdle.
     * <p>
     * Postcondition: R2 is adjacent to the bottom of the hurdle on the right, and is facing east.
     */
    private void clearHurdle() {
       climbUpHurdle();
       climbDownHurdle();
    }

    /**
     * This method allows R2 to climb over the top of a vertical hurdle of any height.
     * <p>
     * Precondition: R2 has been spawned in the world and is adjacent to the bottom of the hurdle, facing east. R2
     * should be on the left side of the hurdle.
     * <p>
     * Postcondition: R2 is on the square directly above the top of the hurdle, facing east.
     */
    private void climbUpHurdle() {
        // Before moving, R2 always checks to see if there is still a wall to its right.
        // This means that it will know when it has cleared the hurdle.
        while (r2.frontIsBlocked()) {
            r2.turnLeft();
            r2.move();
            r2.turnRight();
        }
    }

    /**
     * This method allows R2 to climb down the right side of a vertical hurdle of any height until it reaches the bottom.
     * <p>
     * Precondition: R2 has been spawned and is on the square directly above the top of the hurdle, facing east.
     * <p>
     * Postcondition: R2 is adjacent to the bottom of the hurdle on the right, and is facing east.
     */
    private void climbDownHurdle() {
        // Get R2 on the right side of the hurdle, facing south.
        r2.move();
        r2.turnRight();
        // Move to the bottom.
        while (r2.frontIsClear()) {
            r2.move();
        }
        // Turn so R2 is facing east.
        r2.turnLeft();
    }

    /**
     * Causes an instance of the R2 class to move a specified number of spaces in the direction it is currently facing.
     * <p>
     * Precondition: An instance of the R2 class has been spawned.
     * <p>
     * Postcondition: The R2 object has moved the specified number of spaces in whatever direction it is facing, unless
     * it runs into an obstacle, causing it crash.
     * @param numSpaces the number of spaces which R2 will move
     */
    private void move(int numSpaces) {
        for (int i = 0; i < numSpaces; i++) {
            r2.move();
        }
    }

} //END OF CLASS
