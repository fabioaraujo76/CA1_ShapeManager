package Fabio_CA1;
import java.awt.*;

//Abstract class Shape that will be the base for all other shapes.
public abstract class Shape {
    protected Color color;
    protected boolean filled;
    protected int xCenter;
    protected int yCenter;

    BoundingBox boundingBox;

    //Constructor for the Shape Class
    public Shape(Color color,boolean filled, int xCenter, int yCenter){
        this.color = color;
        this.filled = filled;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    public abstract void drawShape(Graphics g);

    //Method to toggle between filled and not filled
    public void toggleFilled(){
        filled = !filled;
    }

    //Method to define the Right click of the mouse
    public boolean rightClick(){
        return false;
    }

    //Method to draw the Bounding Box
    public void drawBoundingBox(Graphics g){
        g.setColor(Color.DARK_GRAY);
        Graphics2D g2 = (Graphics2D) g;
        float[] dashingPattern = {2f, 5f};
        Stroke stroke2 = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 1.0f, dashingPattern, 3.0f);
        g2.setStroke(stroke2);
        int startPointx = boundingBox.bottomLeft.x;
        int startPointy = boundingBox.topRight.y;
        int width = boundingBox.topRight.x-boundingBox.bottomLeft.x;
        int height = boundingBox.bottomLeft.y-boundingBox.topRight.y;
        g2.drawRect(startPointx,startPointy,width,height);
    }

    //Method to draw the Name of the shape from the center of the Shape.
    public void drawName(Graphics g){
        g.setColor(Color.black);
        Font textFont = new Font("Arial", Font.BOLD, 12);

        g.setFont(textFont);
        g.drawString(this.getClass().getSimpleName(),xCenter,yCenter);
    }

    @Override
    public String toString(){
        return String.format("%s | Center Point = (%d,%d) , Color = %s , Filled = %b ~()> ",this.getClass().getSimpleName(),xCenter,yCenter,color,filled);
    }

}