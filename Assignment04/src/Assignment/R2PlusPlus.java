/*
I recieved some help with saving projects as templates from the following sources:
https://www.jetbrains.com/help/idea/saving-projects-as-templates.html
I learned how to create empty statements here:
https://docstore.mik.ua/orelly/java-ent/jnut/ch02_06.htm
I learned how to use Java's Math.abs() method from here:
http://www.tutorialspoint.com/java/number_abs.htm
I know how to work with arrays due to prior programming experience.

R2PlusPlus image citations
--------------------
R2PlusPlus image Url (rotated to create east, west, north, and south):
http://www.hasbro.com/common/productimages/en_GB/4da6b67c50569047f51a5fe1c1604c0f/4DA7A7F150569047F5A773DB9F4502ED.jpg
Website where image was found:
https://www.hasbro.com/en-gb/product/star-wars-smart-r-2-d-2:4DA6B67C-5056-9047-F51A-5FE1C1604C0F

Crash (explosion) image Url: http://www.zoombd24.com/wp-content/uploads/2015/03/explo.png
Website where image was found:
http://www.zoombd24.com/how-flashback-arrestors-prevents-pressurized-gas-cylinders-from-explosion/

Flashlight image Url: http://tse4.mm.bing.net/th?id=OIP.QqKjgQs93w4-VPgMVGFUsgEsDh&pid=15.1
Website where image was found: https://technabob.com/blog/2011/09/05/wicked-lasers-spyder-iii-krypton-laser/
 */

package Assignment;

import R2LearnsJava.*;

public class R2PlusPlus extends R2 {

    //CONSTANTS
    private static final String EAST_IMAGE_URL = "images/R2++East.png";
    private static final String WEST_IMAGE_URL = "images/R2++West.png";
    private static final String NORTH_IMAGE_URL = "images/R2++North.png";
    private static final String SOUTH_IMAGE_URL = "images/R2++South.png";
    private static final String CRASH_IMAGE_URL = "images/R2++Crash.png";
    private static final String FLASHLIGHT_IMAGE_URL = "images/R2++Flashlight.png";

    //IVARS
    private boolean getFlashlight = false;
    private boolean getAllFlashlights = false;

    //CONSTRUCTORS

    /**
     * Constructor for the R2PlusPlus class.
     * <p>
     * Precondition: The R2 class has been imported from R2LearnsJava.
     * <p>
     * Postcondition: An instance of the R2PlusPlus class has been created with the specified attributes.
     * @param name           the name displayed for R2PlusPlus in the world
     * @param x              the x-coordinate of R2PlusPlus's starting position
     * @param y              the y-coordinate of R2PlusPlus's starting position
     * @param initDirection  the direction R2PlusPlus is facing in when it spawns
     * @param numFlashlights the number of flashlights that R2PlusPlus has
     */
    R2PlusPlus(String name, int x, int y, Dir initDirection, int numFlashlights) {
        super(name, x, y, initDirection, numFlashlights);
        this.setImages();
    }

    //GETTERS

    /**
     * This method gets the value of the instance variable 'getFlashlight'.
     * <p>
     * Precondition: An instance of the R2PlusPlus class has been created.
     * <p>
     * Postcondition: The value of R2PlusPlus's private variable 'getFlashlight' has been returned.
     * @return the boolean value of 'getFlashlight'
     */
    public boolean valueOfGetFlashlight() {
        return this.getFlashlight;
    }

    /**
     * This method gets the value of the instance variable 'getAllFlashlights'.
     * <p>
     * Precondition: An instance of the R2PlusPlus class has been created.
     * <p>
     * Postcondition: The value of R2PlusPlus's private variable 'getAllFlashlights' has been returned.
     * @return the boolean value of 'getAllFlashlights'
     */
    public boolean valueOfGetAllFlashlights() {
        return this.getAllFlashlights;
    }

    //SETTERS

