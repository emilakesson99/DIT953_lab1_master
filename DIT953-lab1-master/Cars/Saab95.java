import java.awt.*;

/**
 * Saab95 class
 *
 * @author Birk, Emil
 * @version 1.0
 * @since 2021-01-29
 */
public class Saab95 extends Car implements CarNotAllowed {
    /**
     * if turbo is on it's set to true
     */
    public boolean turboOn;

    /**
     * Generic Constructor
     *
     * @param nrDoors     This is the amount of doors
     * @param enginePower This is enginepower
     * @param color       This is car color
     * @param modelName   This is car model name
     * @param turboOn
     */
    public Saab95(int nrDoors, double enginePower, Color color, String modelName, boolean turboOn) {
        super(nrDoors, enginePower, color, modelName);
        this.turboOn = turboOn;
        this.stopEngine();
    }

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
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
