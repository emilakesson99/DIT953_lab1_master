import javax.swing.*;
import java.awt.*;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class SpeedPanel extends JPanel implements Observer {

    ListOfVehicles vehicles;

    public SpeedPanel(int x, int y, ListOfVehicles v) {
        this.vehicles = v;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int i = 1;

        super.paintComponent(g);

        for (Vehicle v : vehicles.getCars()) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            double roundOff = Math.round(v.getCurrentSpeed() * 100.0) / 100.0;
            g2.setFont(new Font("TimesRoman", Font.PLAIN, 6));
            g2.drawString((v.getModelName() + " " + "Velocity:" + " " + roundOff), 70 * i, 10);
            i++;
        }

    }

    @Override
    public void update() {
        repaint();
    }
}