    /**
     * This method sets the images of R2PlusPlus facing in all four directions, as well as the crash image and flashlight image.
     * <p>
     * Precondition: An instance of the R2PlusPlus class has been created.
     * <p>
     * Postcondition: The four directional images, a crash image, and a flashlight image have been set.
     */
    private void setImages() {
        R2Images images = new R2Images();
        images.setEastImageUrl("images/R2++East.png");
        images.setWestImageUrl("images/R2++West.png");
        images.setNorthImageUrl("images/R2++North.png");
        images.setSouthImageUrl("images/R2++South.png");
        images.setCrashImageUrl("images/R2++Crash.png");
        images.setFlashlightImageUrl("images/R2++Flashlight.png");
        this.setGraphics(images);
    }

    /**
     * This method sets the value of the 'getFlashlight' to the opposite of its current value.
     * <p>
     * Precondition: An instance of the R2PlusPlus class has been created.
     * <p>
     * Postcondition: The value of the boolean 'getFlashlight' is the opposite of its previous value.
     */
    public void toggleGetFlashlight() {
        this.getFlashlight = !this.getFlashlight;
    }

    /**
     * This method sets the value of 'getAllFlashlights' to the opposite of its current value.
     * <p>
     * Precondition: An instance of the R2PlusPlus class has been created.
     * <p>
     * Postcondition: The value of the boolean 'getAllFlashlights' is the opposite of its previous value.
     */
    public void toggleGetAllFlashlights() {
        this.getAllFlashlights = !this.getAllFlashlights;
    }


    //OTHER METHODS

    /**
     * This method accepts a one-dimensional array of ints. If the array has an odd number of elements, it displays a
     * message and quits because not all of the numbers in such an array can be paired.
     * If the array has an even number of elements, it interprets each pair of elements as the x-y coordinates of a
     * square, starting from the beginning of the array. It moves to all of the squares in succession, unless an
     * obstacle is encountered which causes it to crash. When moving to a square, it first makes any turns necessary and
     * moves the required x distance in a straight line. Then it makes any turns necessary and moves the required y
     * distance in a straight line. If 'getFlashlight' is 'true', it picks up one flashlight on every space containing
     * flashlights that it occupies. If 'getAllFlashlights' is 'true', it picks up all flashlights present on every
     * space containing flashlights that it occupies.
     * <p>
     * Precondition: An instance of the R2PlusPlus class has been spawned.
     * <p>
     * Postcondition: If the number of elements in the array is odd, a message has been printed to the console and
     * nothing else has happened. Otherwise, R2PlusPlus is on the square specified by the final two elements of the
     * 'coords' array, or has crashed due to an encounter with an obstacle. If the ending square is east or west of
     * R2PlusPlus's beginning square, then R2PlusPlus will end facing east or west, respectively. If the ending square
     * is north, northeast, or northwest of the beginning square, then R2PlusPlus will end facing north. If the ending
     * square is south, southeast, or southwest of the beginning square, then R2PlusPlus will end facing south. If the
     * ending square is the beginning square, then R2PlusPlus will end facing in whatever direction it was initially
     * facing. If 'getFlashlight' is true, it has picked up one flashlight on every space containing flashlights which
     * it has occupied. If 'getAllFlashlights' is 'true', it has picked up all flashlights present on every space
     * containing flashlights which it has occupied.
     * @param coords a one-dimensional array containing a list of x-y coordinates
     */
    public void moveToSquares(int[] coords) {
        if (isEven(coords.length)) {
            for (int i = 0; i < coords.length/2; i++) {
                    this.moveToSquare(coords[2*i], coords[2*i + 1]);
            }
        } else {
            System.out.println("Oops, you have an odd number of coordinates. They can't all form pairs!");
        }
    }

