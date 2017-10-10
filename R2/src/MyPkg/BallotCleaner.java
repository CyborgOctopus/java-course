package MyPkg;

import R2LearnsJava.*;

// I got the idea for this exercise from https://see.stanford.edu/materials/icspmcs106a/10-section-handout-1.pdf

public class BallotCleaner extends Main {

    //CONSTANTS

    //IVARS
    private R2PlusPlus r2;

    //CONSTRUCTORS

    //GETTERS

    //SETTERS

    //OTHER METHODS
    @Override
    public String getWorldUrl() {
        return "worlds/ballotWorld.world";
    }

    @Override
    public void runCommands() {
        r2 = new R2PlusPlus("R2", 0, 2, Dir.EAST, 0);
        r2.spawn();
        while (r2.frontIsClear()) {
            r2.move();
            // Checks to see if R2 is on an odd numbered square.  If so, it's in a ballot and should clean.
            if (r2.getX() % 2 != 0) {
                cleanBallot();
            }
        }
    }

    // Allows R2 to clean a ballot as specified in the above link.  It first checks if the ballot needs cleaning.
    private void cleanBallot() {
        if (isBallotUsed()) {
            // Clean the top square of the ballot
            r2.turnLeft();
            r2.move();
            r2.pickUpAllFlashlights();

            // Move from top to bottom
            r2.turnRight(2);
            r2.move(2);

            // Clean the bottom square of the ballot
            r2.pickUpAllFlashlights();
            r2.turnLeft(2);
            r2.move();
            r2.turnRight();
        }
    }

    // Checks the middle square to see if the ballot has been used or not
    private boolean isBallotUsed() {
        return !r2.hasFlashlight();
    }

} //END OF CLASS
