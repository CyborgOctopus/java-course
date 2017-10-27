/* I gained some information about working with shapes from here:
https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/package-summary.html
I learned how to use a Polygon array from here:
https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Polygon.html
I learned how to use Math.cos and Math.PI from the built-in IntelliJ suggestions.
I learned how to use Shape.intersect and fix some issues from these sources:
https://stackoverflow.com/questions/41926786/why-does-the-resulting-shape-from-shape-intersect-appear-at-an-incorrect-
positio
https://docs.oracle.com/cd/E17802_01/javafx/javafx/1.2/docs/api/javafx.scene.shape/javafx.scene.shape.ShapeIntersect.
html
https://docs.oracle.com/javafx/2/api/javafx/scene/shape/Shape.html#intersect(javafx.scene.shape.Shape,
javafx.scene.shape.Shape)
https://stackoverflow.com/questions/20801114/javafx-shape-intersect-performance-issue
https://stackoverflow.com/questions/15013913/checking-collision-of-shapes-with-javafx
https://stackoverflow.com/questions/1563112/java-cannot-resolve-symbol
I learned what colors to use for the venn diagram from here:
https://en.wikipedia.org/wiki/RGB_color_model
I got an idea about how to add elements to an array with a for loop from here:
https://stackoverflow.com/questions/6018267/how-to-cast-from-listdouble-to-double-in-java
I learned how to use the Arc class from here:
https://docs.oracle.com/javase/9/docs/api/javafx/scene/shape/Arc.html
I learned how to create random numbers in Java from here:
https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
 */

