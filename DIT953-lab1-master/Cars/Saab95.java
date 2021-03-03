import java.awt.*;

/**
 * Saab95 class
 *
 * @author Birk, Emil
 * @version 1.0
 * @since 2021-01-29
 */
public class Saab95 extends Car implements Turbo {
    /**
     * if turbo is on it's set to true
     */
    public boolean turboOn;

    /**
     * This Constructor is used to init a Saab of model 95
     */
    public Saab95() {
        super(2, 125, Color.red, "Saab95");
        this.turboOn = false;
        this.stopEngine();
    }

    /**
     * Turn on and off turbo
     */
    @Override
    public void setTurboOn() {
        turboOn = true;
    }

    @Override
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
