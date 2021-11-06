package Fabio_CA1;

import java.awt.*;
import java.util.*;

//Class ShapesManager
public class ShapesManager {
    public boolean isInRange(int x, int a, int b){
        return x >= a && x <= b;
    }

    private ArrayList<Shape> shapes;

    //The Bounding Box and Names are defined in the Consts.java file.
    // By default nameDisplay and boundBoxDisplay are TRUE.
    private final boolean boundBoxDisplay = Consts.BOUNDING_BOX_DISPLAY;
    private final boolean nameDisplay = Consts.SHAPE_NAME_DISPLAY;

    //Initialize the Array that will keep all shapes
    public ShapesManager(){
        shapes = new ArrayList<>();
    }

    //Add shape to the Array
    public void addShape(Shape shape){
        shapes.add(shape);
    }

    //Method to pass the shapes from the array to the Draw method
    public void drawShapes(Graphics graphicsContext){
        for(Shape shape : shapes){
            shape.drawShape(graphicsContext);
            
            if(boundBoxDisplay)
            shape.drawBoundingBox(graphicsContext);

            if(nameDisplay){
                shape.drawName(graphicsContext);
            }
        
        }
    }

    //Method to detect if the left button was clicked inside the shape to switch from Filled to Not Filled and vice versa.
    public boolean leftClick(int MouseClickX,int MouseClickY){
        boolean pointer = false;
        for(Shape shape : shapes){
            Point bottomLeft = shape.boundingBox.bottomLeft;
            Point topRight = shape.boundingBox.topRight;
            if(isInRange(MouseClickX, bottomLeft.x, topRight.x)&&isInRange(MouseClickY,topRight.y, bottomLeft.y)){
                shape.toggleFilled();
                pointer = true;
            }
        }
        return pointer;
    }

    //Method to detect if the right button was clicked inside the shape and call the unique method of each shape.
    public boolean rightClick(int MouseClickX,int MouseClickY){
        boolean pointer = false;

        for(Shape shape : shapes){
            Point bottomLeft = shape.boundingBox.bottomLeft;
            Point topRight = shape.boundingBox.topRight;
            if(isInRange(MouseClickX, bottomLeft.x, topRight.x)&&isInRange(MouseClickY,topRight.y, bottomLeft.y)){
                pointer = shape.rightClick();
                
            }
        }

        return pointer;
    }

}
