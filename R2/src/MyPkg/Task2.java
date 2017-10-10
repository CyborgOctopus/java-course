package MyPkg;

import R2LearnsJava.*;

public class Task2 extends Main {

    //CONSTANTS
    private R2 r2;

    //IVARS

    //CONSTRUCTORS

    //GETTERS

    //SETTERS

    //OTHER METHODS
    @Override
    public String getWorldUrl() {
        return "worlds/task02.world";
    }

    @Override
    public void runCommands() {
        r2 = new R2("R2", 0, 0, Dir.EAST, 0);
        r2.spawn();
        move(2);
        r2.turnLeft();
        move(2);
        r2.pickUpFlashlight();
        move(2);
        r2.turnRight();
        move(2);

    }

    // This method allows R2 to move more than one space at a time
    private void move(int numSpaces) {
        for (int i = 0; i < numSpaces; i++) r2.move();
    }

} //END OF CLASS
