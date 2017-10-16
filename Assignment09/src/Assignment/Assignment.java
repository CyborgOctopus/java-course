// I did not receive any help on this assignment besides that documented in the R2PlusPlus class file.

package Assignment;

import R2LearnsJava.*;

public class Assignment extends Main {

    //CONSTANTS

    //IVARS

    //CONSTRUCTORS

    //GETTERS

    //SETTERS

    //OTHER METHODS
    @Override
    public String getWorldUrl() {
        return "worlds/labrynth.world";
    }

    @Override
    public void runCommands() {
        //instantiate and spawn the first R2
        R2PlusPlus firstR2 = new R2PlusPlus("FirstR2", 0, 0, Dir.EAST, 0);
        firstR2.spawn();
        //get firstR2 to the inside of the spiral
        runLeftSpiral(firstR2);

        //instantiate and spawn the second R2
        R2PlusPlus secondR2 = new R2PlusPlus("SecondR2", 9, 0, Dir.WEST, 0);
        secondR2.spawn();
        //get secondR2 to the inside of the spiral
        runRightSpiral(secondR2);

        //instantiate and spawn the third R2
        R2PlusPlus thirdR2 = new R2PlusPlus("ThirdR2", 0, 9, Dir.EAST, 0);
        thirdR2.spawn();
        //get third R2 to the goal
        goToGoal(thirdR2);
    }

    /**
     * Allows an instance of the R2PlusPlus class to traverse a spiral which twists to the left.
     * <p></p>
     * Precondition: A spawned instance of the R2PlusPlus class has been passed to the method. The instance is facing
     * towards a spiral which twists to the left.
     * <p></p>
     * Postcondition: R2PlusPlus has reached the center of the spiral and is facing one of the spiral's walls.
     * @param r2 the instance of the R2PlusPlus class which will traverse the spiral
     */
    private void runLeftSpiral(R2PlusPlus r2) {
        traverseSpiral(r2, Turn.LEFT);
    }

    /**
     * Allows an instance of the R2PlusPlus class to traverse a spiral which twists to the right.
     * <p></p>
     * Precondition: A spawned instance of the R2PlusPlus class has been passed to the method. The instance is facing
     * towards a spiral which twists to the right.
     * <p></p>
     * Postcondition: R2PlusPlus has reached the center of the spiral and is facing one of the spiral's walls.
     * @param r2 the instance of the R2PlusPlus class which will traverse the spiral
     */
    private void runRightSpiral(R2PlusPlus r2) {
        traverseSpiral(r2, Turn.RIGHT);
    }

    /**
     * Allows an instance of the R2PlusPlus class to move to the goal when starting at (0, 9) in the labrynth world.
     * <p></p>
     * Precondition: A spawned instance of the R2PlusPlus class has been passed to the method. This instance is spawned
     * in the labrynth world at location (0, 9).
     * <p></p>
     * Postcondition: R2PlusPlus has traversed the obstacles in order to reach the goal in the labrynth world.
     * @param r2 the instance of the R2PlusPlus class which will move to the goal
     */
    private void goToGoal(R2PlusPlus r2) {
        // Get to the winding path.
        r2.moveToSquare(9, 5);
        // Get through the winding path.
        traverseWindingPath(r2, 8);
        // Turn in the right direction.
        r2.turnInDirection(Dir.WEST);
        // Traverse the spiral to reach the goal.
        runRightSpiral(r2);
    }

    /**
     * Allows R2PlusPlus to traverse a winding path consisting of bars coming from opposite sides that form a snaking
     * pathway between them.
     * <p></p>
     * Precondition: A spawned instance of the R2PlusPlus class has been passed to the method, as well as an int
     * specifying how many straight line moves R2PlusPlus will make through the winding path. R2PlusPlus is in front of
     * a winding path which it is able to traverse in a snaking motion.
     * <p></p>
     * Postcondition: R2PlusPlus has moved along the winding path with the number of straight line movements specified
     * by 'numMoves'. Clarification: One straight line movement refers to a movement of any length in a straight line,
     * rather than some fixed length.
     * @param r2       the instance of the R2PlusPlus class which will traverse the winding path
     * @param numMoves the number of straight line movements which R2PlusPlus should take while traversing the winding
     *                 path
     */
    private void traverseWindingPath(R2PlusPlus r2, int numMoves) {
        for (int i = 0; i < numMoves; i++) {
            // The i % 4 < 2 condition makes sure that every other pair of turns is a pair of right turns. Pairs of
            // right and left turns alternate. The sequence is: right, right, left, left, right, right, left, left, ...
            if (i % 4 < 2) {
                r2.turnRight();
            } else {
                r2.turnLeft();
            }
            r2.moveUntilBlocked();
        }
    }

    /**
     * Allows R2PlusPlus to traverse a spiral by moving and making left turns or right turns, depending on the 'turn'
     * parameter.
     * <p></p>
     * Precondition: A spawned instance of the R2PlusPlus class has been passed to the method, as well as an instance
     * of the Turn enum. R2PlusPlus is facing towards a spiral which has the correct orientation so that it can be
     * traversed by turning in the specified direction.
     * <p></p>
     * Postcondition: R2PlusPlus has reached the center of the spiral, and is facing one of the spiral's walls.
     * @param r2   the instance of the R2PlusPlus class which will traverse the spiral
     * @param turn the direction in which R2PlusPlus should turn when it comes to the end of a coil of the spiral
     */
    private void traverseSpiral(R2PlusPlus r2, Turn turn) {
        while (r2.frontIsClear()) {
            r2.moveUntilBlocked();
            if (turn == Turn.LEFT) {
                r2.turnLeft();
            } else {
                r2.turnRight();
            }
        }
    }

    /**
     * An enumerated type expressing the two ways in which R2PlusPlus can turn, LEFT and RIGHT.
     */
    private enum Turn {
        LEFT, RIGHT;
    }
} //END OF CLASS

