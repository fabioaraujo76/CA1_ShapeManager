package Fabio_CA1;

import java.awt.*;

//Class Square that inherit the blueprint of Rectangle
public class Square extends Rectangle{

    //Contructor for Square
    public Square(Color color, boolean filled, int xCenter, int yCenter, int size){
        super(color,filled,xCenter,yCenter,size,size);
    }

    @Override
    public String toString(){
        return String.format("%s | Center Point = (%d,%d) , Color = %s , Filled = %b ~()> Side = %d",this.getClass().getSimpleName(),xCenter,yCenter,color,filled, width);
    }
}