/*
 * I did not get any outside help when writing the methods in this code file. However, I did get help with writing
 * methods in the R2PlusPlus class, and this is documented in the class.
 * The methods from the R2PlusPlus class which I used here are:
 * turnInDirection, pickUpFlashlight, move, and clearHurdle. I did not create two methods (clearLeftHurdle and
 * clearRightHurdle) because you said that it was okay to create one instead.
 */

package Assignment;

import R2LearnsJava.*;

public class Assignment extends Main {

    //CONSTANTS

    //IVARS
    private R2PlusPlus r2;

    //CONSTRUCTORS

    //GETTERS

    //SETTERS

    //OTHER METHODS
    @Override
    public String getWorldUrl() {
        return "worlds/hurdles.world";
    }

    @Override
    public void runCommands() {
        r2 = new R2PlusPlus("R2++", 0, 0, Dir.EAST, 0);
        r2.spawn();
        // Get to the right edge of the screen and record the action so R2++ can repeat it.
        moveAndClearHurdles();
        // Turn around and get the flashlight
        r2.turnInDirection(Dir.WEST);
        r2.pickUpFlashlight();
        // Move back to the goal
        moveAndClearHurdles();
    }

    /**
     * This method allows R2++ to move and clear any number of vertical, upward-facing hurdles until reaching a
     * flashlight or a goal space at (0, 0).
     * <p>
     * Precondition: R2++ has been spawned and is facing towards a series of vertical, upward-facing hurdles. There is
     * a single flashlight at the east wall of the world and the goal space is at (0, 0).
     * <p>
     * Postcondition: R2++ has cleared all the hurdles, stopping either because it has reached a flashlight or has
     * reached (0, 0).
     */
    private void moveAndClearHurdles() {
        while (true) {
            if (r2.frontIsClear()) {
                r2.move();
            } else if (atHurdle()) {
                r2.clearHurdle(Dir.NORTH);
            } else {
                break;
            }
        }
    }

    /**
     * This method checks to see if R2++ has reached a hurdle, returning true if it determines the answer is yes and
     * false otherwise.
     * <p>
     * Precondition: R2++ has been spawned, there is a goal space at (0, 0), and there is a flashlight at the east wall
     * of the world.
     * <p>
     * Postcondition: A boolean value expressing whether or not R2++ is at a hurdle has been returned.
     * @return a boolean expressing whether or not R2++ has reached a hurdle
     */
    private boolean atHurdle() {
        return (r2.frontIsBlocked() && !(atGoal() && r2.getDirection() == Dir.WEST) && !r2.hasFlashlight());
    }

    /**
     * This method checks to see if R2++ has reached a goal, returning true if the answer is yes and false otherwise.
     * <p>
     * Precondition: R2++ has been spawned and the goal space for the world is (0, 0).
     * <p>
     * Postcondition: A boolean value has been returned indicating if R2++ is at the goal space or not.
     * @return a boolean value expressing whether or not R2++ is at the goal space
     */
    private boolean atGoal() {
        return (r2.getX() == 0 && r2.getY() == 0);
    }
} //END OF CLASS
