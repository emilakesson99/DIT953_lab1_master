import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Saab95 class
 *
 * @author Birk, Emil
 * @version 1.0
 * @since 2021-01-29
 */
public class Saab95 extends Car {
    /**
     * if turbo is on it's set to true
     */
    public boolean turboOn;

    /**
     * This Constructor is used to init a Saab of model 95
     */
    public Saab95() throws IOException {
        super(2, 125, Color.red, "Saab95", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
        this.turboOn = false;
        this.stopEngine();
    }

    /**
     * Turn on and off turbo
     */
    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * @return double
     */
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 5;
        return getEnginePower() * 0.01 * turbo;
    }

}
