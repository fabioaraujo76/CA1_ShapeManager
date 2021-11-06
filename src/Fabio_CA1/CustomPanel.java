package Fabio_CA1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This allows us to create a panel which we can add to a frame/window
 * Oftentimes, you would then add standard GUI components, e.g. JButton, JLabel, to the
 * panel.
 * In our case, though, we will want to draw shapes, so we override the paintComponent() method
 * that we inherit from the javax.swing.JPanel class.
 * The graphics system passes us a java.awt.Graphics object and this has methods which allows us
 * to draw shapes.
 */
public class CustomPanel extends JPanel {
    ShapesManager shapesManager;
    
    public CustomPanel(ShapesManager shapesManager){
        this.shapesManager = shapesManager;

        addMouseListener(new MouseAdapter() { 

            public void mousePressed(MouseEvent me) {
                //Getting the position of the mouse and storing it
                int MouseClickX = me.getX();
                int MouseClickY = me.getY();
                //checking for click/store which button was clicked
                int b = me.getButton();

                //Check which button was clicked in the mouse and evoke action from Left or Right mouse click.
                boolean clickChecker = false;
                if (b == 1)
                    clickChecker = shapesManager.leftClick(MouseClickX,MouseClickY);
                else if (b == 3)
                    clickChecker = shapesManager.rightClick(MouseClickX,MouseClickY);
                
                if(clickChecker)
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        //The superclass is necessary to the method we had overwritten, so we should invoke it.
        super.paintComponent(g);
        shapesManager.drawShapes(g);

    }

}
