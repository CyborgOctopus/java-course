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
        return "worlds/placeholder.world";
    }

    @Override
    public void runCommands() {
        r2 = new R2PlusPlus("R2++", 0, 0, Dir.EAST, 0);
        r2.spawn();
    }

} //END OF CLASS