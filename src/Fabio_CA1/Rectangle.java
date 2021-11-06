package Fabio_CA1;

import java.awt.*;

//Class to create a Rectangle
public class Rectangle extends Shape implements Moveable {
    protected int width;
    protected int height;

    //Constructor for Rectangle
    public Rectangle(Color color, boolean filled, int xCenter, int yCenter, int width, int height){
        super(color, filled, xCenter, yCenter);
        this.width = width;
        this.height = height;

        this.boundingBox = new BoundingBox(new Point(xCenter-(width/2),yCenter+(height/2)),new Point(xCenter+(width/2),yCenter-(height/2)));
    }

    //This function will evaluate if the Circle is filled and draw it
    public void drawShape(Graphics g){
        g.setColor(color);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1));
        int startPointx = xCenter - width/2;
        int startPointy = yCenter - height/2;

        if(filled)
            g.fillRect(startPointx,startPointy,width,height);
        else {
            g.drawRect(startPointx,startPointy,width,height);
        }
    }

    //Method to call the movement of the shape when a right click is detected on it.
    public boolean rightClick(){
        moveTenUnits();
        return true;
    }

    //Method to move the Rectangle by 10 units.
    @Override
    public void moveTenUnits(){
        boundingBox.bottomLeft.x += 10;
        boundingBox.topRight.x += 10;
        xCenter += 10;
    }

    @Override
    public String toString(){
        String s1 = super.toString();
        String s2 = String.format("Width = %d , Height = %d",width,height);
        return s1+s2;
    }
}
