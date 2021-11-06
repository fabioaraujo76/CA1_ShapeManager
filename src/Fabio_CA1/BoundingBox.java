package Fabio_CA1;

//The bounding box class will create a box around the shape, it will set the
//boundaries where the user can click with the mouse to execute actions.

public class BoundingBox{
    Point bottomLeft;
    Point topRight;

    //The bounding box will be always a square, so with two opposite points it is possible
    //to define its position and size.
    public BoundingBox(Point bottomLeft,Point topRight){
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }
}
