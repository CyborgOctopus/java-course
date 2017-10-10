package MyPkg;

import R2LearnsJava.*;

public class Task4 extends Main {

    //CONSTANTS
    private R2PlusPlus r2;

    //IVARS

    //CONSTRUCTORS

    //GETTERS

    //SETTERS

    //OTHER METHODS
    @Override
    public String getWorldUrl() {
        return "worlds/task04.world";
    }

    @Override
    public void runCommands() {
        r2 = new R2PlusPlus("R2", 0, 0, Dir.EAST, 0);
        r2.spawn();
        r2.climbStairs(6);
        r2.pickUpAllFlashlights();
        r2.move(2);
    }

} //END OF CLASS