package BasicGraphics;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class BasicGraphics extends Application {

    //CONSTANTS
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 500;

    //IVARS

    //CONSTRUCTORS

    //GETTERS

    //SETTERS

    //OTHER METHODS
    public void start(Stage primaryStage) {
        Pane background = new Pane();
        layout(background);
        primaryStage.setTitle("Lots of Shapes!");
        primaryStage.setScene(new Scene(background, WINDOW_WIDTH, WINDOW_HEIGHT));
        primaryStage.show();
    }

    /**
     * This method lays out the graphics in a Pane.
     * @param background the Pane that the graphics will be added to
     */
    private void layout(Pane background) {
        //build the shapes and then add them to the Pane

        //lopsided triangle
        double[] triangleCoords = {50.0, 100.0, 90.0, 90.0, 10.0, 43.0};
        Polygon triangle = new Polygon(triangleCoords);
        triangle.setStroke(Color.GREEN);
        triangle.setFill(Color.RED);

        // regular hexagon
        Polygon hexagon = generateRegPolygonWithinCircle(6, 40, 150, 50);
        hexagon.setStroke(Color.BLACK);
        hexagon.setFill(Color.CHARTREUSE);

        // regular decagon
        Polygon decagon = generateRegPolygonWithinCircle(10, 100, 480, 100);
        decagon.setStroke(Color.BLACK);
        decagon.setFill(Color.AQUA);

        // regular 1000-sided shape within decagon
        Polygon milligon = generateRegPolygonWithinCircle(1000, 50, 480, 100);
        milligon.setStroke(Color.WHITE);
        milligon.setFill(Color.CRIMSON);

        Rectangle randCirclesPicture = new Rectangle(0, 0, 600, 500);
        randCirclesPicture.setStroke(Color.TRANSPARENT);
        randCirclesPicture.setFill(Color.TRANSPARENT);
        // The random circles are drawn first so that everything else will be displayed in front of them.
        addRandomCirclesInRect(randCirclesPicture, background, 10000, 3);
        background.getChildren().addAll(triangle, hexagon, decagon, milligon);
        addIlluminati(background);
        addVennDiagram(background);
        addFullyConnectedGraph(background, 20, 150, 280, 80);
        addCube(background);
        addSunrise(background);
    }

    /**
     * Allows random circles to be drawn on the rectangular canvas specified by 'rect.'
     * @param rect       the rectangle on which the circles will be drawn
     * @param background the background Pane which contains the entire scene
     * @param numCircles the number of random circles to draw
     * @param maxRadius  the maximum radius of the random circles
     */
    private void addRandomCirclesInRect(Rectangle rect, Pane background, int numCircles, int maxRadius) {
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.VIOLET, Color.ORANGE};
        for (int i = 0; i < numCircles; i++) {
            int randRadius = (int)(maxRadius * Math.random());
            int randCenterX = (int)((rect.getWidth() - randRadius) * Math.random() + rect.getX());
            int randCenterY = (int)((rect.getHeight() - randRadius) * Math.random() + rect.getY());
            Color randColor = colors[(int)(6*Math.random())];
            Circle randCircle = new Circle(randCenterX, randCenterY, randRadius, randColor);
            background.getChildren().addAll(randCircle);
        }
    }

    /**
     * Adds a small image of the sun rising over mountains to the specified Pane.
     * @param background the Pane upon which the image will be displayed
     */
    private void addSunrise(Pane background) {
        // sun rising over mountains
        Rectangle sky = new Rectangle (50, 150, 100, 100);
        sky.setStroke(Color.DEEPSKYBLUE);
        sky.setFill(Color.DEEPSKYBLUE);
        Arc sun = new Arc(100, 250, 30, 30, 0, 180);
        sun.setStroke(Color.GOLD);
        sun.setFill(Color.GOLD);
        Polygon mountain1 = new Polygon(120, 250, 140, 250, 130, 220);
        Polygon mountain2 = new Polygon(110, 250, 130, 250, 120, 235);
        Line horizon = new Line(50, 250, 150, 250);
        background.getChildren().addAll(sky, sun, mountain1, mountain2, horizon);
    }

    /**
     * Creates a graph consisting of points (displayed in red) arranged in a circular pattern, and adds it to the
     * specified Pane. Every point is connected to every other point, so the graph is fully connected.
     * @param background    the Pane which the graph will be displayed on
     * @param numPoints     the number of points to include in the graph
     * @param graphDiameter distance from one side of the graph to the other. In other words, how big the graph appears
     *                      on the display.
     * @param centerX       the x-coordinate of the graph's center
     * @param centerY       the y-coordinate of the graph's center
     */
    private void addFullyConnectedGraph(Pane background, int numPoints, int graphDiameter, int centerX, int centerY) {
        Polygon graphTemplate = generateRegPolygonWithinCircle(numPoints, graphDiameter/2, centerX, centerY);
        graphTemplate.setStroke(Color.WHITE);
        graphTemplate.setFill(Color.WHITE);
        background.getChildren().addAll(graphTemplate);
        ObservableList<Double> points = graphTemplate.getPoints();
        addPoints(background, points);
        addLines(background, points);
    }

    /**
     * Adds points to the specified Pane. They are displayed as red circles.
     * @param background the Pane to which the points should be added
     * @param points     a list containing coordinates of the points in the following format: (x_1, y_1, x_2, y_2,...)
     */
    private void addPoints(Pane background, ObservableList<Double> points) {
        for (int i = 0; i < points.size()/2; i++) {
            Circle point = new Circle(points.get(2*i), points.get(2*i+1), 5, Color.RED);
            background.getChildren().addAll(point);
        }
    }

    /**
     * Adds black lines to the specified Pane.
     * @param background the Pane to which the lines will be added
     * @param points     a list containing the coordinates of the lines' endpoints in the following format:
     *                   (x_line1-start, y_line1-start, x_line1-end, y_line1-end, x_line2-start,...)
     */
    private void addLines(Pane background, ObservableList<Double> points) {
        for (int i = 0; i < points.size()/2; i++) {
            for (int j = 0; j < points.size()/2; j++) {
                // If i >= j, this means that we're trying to connect a point to itself or to one which it's already
                // connected to, so we shouldn't do this.
                if (i < j) {
                    Line line = new Line(points.get(2*i), points.get(2*i + 1), points.get(2*j), points.get(2*j + 1));
                    background.getChildren().addAll(line);
                }
            }
        }
    }

    /**
     * Adds an isometric view of a cube to the specified Pane. The cube has orange edges and gray faces.
     * @param background the Pane to which the image will be added
     */
    private void addCube(Pane background) {
        // cube
        int centerX = 500;
        int centerY = 350;
        Polygon hexCube = generateRegPolygonWithinCircle(6, 80, centerX, centerY);
        hexCube.setStroke(Color.ORANGE);
        hexCube.setFill(Color.GRAY);
        ObservableList<Double> points = hexCube.getPoints();
        Line line1 = new Line(points.get(2), points.get(3), centerX, centerY);
        Line line2 = new Line(points.get(10), points.get(11), centerX, centerY);
        Shape lineUnion = Shape.union(line1, line2);
        Line line3 = new Line(points.get(6), points.get(7), centerX, centerY);
        lineUnion = Shape.union(lineUnion, line3);
        lineUnion.setStroke(Color.ORANGE);

        background.getChildren().addAll(hexCube, lineUnion);
    }

    /**
     * Generates a version of the illuminati symbol on the specified Pane.
     * @param background the Pane on which to generate the symbol
     */
    private void addIlluminati(Pane background) {
        //circle
        int centerPos = 300;
        int radius = 100;
        Circle circle = new Circle(centerPos, centerPos, radius);
        circle.setStroke(Color.BISQUE);
        circle.setFill(Color.BISQUE);
        //triangle within circle
        Polygon circTriangle = generateRegPolygonWithinCircle(3, radius, centerPos, centerPos);
        circTriangle.setStroke(Color.PURPLE);
        circTriangle.setFill(Color.PURPLE);
        //circle within triangle
        Circle innerCircle = new Circle(centerPos, centerPos, radius/2);
        innerCircle.setStroke(Color.BLACK);
        innerCircle.setFill(Color.WHITE);
        //square within inner circle
        Rectangle square = new Rectangle(275, 275, 50, 50);
        square.setStroke(Color.BLUE);
        square.setFill(Color.GREEN);

        background.getChildren().addAll(circle, circTriangle, innerCircle, square);
    }

    /**
     * Adds a Venn diagram made up of three circles to the specified Pane.
     * @param background the Pane to which the Venn diagram will be added
     */
    private void addVennDiagram(Pane background) {
        // Venn Diagram
        int centerX = 100;
        int centerY = 350;
        int radiusOfEachCircle = 35;
        int overlap = 10;
        int distApart = radiusOfEachCircle - overlap;
        // first circle
        Circle firstCirc = new Circle(centerX - distApart, centerY + distApart, radiusOfEachCircle);
        firstCirc.setStroke(Color.BLUE);
        firstCirc.setFill(Color.BLUE);
        // second circle
        Circle secondCirc = new Circle(centerX + distApart, centerY + distApart, radiusOfEachCircle);
        secondCirc.setStroke(Color.GREEN);
        secondCirc.setFill(Color.GREEN);
        // third circle
        Circle thirdCirc = new Circle(centerX, centerY - distApart, radiusOfEachCircle);
        thirdCirc.setStroke(Color.RED);
        thirdCirc.setFill(Color.RED);

        background.getChildren().addAll(firstCirc, secondCirc, thirdCirc);
        addIntersects(background, firstCirc, secondCirc, thirdCirc);
    }

    /**
     * Adds intersection shapes for the three specified circles to the specified Pane. Intersections between the
     * first and second circles, between the first and third circles, between the second and third circles, and between
     * all three circles are added. The intersections are colored cyan, magenta, yellow, and white, respectively.
     * @param background the Pane to which the intersections will be added
     * @param firstCirc  the first circle to be included in the intersections
     * @param secondCirc the second circle to be included in the intersections
     * @param thirdCirc  the third circle to be included in the intersections
     */
    private void addIntersects(Pane background, Circle firstCirc, Circle secondCirc, Circle thirdCirc) {
        Shape firstSecondIntersect = Shape.intersect(firstCirc, secondCirc);
        firstSecondIntersect.setStroke(Color.CYAN);
        firstSecondIntersect.setFill(Color.CYAN);

        Shape firstThirdIntersect = Shape.intersect(firstCirc, thirdCirc);
        firstThirdIntersect.setStroke(Color.MAGENTA);
        firstThirdIntersect.setFill(Color.MAGENTA);

        Shape secondThirdIntersect = Shape.intersect(secondCirc, thirdCirc);
        secondThirdIntersect.setStroke(Color.YELLOW);
        secondThirdIntersect.setFill(Color.YELLOW);

        Shape allIntersect = Shape.intersect(firstSecondIntersect, firstThirdIntersect);
        allIntersect.setStroke(Color.WHITE);
        allIntersect.setFill(Color.WHITE);

        background.getChildren().addAll(firstSecondIntersect, firstThirdIntersect, secondThirdIntersect, allIntersect);
    }

    /**
     * Generates a regular polygon with the specified number of sides, which is inscribed in an imaginary circle of
     * the specified radius. One of the polygon's points is always pointing directly upwards.
     * @param numSides the number of sides of the polygon
     * @param radius   the radius of the imaginary circle in which the polygon is inscribed
     * @param centerX  the x-coordinate of the polygon's center
     * @param centerY  the y-coordinate of the polygon's center
     * @return         the polygon specified by the above parameters
     */
    private Polygon generateRegPolygonWithinCircle(int numSides, int radius, int centerX, int centerY) {
        double angle = Math.PI/2;
        double[] coords = new double[numSides*2];
        for (int i = 0; i < coords.length/2; i++) {
            coords[2*i] = radius*Math.cos(angle) + centerX;
            // Radius is negative because the y-axis is reversed in computer graphics.
            coords[2*i+1] = -radius*Math.sin(angle) + centerY;
            // Angle increases incrementally to divide the circle evenly into 'numSides' different sections.
            angle += 2*Math.PI/numSides;
        }
        return new Polygon(coords);
    }

} //END OF CLASS