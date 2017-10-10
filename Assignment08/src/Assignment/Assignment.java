// I have not received any outside help on this assignment besides that documented in the R2PlusPlus class file.

package Assignment;

import R2LearnsJava.*;

public class Assignment extends Main {
    //CONSTANTS

    //IVARS
    private R2PlusPlus[] squad;

    //CONSTRUCTORS

    //GETTERS

    //SETTERS

    //OTHER METHODS
    @Override
    public String getWorldUrl() {
        return "worlds/army.world";
    }

    @Override
    public void runCommands() {
        //create the squad of R2PlusPluses
        squad = new R2PlusPlus[10];
        //place a new R2PlusPlus in each position of the squad
        fillTheRanks(squad);
        //pick up all flashlights
        clearTheField(squad);
    }

    /**
     * This method fills an array of type R2PlusPlus[] with instances of the R2PlusPlus class, and then spawns all of
     * the R2PlusPluses. The R2PlusPluses are spawned in a column at the left side of the world.
     * <p></p>
     * Precondition: An array of type R2PlusPlus[] has been passed to the method.
     * <p></p>
     * Postcondition: The array has been filled with instances of the R2PlusPlus class. All of these instances have
     * been spawned in a column at the left edge of the world, or the program has failed because there are more
     * instances than spaces in the column.
     * @param squad the array of type R2PlusPlus[] which will be filled
     */
    private void fillTheRanks(R2PlusPlus[] squad) {
        for (int i = 0; i < squad.length; i++) {
            squad[i] = new R2PlusPlus("RoboSoldier " + i, 0, i, Dir.EAST, 0);
            squad[i].spawn();
        }
    }

    /**
     * Causes the R2PlusPlus squad to advance across the field and pick up all flashlights that it finds.
     * <p></p>
     * Precondition: All members of the squad have been spawned and are lined up in a single column, facing the same
     * direction, at one end of the world. There are enough R2PlusPluses to fill every space in a single column of the
     * world.
     * <p></p>
     * Postcondition: The squad members are lined up at the opposite end of the world from where they started, facing
     * the same direction. All flashlights have been cleared from the world.
     * @param squad the array of R2PlusPluses which will move and pick up all of the flashlights
     */
    private void clearTheField(R2PlusPlus[] squad) {
        // Pick up the flashlights in the first column
        conquerColumn(squad);
        // March and pick up the rest of the flashlights
        while (squad[0].frontIsClear()) {
            forwardMarch(squad);
            conquerColumn(squad);
        }
    }

    /**
     * Allows the R2PlusPlus squad to move forward by one column.
     * <p></p>
     * Precondition: All members of the squad have been spawned.
     * <p></p>
     * Postcondition: All members of the squad have advanced one space in whatever direction they are facing, or one of
     * them has crashed due to an encounter with an obstacle, halting the program.
     * @param squad the array of R2PlusPluses whose members will advance
     */
    private void forwardMarch(R2PlusPlus[] squad) {
        for (R2PlusPlus r2 : squad) {
            r2.move();
        }
    }

    /**
     * Allows the R2PlusPlus squad to pick up all flashlights in its current column.
     * <p></p>
     * Precondition: All members of the squad have been spawned.
     * <p></p>
     * Postcondition: Each member of the squad has picked up all flashlights on its space.
     * @param squad the array of R2PlusPlus's to pick up the flashlights
     */
    private void conquerColumn(R2PlusPlus[] squad) {
        for (R2PlusPlus r2 : squad) {
            r2.pickUpAllFlashlights();
        }
    }

} //END OF CLASS