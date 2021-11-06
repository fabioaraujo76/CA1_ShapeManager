package Fabio_CA1;

import java.awt.*;

public class WindowCreator {

    // For Creating Shapes & Adding to Manager 
    public static void createShapes(){

        //Creating a new Circle
        Circle circle = new Circle(Color.BLUE,false,280,300,150);

        //Creating a new Rectangle
        Rectangle rectangle = new Rectangle(Color.MAGENTA,false,80,170,80,250);

        //Creating a new Square
        Square square = new Square(Color.CYAN, true, 150,240, 80);

        //Creating a new Quadrilateral with the first method passing a array of points.
        //Defining the points first
        Point centerPoint = new Point(230,150);
        Point[] points = new Point[4];
        points[0] = new Point(200,100);
        points[1] = new Point(260,90);
        points[2] = new Point(260,200);
        points[3] = new Point(190,210);
        Quadrilateral quadrilateral1 = new Quadrilateral(Color.green,true, centerPoint, points);


        //Creating a new Quadrilateral with the second method passing points individually.
        //Defining  the points first
        Point centerPoint2 = new Point(500, 340);
        Point point1 = new Point(530,360);
        Point point2 = new Point(550,320);
        Point point3 = new Point(450,300);
        Point point4 = new Point(480,380);
        Quadrilateral quadrilateral2 = new Quadrilateral(Color.RED,true, centerPoint2, point1, point2, point3, point4);


        //Creating a new quadrilateral with the third method by passing a Rectangle
        Rectangle builtRectangle = new Rectangle(Color.white,false,400,70,50,40);
        Quadrilateral quadrilateral3 = new Quadrilateral(Color.pink,false, builtRectangle);


        //Adding the created shapes to the Panel
        Tester.shapesManager.addShape(rectangle);
        Tester.shapesManager.addShape(circle);
        Tester.shapesManager.addShape(square);
        Tester.shapesManager.addShape(quadrilateral1);
        Tester.shapesManager.addShape(quadrilateral2);
        Tester.shapesManager.addShape(quadrilateral3);


    }

}
