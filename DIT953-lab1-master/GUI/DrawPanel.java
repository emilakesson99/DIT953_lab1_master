import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements Observer {

    BufferedImage img;
    ListOfVehicles vehicles;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ListOfVehicles v) {
        this.vehicles = v;
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

        for (Vehicle vehicle : vehicles.getCars()) {

            try {
                img = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + vehicle.getModelName() + ".jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            g.drawImage(img, (int) vehicle.getX(), (int) vehicle.getY() + 100 * i
                    , null);
            i++;
        }


    }

    @Override
    public void update() {
        repaint();
    }
}
