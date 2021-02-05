import java.awt.*;

/**
 * Volvo240 class
 *
 * @author Birk, Emil
 * @version 1.0
 * @since 2021-01-29
 */
public class Volvo240 extends Car implements CarNotAllowed {

    private final static double trimFactor = 1.25;

    /**
     * Generic Constructor
     *
     * @param nrDoors     This is the amount of doors
     * @param enginePower This is enginepower
     * @param color       This is car color
     * @param modelName   This is car model name
     */
    public Volvo240(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
        this.stopEngine();
    }

    /**
     * This Constructor is used to init a Volvo of model 240
     */
    public Volvo240() {
        super(4, 100, Color.black, "Volvo240");
        this.stopEngine();
    }

    /**
     * @return double
     */
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }



}
