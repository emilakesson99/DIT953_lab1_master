import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Stack;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements GUIObserver {

    BufferedImage img;
    Stack<Observers> stack = new Stack<>();

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
                img = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + ((Vehicle) stack.peek()).getModelName() + ".jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            g.drawImage(img, (int) ((Vehicle) stack.peek()).getX(), (int) ((Vehicle) stack.peek()).getY() + 100 * i
                    , null);
            ;// see javadoc for more info on the parameters
            stack.pop();
            i++;
        }
    }


    //Send Vehicle to stack. Can't change parameters of paintComponent?? (possible design flaw)
    @Override
    public <T> void update(T v) {
        stack.add((Observers) v);
        repaint();
    }
}