    /**
     * This method accepts a pair of ints interpreted as the x and y coordinates of a square. It moves to this square,
     * unless it encounters an obstacle which causes it to crash. When moving to a square, it first makes any turns
     * necessary and moves the required x distance in a straight line. Then it makes any turns necessary and moves the
     * required y distance in a straight line. If 'getFlashlight' is 'true', it picks up one flashlight on every space
     * containing flashlights that it occupies. If 'getAllFlashlights' is 'true', it picks up all flashlights present on
     * every space containing flashlights that it occupies.
     * <p>
     * Precondition: An instance of the R2PlusPlus class has been spawned.
     * <p>
     * Postcondition: R2PlusPlus is on the square specified by the 'x' and 'y' variables, or has crashed due to an
     * encounter with an obstacle. If the ending square is east or west of R2PlusPlus's beginning square, then
     * R2PlusPlus will end facing east or west, respectively. If the ending square is north, northeast, or northwest of
     * the beginning square, then R2PlusPlus will end facing north. If the ending square is south, southeast, or
     * southwest of the beginning square, then R2PlusPlus will end facing south. If the ending square is the beginning
     * square, then R2PlusPlus will end facing in whatever direction it was initially facing. If 'getFlashlight' is true,
     * it has picked up one flashlight on every space containing flashlights which it has occupied. If
     * 'getAllFlashlights' is 'true', it has picked up all flashlights present on every space containing flashlights
     * which it has occupied.
     * @param x the x-coordinate of the square that R2PlusPlus will move to
     * @param y the y-coordinate of the square that R2PlusPlus will move to
     */
    public void moveToSquare(int x, int y) {
        int x_distance = x - super.getX();
        Dir x_dir = Dir.EAST;
        int y_distance = y - super.getY();
        Dir y_dir = Dir.NORTH;

        if (x_distance < 0) {
            x_dir = Dir.WEST;
        }
        if (y_distance < 0) {
            y_dir = Dir.SOUTH;
        }

        // The check to make sure that the distances aren't zero is done to prevent unnecessary turning.
        if (x_distance != 0) {
            this.turnInDirection(x_dir);
            this.move(Math.abs(x_distance));
        }
        if (y_distance != 0) {
            this.turnInDirection(y_dir);
            this.move(Math.abs(y_distance));
        }
    }

    /**
     * Causes an instance of the R2PlusPlus class to turn in a direction with the fewest number of turns possible.
     * <p>
     * Precondition: An instance of the R2PlusPlus class has been spawned.
     * <p>
     * Postcondition: R2PlusPlus is facing in the direction specified by the variable 'dir'.
     * @param dir the direction to which R2PlusPlus should turn
     */
    public void turnInDirection(Dir dir) {
        if (areDirsOpposite(super.getDirection(), dir)) {
            super.turnLeft();
            super.turnLeft();
        } else if (this.isDirLeftOfCurrentDir(dir)) {
            super.turnLeft();
        // The condition 'super.getDirection() != dir' is included so that R2PlusPlus doesn't turn if it's already
        // facing in the right direction.
        } else if (super.getDirection() != dir){
            super.turnRight();
        }
    }

    /**
     * Causes an instance of the R2PlusPlus class to move a specified number of spaces in the direction it is currently
     * facing, unless it encounters an obstacle which causes it to crash. If 'getFlashlight' is 'true', it picks up one
     * flashlight on every space containing a flashlight that it occupies. If 'getAllFlashlights' is 'true', it picks up
     * all flashlights present on every space containing flashlights that it occupies.
     * <p>
     * Precondition: An instance of the R2PlusPlus class has been spawned.
     * <p>
     * Postcondition: The R2PlusPlus object has moved the specified number of spaces in whatever direction it is facing,
     * unless it runs into an obstacle, causing it crash. If 'getFlashlight' is 'true', it has picked up one flashlight
     * on every space containing flashlights which it has occupied. If 'getAllFlashlights' is 'true', it has picked up
     * all flashlights on every space containing flashlights which it has occupied.
     * @param numSpaces the number of spaces which R2PlusPlus will move
     */
    public void move(int numSpaces) {
        // The loop runs one extra time so that the flashlight on the final square is picked up.
        for (int i = 0; i < numSpaces + 1; i++) {
            if (getFlashlight) {
                this.pickUpFlashlight();
            } else if (getAllFlashlights) {
                this.pickUpAllFlashlights();
            }
            // Only move if R2PlusPlus isn't on the final square yet.
            if (i < numSpaces) {
                super.move();
            }
        }
    }

