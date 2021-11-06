package Fabio_CA1;

public class Tester {

    // Shapes Manager - Global Shape Manager Object
    static ShapesManager shapesManager = new ShapesManager();

    public static void main(String[] args) {

        // This Function is used to create and add shapes to ShapeManager
        WindowCreator.createShapes();

        //Create and configure our JFrame (window)
        new CustomWindow(shapesManager);

    }

}
