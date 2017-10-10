package MyPkg;

import R2LearnsJava.*;

public class SpiralSolver extends Main {

    //CONSTANTS

    //IVARS
    private R2 r2;

    //CONSTRUCTORS

    //GETTERS

    //SETTERS

    //OTHER METHODS
    @Override
    public String getWorldUrl() {return "worlds/spiralWorld.world";}

    @Override
    public void runCommands() {
        r2 = new R2("R2", 0,0, Dir.EAST, 0);
        r2.spawn();
        // In main spiral
        traverseSpiral(4, Turn.LEFT);

        // Special case (entering separate spiral)
        moveAndGetFlashlights(6);
        r2.turnLeft();

        // Traverse separate spiral, going in and back out
        traverseSpiral(4, Turn.LEFT);
        traverseSpiral(6, Turn.RIGHT);

        // Back in main spiral
        traverseSpiral(8, Turn.LEFT);
        r2.move();
    }

    // Allows R2 to go clockwise or counterclockwise around a spiral, making a set number of turns
    // and picking up flashlights as it goes.
    private void traverseSpiral(int numTurns, Turn turn) {
        int turnsCompleted = 0;
        while (turnsCompleted < numTurns) {
            flashlightCheck();
            if (r2.frontIsClear()) {
                r2.move();
            } else if (turn == Turn.LEFT) {
                r2.turnLeft();
                turnsCompleted++;
            } else {
                r2.turnRight();
                turnsCompleted++;
            }
        }
    }

    // Allows R2 to move any number of spaces, picking up flashlights as it goes.
    private void moveAndGetFlashlights(int numSpaces) {
        for (int i = 0; i < numSpaces; i++) {
            flashlightCheck();
            r2.move();
        }
    }

    // Checks if there is a flashlight on R2's current space.  If there is, picks it up.
    private void flashlightCheck() {
        if (r2.hasFlashlight()) {
            r2.pickUpFlashlight();
        }
    }

    // The two possible ways in which R2 could turn.
    private enum Turn {
        LEFT, RIGHT
    }

} //END OF CLASS