    /**
     * Causes an instance of the R2PlusPlus class to pick up a single flashlight on its current space, if there is one.
     * <p>
     * Precondition: An instance of the R2PlusPlus class has been spawned.
     * <p>
     * Postcondition: R2PlusPlus has collected one of the flashlights on its space, or has done nothing if there are no
     * flashlights.
     */
    public void pickUpFlashlight() {
        if (hasFlashlight()) {
            super.pickUpFlashlight();
        }
    }

    /**
     * Causes an instance of the R2PlusPlus class to pick up all flashlights on its current space. If there are none,
     * it does nothing.
     * <p>
     * Precondition: An instance of the R2PlusPlus class has been spawned.
     * <p>
     * Postcondition: R2PlusPlus has collected all of the flashlights on its space, or has done nothing if there are no
     * flashlights.
     */
    public void pickUpAllFlashlights() {
        while (hasFlashlight()) {
            super.pickUpFlashlight();
        }
    }

    /**
     * Causes R2PlusPlus to place a specified number of flashlights.
     * <p>
     * Precondition: R2PlusPlus has been spawned in the world and is in possession of a number of flashlights greater
     * than or equal to 'numFlashlights'.
     * <p>
     * Postcondition: R2PlusPlus has placed the specified number of flashlights on the square it is currently occupying.
     * @param numFlashlights the number of flashlights for R2PlusPlus to place
     */
    public void placeFlashlights(int numFlashlights) {
        for (int i = 0; i < numFlashlights; i++) {
            super.placeFlashlight();
        }
    }

    /**
     * This method reveals whether two specified directions are opposite each other.
     * <p>
     * Precondition: An instance of the R2PlusPlus class has been created and the Dir enumerated
     * type has been imported from R2LearnsJava.
     * <p>
     * Postcondition: The method has returned 'true' if 'dir1' and 'dir2' are opposite each other, and 'false' otherwise.
     * @param dir1 one of the two directions to be compared
     * @param dir2 one of the two directions to be compared
     * @return a boolean value indicating whether or not 'dir1' and 'dir2' are opposites.
     */
    private boolean areDirsOpposite(Dir dir1, Dir dir2) {
        // Must run through twice so that the dirs can be swapped, in order to cover a case where
        // dir1 is East and dir2 is West, for example.
        for (int i = 0; i < 2; i++) {
            if ((dir1 == Dir.WEST && dir2 == Dir.EAST) || (dir1 == Dir.SOUTH && dir2 == Dir.NORTH)) {
                return true;
            }
            // Swap dirs
            Dir newDir1 = dir2;
            Dir newDir2 = dir1;
            dir1 = newDir1;
            dir2 = newDir2;
        }
        return false;
    }

    /**
     * This method indicates whether or not R2PlusPlus must make a single left turn to be facing in the specified
     * direction.
     * <p>
     * Precondition: An instance of the R2PlusPlus class has been spawned.
     * <p>
     * Postcondition: If R2PlusPlus can face in the direction 'dir' by making one left turn, the method has returned
     * 'true'. Otherwise, it has returned 'false'.
     * @param dir the direction with which R2PlusPlus is being tested
     * @return a boolean value expressing whether or not R2PlusPlus can end up facing in the direction 'dir' by making
     * a single left turn.
     */
    private boolean isDirLeftOfCurrentDir(Dir dir) {
        Dir currentDir = super.getDirection();

        return ((dir == Dir.WEST  && currentDir == Dir.NORTH)
                || (dir == Dir.NORTH && currentDir == Dir.EAST)
                || (dir == Dir.EAST && currentDir == Dir.SOUTH)
                || (dir == Dir.SOUTH && currentDir == Dir.WEST));
    }

    /**
     * This method takes in a number and returns 'true' if the number is even, and 'false' otherwise.
     * <p>
     * Precondition:  An instance of the R2PlusPlus class has been created and the argument passed to this method is an
     * integer.
     * <p>
     * Postcondition:  The program will output 'true' or 'false' depending on whether the integer is even or odd.
     * @param x an integer which will be tested for evenness
     * @return a boolean value expressing whether or not the integer is even
     */
    private boolean isEven(int x) {
        return (x % 2 == 0);
    }

} //END OF CLASS
