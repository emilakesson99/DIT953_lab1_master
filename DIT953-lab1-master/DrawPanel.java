import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    BufferedImage img;
    // To keep track of a singel cars position
    Point volvoPoint = new Point();
    Stack<Vehicle> stack = new Stack<Vehicle>();

    // TODO: Make this genereal for all cars
    void moveit(Vehicle car) {
        stack.push(car);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        int i = 0;
        super.paintComponent(g);
        while (!stack.isEmpty()) {
            try {
                img = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + stack.peek().getModelName() + ".jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            g.drawImage(img, (int) stack.peek().getX(), (int) stack.peek().getY() + 100 * i, null);
            ;// see javadoc for more info on the parameters
            stack.pop();
            i++;
        }
    }
}
