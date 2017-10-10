package MyPkg;

import R2LearnsJava.*;

public class Task1 extends Main {

    //CONSTANTS

    //IVARS

    //CONSTRUCTORS

    //GETTERS

    //SETTERS

    //OTHER METHODS
    @Override
    public String getWorldUrl() {
        return "worlds/task01.world";
    }

    @Override
    public void runCommands() {
        R2 r2 = new R2("R2", 0, 0, Dir.EAST, 0);
        r2.spawn();
        r2.move();
        r2.move();
        r2.turnLeft();
        r2.move();
        r2.move();
    }

} //END OF CLASS
