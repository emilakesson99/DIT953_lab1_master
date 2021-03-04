import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class SpeedPanel extends JPanel implements GUIObserver {

    private final Stack<Observers> stack = new Stack<>();

    public Stack<Observers> getStack() {
        return stack;
    }

    public SpeedPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int i = 1;

        super.paintComponent(g);
        while (!stack.isEmpty()) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setFont(new Font("TimesRoman", Font.PLAIN, 6));
            g2.drawString(((Vehicle) getStack().peek()).getModelName() + " " + "Velocity:" + " " + ((Vehicle) getStack().peek()).getCurrentSpeed(), 70 * i, 10);

            stack.pop();
            i++;
        }
    }

    @Override
    public <T> void update(T v) {
        stack.add((Observers) v);
        repaint();

    }
}
