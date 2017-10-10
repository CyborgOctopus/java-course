// I did not get any help writing this program except that documented in the R2PlusPlus class file.

package Assignment;

import R2LearnsJava.*;

public class Assignment extends Main {
    //CONSTANTS

    //IVARS
    private R2PlusPlus firstR2;
    private R2PlusPlus secondR2;
    private R2PlusPlus thirdR2;
    private R2PlusPlus fourthR2;

    //CONSTRUCTORS

    //GETTERS

    //SETTERS

    //OTHER METHODS
    @Override
    public String getWorldUrl() {
        return "worlds/relay.world";
    }

    @Override
    public void runCommands() {
        firstR2 = new R2PlusPlus("R2++#1", 0, 1, Dir.NORTH, 0);
        firstR2.spawn();
        secondR2 = new R2PlusPlus("R2++#2", 12, 1, Dir.NORTH, 0);
        secondR2.spawn();
        thirdR2 = new R2PlusPlus("R2++#3", 0, 0, Dir.NORTH, 0);
        thirdR2.spawn();
        fourthR2 = new R2PlusPlus("R2++#4", 12, 0, Dir.NORTH, 0);
        fourthR2.spawn();

        firstR2ToStartPos();
        runRelay(firstR2);
        firstR2ToEndPos();

        secondR2ToStartPos();
        runRelay(secondR2);
        secondR2ToEndPos();

        thirdR2ToStartPos();
        runRelay(thirdR2);
        thirdR2ToEndPos();

        fourthR2ToStartPos();
        runRelay(fourthR2);
        fourthR2ToGoal();
    }

    /**
     * Causes firstR2 to move to its starting position.
     * <p>
     * Precondition: firstR2 has been spawned at position (0, 1).
     * <p>
     * Postcondition: firstR2 is at its starting position at (0, 3).
     */
    private void firstR2ToStartPos() {
        firstR2.move(2);
    }

    /**
     * Causes secondR2 to move to its starting position.
     * <p>
     * Precondition: secondR2 has been spawned at position (12, 1).
     * <p>
     * Postcondition: secondR2 is at its starting position at (12, 3).
     */
    private void secondR2ToStartPos() {
        secondR2.move(2);
    }

    /**
     * Causes thirdR2 to move to its starting position.
     * <p>
     * Precondition: thirdR2 has been spawned at position (0, 0).
     * <p>
     * Postcondition: thirdR2 is at its starting position at (0, 3).
     */
    private void thirdR2ToStartPos() {
        thirdR2.move(3);
    }

    /**
     * Causes fourthR2 to move to its starting position.
     * <p>
     * Precondition: fourthR2 has been spawned at position (12, 0).
     * <p>
     * Postcondition: fourthR2 is at its starting position at (12, 3).
     */
    private void fourthR2ToStartPos() {
        fourthR2.move(3);
    }

    /**
     * Causes firstR2 to move to its ending position.
     * <p>
     * Precondition: firstR2 has run the relay and is at position (0, 3).
     * <p>
     * Postcondition: firstR2 has ended at position (12, 6).
     */
    private void firstR2ToEndPos() {
        firstR2.moveToSquare(12, 6);
    }

    // moveNorth is included in these methods so that R2++ moves above the walls of the relay
    // and consequently doesn't crash when moveToSquare is invoked.

    /**
     * Causes secondR2 to move to its ending position.
     * <p>
     * Precondition: secondR2 has run the relay and is at position (12, 3).
     * <p>
     * Postcondition: secondR2 has ended at position (11, 6).
     */
    private void secondR2ToEndPos() {
        moveNorth(secondR2);
        secondR2.moveToSquare(11, 6);
    }

    /**
     * Causes thirdR2 to move to its ending position.
     * <p>
     * Precondition: thirdR2 has run the relay and is at position (0, 3).
     * <p>
     * Postcondition: thirdR2 has ended at position (10, 6).
     */
    private void thirdR2ToEndPos() {
        moveNorth(thirdR2);
        thirdR2.moveToSquare(10, 6);
    }

    /**
     * Causes fourthR2 to move to its ending position.
     * <p>
     * Precondition: fourthR2 has run the relay and is at position (12, 3).
     * <p>
     * Postcondition: fourthR2 has reached the goal at position (9, 6).
     */
    private void fourthR2ToGoal() {
        moveNorth(fourthR2);
        fourthR2.moveToSquare(9, 6);
    }

    /**
     * Allows an instance of the R2PlusPlus class to run a horizontal relay of length 12, picking up a flashlight at
     * one end and placing it at the other end.
     * <p>
     * Precondition: A spawned instance of the R2PlusPlus class has been passed to the method and is at its starting
     * position for the relay.
     * <p>
     * Postcondition: The instance of R2PlusPlus is back where it started and has taken a flashlight from the other end
     * of the relay and placed it at this starting position.
     * @param r2 the instance of the R2PlusPlus class which will run the relay
     */
    private void runRelay(R2PlusPlus r2) {
        turnTowardsFlashlight(r2);
        // Run the relay and pick up the flashlight.
        r2.move(12);
        r2.pickUpFlashlight();
        // Turn around.
        turnAround(r2);
        // Run the relay again and place the flashlight.
        r2.move(12);
        r2.placeFlashlight();
    }

    /**
     * Causes an instance of the R2PlusPlus class passed to it to turn in the proper direction in order to run a
     * horizontal relay with a flashlight at one end.
     * <p>
     * Precondition: A spawned instance of the R2PlusPlus class has been passed to the method and is facing north at
     * its proper starting position for the race.
     * <p>
     * Postcondition: The instance of R2PlusPlus has turned towards the flashlight at the other end of the relay and is
     * facing in the proper direction to run the race.
     * @param r2 the instance of R2PlusPlus which will turn
     */
    private void turnTowardsFlashlight(R2PlusPlus r2) {
        // Turn in the proper direction.
        if (r2.getX() == 0) {
            r2.turnRight();
        } else {
            r2.turnLeft();
        }
    }

    /**
     * Causes an instance of the R2PlusPlus class to turn in the direction opposite of that in which it is currently
     * facing.
     * <p>
     * Precondition: A spawned instance of the R2PlusPlus class has been passed to the method.
     * <p>
     * Postcondition: The instance of R2PlusPlus has turned in the direction opposite to the one in which it is
     * currently facing.
     * @param r2 the instance of R2PlusPlus which will turn
     */
    private void turnAround(R2PlusPlus r2) {
        r2.turnInDirection(r2.oppositeOf(r2.getDirection()));
    }

    /**
     * Causes an instance of the R2PlusPlus class to turn north and move one space.
     * <p>
     * Precondition: A spawned instance of the R2PlusPlus class is passed to the method.
     * <p>
     * Postcondition: The instance of R2PlusPlus has turned north and then either moved one space or crashed due to an
     * encounter with an obstacle.
     * @param r2 the instance of R2PlusPlus which will turn and move
     */
    private void moveNorth(R2PlusPlus r2) {
        r2.turnInDirection(Dir.NORTH);
        r2.move();
    }

} //END OF CLASS