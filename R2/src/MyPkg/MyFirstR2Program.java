package MyPkg;

import R2LearnsJava.*;

import java.util.Scanner;

public class MyFirstR2Program extends Main {

    //CONSTANTS

    //IVARS
    private R2PlusPlus r2;
    private String world;

    //CONSTRUCTORS
    public MyFirstR2Program() {
        // Use the world name supplied by the user.
        world = getWorldName();
    }

    //GETTERS

    //SETTERS

    //OTHER METHODS
    @Override
    public String getWorldUrl() {
        // Use the world entered by the user
        return "worlds/" + world + ".world";
    }

    @Override
    public void runCommands() {
        // Create an R2 object called 'R2', at point (0, 0), facing east, with zero flashlights.
        r2 = new R2PlusPlus("R2", 0, 0, Dir.EAST, 0);
       // spawn R2 in the world
        r2.spawn();
        // firstWorld
        if (getWorldUrl().equals("worlds/firstWorld.world")) {
            r2.move(2);
            r2.turnLeft();
            r2.move(2);
        }
        // stairWorld
        else if (getWorldUrl().equals("worlds/stairWorld.world")) {
            r2.climbStairs(6);
            r2.pickUpAllFlashlights();
            r2.move(2);

        }
    }


    // Let the user enter the name of the world which they want to run
    private String getWorldName() {
        System.out.println("Please enter a world name:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

} //END OF CLASS
