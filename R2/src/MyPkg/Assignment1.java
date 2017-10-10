package MyPkg;

import R2LearnsJava.*;

public class Assignment1 extends Main {

    //CONSTANTS

    //IVARS
    private R2 r2;

    //CONSTRUCTORS

    //GETTERS

    //SETTERS

    //OTHER METHODS
    @Override
    public String getWorldUrl() {
        return "worlds/assignment01.world";
    }

    @Override
    public void runCommands() {
        r2 = new R2("R2", 3, 5, Dir.EAST, 0);
        r2.spawn();
        moveToFlashlights();
        pickUpAllFlashlights();
        moveToGoal();
    }

    /**
     * Causes an instance of the R2 class to move to the space containing flashlights in the 'assignment01' world.
     * <p>
     * Precondition: An instance of the R2 class has been created and spawned in the 'assignment01' world at (3, 5),
     * facing east.
     * <p>
     * Postcondition: The R2 robot has moved onto the space containing the flashlights, which is (6, 3),
     * in the 'assignment01' world.
     */
    private void moveToFlashlights() {
        r2.turnRight();
        r2.move();
        r2.turnLeft();
        move(3);
        r2.turnRight();
        r2.move();
    }

    /**
     * Causes an instance of the R2 class to pick up all flashlights on its current space.
     * <p>
     * Precondition: An instance of the R2 class has been spawned.
     * <p>
     * Postcondition: R2 has collected all of the flashlights on its space.
     */
    private void pickUpAllFlashlights() {
        while (r2.hasFlashlight()) {
            r2.pickUpFlashlight();
        }
    }

    /**
     * Causes an instance of the R2 class on space (6, 3) of the 'assignment01' world to move to the goal and face east.
     * <p>
     * Precondition: An instance of the R2 class has been spawned, is facing south, and is on space (6, 3) in the
     * 'assignment01' world.
     * <p>
     * Postcondition: R2 has moved to the goal space and is facing east.
     */
    private void moveToGoal() {
        r2.turnRight();
        r2.turnRight();
        r2.move();
        r2.turnLeft();
        move(3);
        r2.turnLeft();
        r2.move();
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
