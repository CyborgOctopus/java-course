package MyPkg;

import R2LearnsJava.*;

public class Task5 extends Main {

    //CONSTANTS

    //IVARS
    private R2PlusPlus r2;

    //CONSTRUCTORS

    //GETTERS

    //SETTERS

    //OTHER METHODS
    @Override
    public String getWorldUrl() {
        return "worlds/task05.world";
    }

    @Override
    public void runCommands() {
        r2 = new R2PlusPlus("R2", 0, 0, Dir.EAST, 0);
        r2.spawn();
        r2.turnLeft();
        r2.move(3);
        r2.turnRight();
        r2.pickUpFlashlight();
        int numStacksDepleted = 0;
        while (numStacksDepleted < 2) {
            if (!r2.hasFlashlight()) {
                numStacksDepleted++;
            }
            r2.move(8);
            if (numStacksDepleted < 2) {
                r2.pickUpFlashlight();
                r2.turnLeft();
                r2.turnLeft();
            }
        }
        r2.turnRight();
        r2.move(4);

    }

} //END OF CLASS
