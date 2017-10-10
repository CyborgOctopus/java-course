package MyPkg;

import R2LearnsJava.*;

class R2PlusPlus extends R2 {

    //CONSTANTS

    //IVARS

    //CONSTRUCTORS
    R2PlusPlus(String name, int x, int y, Dir initDirection, int numFlashlights) {
        super(name, x, y, initDirection, numFlashlights);
    }

    //GETTERS

    //SETTERS

    //OTHER METHODS
    // This method allows R2 to move more than one space at a time
    void move(int numSpaces) {
        for (int i = 0; i < numSpaces; i++) move();
    }

    void turnLeft(int numTurns) {
        for (int i = 0; i < numTurns; i++) {
            turnLeft();
        }
    }

    void turnRight(int numTurns) {
        for (int i = 0; i < numTurns; i++) {
            turnRight();
        }
    }

    // This allows R2 to climb stairs moving up and to the right.  It assumes that R2 starts out facing east and that
    // each stair step is 1x1
    void climbStairs(int numStairs) {
        for (int i = 0; i < numStairs; i++) {
            turnLeft();
            move();
            turnRight();
            move();
        }
    }

    // Allows R2 to pick up every flashlight on a space by looping until there are no more
    void pickUpAllFlashlights() {
        while (hasFlashlight()) {
            pickUpFlashlight();
        }
    }

} //END OF CLASS
