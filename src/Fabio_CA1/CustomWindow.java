package Fabio_CA1;

import javax.swing.*;
import java.awt.*;

/**
 * We can think of a JFrame as a window
 * By extending (inheriting from) the class javax.swing.JFrame we can
 * define what goes into our window - in this case a single JPanel which is
 * a component container for GUI elements.
 */
public class CustomWindow extends JFrame {

    public CustomWindow(ShapesManager shapesManager)
    {
        CustomPanel mainPanel = new CustomPanel(shapesManager);

        //add our new panel to the frame
        add(mainPanel, BorderLayout.CENTER);

        //set the dimensions of the frame/window
        setSize(Consts.FRAME_WIDTH, Consts.FRAME_HEIGHT);

        //set the title of the frame/window
        setTitle("Fabio De Araujo - L00169711 - CA1");

        //set the window visible.
        setVisible(true);

        //set the windows to close and program stop when clicking on the X.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
