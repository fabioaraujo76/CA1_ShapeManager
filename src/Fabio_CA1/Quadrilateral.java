package Fabio_CA1;

import java.awt.*;


//Class to create a Quadrilateral, any 4 distinctive points that forms a shape.
public class Quadrilateral extends Shape implements Rotatable{

    private final Point[] points = new Point[4];

    //First method creates a Quadrilateral entering an array of points.
    public Quadrilateral(Color color, boolean filled, Point centerPoint, Point[] points){
        super(color, filled, centerPoint.x, centerPoint.y);
        Point bottomLeft = new Point();
        Point topRight = new Point();
        Point topLeft = new Point();
        Point bottomRight = new Point();

        //Finds points position related to the center point.
        for(Point point : points){
            if( point.x <= centerPoint.x && point.y >= centerPoint.y){
                bottomLeft = point;
            }
            if(point.x >= centerPoint.x && point.y <= centerPoint.y){
                topRight = point;
            }
            if(point.x <= centerPoint.x && point.y <= centerPoint.y){
                topLeft = point;
            }
            if(point.x >= centerPoint.x && point.y >= centerPoint.y){
                bottomRight = point;
            }
        }

        this.points[0] = topLeft;
        this.points[1] = topRight;
        this.points[2] = bottomRight;
        this.points[3] = bottomLeft;


        boundingBoxSet(points);
    }


    //Second method creates a Quadrilateral by informing center and corner points separately.
    //When passing the values it have to keep in mind the order: topleft, topRight, bottomLeft, bottomright
    public Quadrilateral(Color color,boolean filled, Point centerPoint, Point p1, Point p2, Point p3, Point p4){

        super(color, filled, centerPoint.x, centerPoint.y);

        Point topLeft = new Point();
        Point topRight = new Point();
        Point bottomLeft = new Point();
        Point bottomRight = new Point();
        Point[] edgeCheck = {p1, p2, p3, p4};

        topLeft = edgeCheck[0];
        topRight = edgeCheck[1];
        bottomLeft = edgeCheck[2];
        bottomRight = edgeCheck[3];

        this.points[0] = topLeft;
        this.points[1] = topRight;
        this.points[2] = bottomLeft;
        this.points[3] = bottomRight;

        boundingBoxSet(points);
    }

    //Third method creating the Quadrilateral passing a rectangle as base.
    public Quadrilateral(Color color,boolean filled, Rectangle rectangle){

        super(color, filled, rectangle.xCenter, rectangle.yCenter);
        int qXCenter = rectangle.xCenter;
        int qYCenter = rectangle.yCenter;
        int qWidth = rectangle.width;
        int qHeight = rectangle.height;

        this.points[0] = new Point(qXCenter-qWidth,qYCenter-qHeight);
        this.points[1] = new Point(qXCenter+qWidth,qYCenter-qHeight);
        this.points[2] = new Point(qXCenter+qWidth,qYCenter+qHeight);
        this.points[3] = new Point(qXCenter-qWidth,qYCenter+qHeight);

        boundingBox = new BoundingBox(points[3],points[1]);
    }

    //This function will evaluate if the Shape is filled and draw it
    public void drawShape(Graphics g){
        g.setColor(color);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1));

        Polygon poly = new Polygon();
        for (Point point : points) poly.addPoint(point.x, point.y);

        if(filled) {
            g.fillPolygon(poly);
        }
        else {
            g.drawPolygon(poly);
        }
    }

    //Method to call the rotation method when the right button of the mouse is clicked.
    public boolean rightClick(){
        rotateNinetyDegrees();
        return true;
    }


    //Method to rotate the Quadrilateral
    @Override
    public void rotateNinetyDegrees(){
        int disX, disY;

        Point[] temp = new Point[4];

        for(int i=0; i<temp.length;i++)
            temp[i] = new Point();

        for(int i=0; i<temp.length; i++){
            int j = i+1;

            disX = xCenter - points[i].x;
            disY = yCenter - points[i].y;

            if(j>3)
                j=0;

            temp[j].x = xCenter + disY;
            temp[j].y = yCenter - disX;
        }

        System.arraycopy(temp, 0, points, 0, temp.length);

        boundingBoxSet(points);
    }

    //Method to define the bounding box.
    private void boundingBoxSet(Point[] points){

        int x_min = points[0].x, x_max=points[1].x;
        int y_min = points[3].y, y_max = points[2].y;
        for (Point point : points) {
            if (point.x < x_min)
                x_min = point.x;

            if (point.y < y_min)
                y_min = point.y;

            if (point.x > x_max)
                x_max = point.x;

            if (point.y > y_max)
                y_max = point.y;
        }

        Point bottomLeft = new Point(x_min,y_max);
        Point topRight = new Point(x_max,y_min);

        this.boundingBox = new BoundingBox(bottomLeft,topRight);
    }


    @Override
    public String toString(){
        String s1 = super.toString();
        String s2 = String.format("Points = [ (%d,%d), (%d,%d), (%d,%d), (%d,%d) ]",points[0].x,points[0].y,points[1].x,points[1].y,points[2].x,points[2].y,points[3].x,points[3].y);
        return s1+s2;
    }

}