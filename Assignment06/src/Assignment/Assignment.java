// I did not get any help writing this code, except for the help documented in the R2PlusPlus class file.

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
        return "worlds/pinball.world";
    }

    @Override
    public void runCommands() {
        r2 = new R2PlusPlus("R2++", 0, 2, Dir.EAST, 0);
        r2.spawn();
        clearFlashlights();
        bounceBetweenWalls(20);
    }

    /**
     * This method allows R2++ to bounce between two opposite walls a specified number of times.
     * <p>
     * Precondition: An instance of the R2++ class has been spawned and is between two walls. It is directly in front of
     * one of these walls, facing towards it.
     * <p>
     * Postcondition: R2++ has ended directly in front of, and facing, one of the walls. If 'numBounces' is even, it
     * ends back where it started. If 'numBounces' is odd, it ends opposite from where it started.
     * @param numBounces the number of times R2++ will bounce between the walls
     */
    private void bounceBetweenWalls(int numBounces) {
        // Bounce once and record the action
        r2.startRecordingActions(true);
        bounce();
        while (r2.frontIsClear()) {
            r2.move();
        }
        r2.stopRecordingActions();

        // Repeat the bouncing action 'numBounces - 1' more times, for a total of 'numBounces' bounces.
        r2.saveCurrentActionSequence("wallBounce");
        r2.clearCurrentActionSequence();
        r2.runActionSequence("wallBounce", numBounces - 1, false);
    }

    /**
     * This method allows R2++ to clear all of the flashlights in a horizontal track by bouncing between the flashlights
     * and the west wall.
     * <p>
     * Precondition: An instance of the R2PlusPlus class has been spawned inside a horizontal track with a west and
     * east wall.
     * <p>
     * Postcondition: Any flashlights in the track have been removed and R2++ is up against the east wall of the track,
     * facing east.
     */
    private void clearFlashlights() {
        while (true) {
            // Bounce of a flashlight.
            if (r2.hasFlashlight()) {
                r2.pickUpFlashlight();
                bounce();
            }

            // Bounce off west wall
            if (r2.frontIsBlocked()) {
                if (r2.getDirection() == Dir.EAST) {
                    break;
                }
                bounce();
            }

            // If there's nothing to bounce off of, then move.
            r2.move();
        }
    }

    /**
     * This method allows R2++ to "bounce off" an object by turning and facing in the opposite direction from the object.
     * <p>
     * Precondition: An instance of the R2PlusPlus class has been spawned
     * <p>
     * Postcondition: R2++ will be turned in the direction opposite the one it was originally facing in before the
     * method was called.
     */
    private void bounce() {
        r2.turnInDirection(r2.oppositeOf(r2.getDirection()));
    }

} //END OF CLASS