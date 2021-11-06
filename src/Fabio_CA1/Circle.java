package Fabio_CA1;

import java.awt.*;


//Circle Class inherits the abstract class Shape
public class Circle extends Shape{
    private final int radius;

    //Constructor to pass the necessary values to create the Circle
    public Circle(Color color, boolean filled, int xCenter, int yCenter, int radius){
        super(color, filled, xCenter, yCenter);
        this.radius = radius;

        //create the bounding box around the circle
        this.boundingBox = new BoundingBox(new Point(xCenter-(radius/2),yCenter+(radius/2)),new Point(xCenter+(radius/2),yCenter-(radius/2)));
    }

    //This function will evaluate if the Circle is filled and draw it
    public void drawShape(Graphics g){
        g.setColor(color);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1));
        int startPointx = xCenter - radius/2;
        int startPointy = yCenter - radius/2;

        if(filled) {
            g.fillOval(startPointx,startPointy,radius,radius);
        }
        else {
            g.drawOval(startPointx,startPointy,radius,radius);
        }
    }

    @Override
    public String toString(){
        String s1 = super.toString();
        String s2 = String.format("Radius = %d",radius);
        return s1+s2;
    }
}

