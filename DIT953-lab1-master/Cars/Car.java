import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Car class
 *
 * @author Birk, Emil
 * @version 1.0
 * @since 2021-01-29
 */
public abstract class Car extends Vehicle {
    /**
     * Constructor
     *
     * @param nrDoors     This is the amount of doors
     * @param enginePower This is enginepower
     * @param color       This is car color
     * @param modelName   This is car model name
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName, BufferedImage img) {
        super(nrDoors, enginePower, color, modelName, img);
    }
}
