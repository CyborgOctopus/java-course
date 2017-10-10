// I am re-doing Assignment 2 with my new R2PlusPlus class.

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
        return "worlds/assignment02.world";
    }

    @Override
    public void runCommands() {
        r2 = new R2PlusPlus("R2++", 1, 1, Dir.EAST, 0);
        r2.spawn();
        runLaps();
        // R2++ moves to the goal at coordinates (8, 7).
        r2.moveToSquare(8, 7);
    }

    /**
     * This method allows R2++ to run 11 laps in the pattern of a rectangle with corners at (1, 1), (7, 1),
     * (7, 5), and (1, 5). On the 11th lap, R2++ picks up all flashlights along its path.
     * <p>
     * Precondition: R2++ has been spawned and is at square (1, 1). The world is large enough to permit R2++ to move in
     * the pattern of a rectangle with corners (1, 1), (7, 1), (7, 5), and (1, 5). There is one flashlight in every
     * square along R2++'s path.
     * <p>
     * Postcondition: R2++ is at square (1, 5), facing west. All of the flashlights along its path have been picked up.
     */
    private void runLaps() {
        // Number of laps R2++ should run.
        int numLaps = 11;
        // The corner coordinates for the rectangle that R2++ has to run laps around.
        int[] rect_corner_coords = {1, 1, 7, 1, 7, 5, 1, 5};
        for (int i = 0; i < numLaps; i++) {
            // R2++ should pick up all the flashlights on the last lap.
            if (i == 10) {
                r2.toggleGetFlashlight();
            }
            r2.moveToSquares(rect_corner_coords);
        }
    }

} //END OF CLASS
