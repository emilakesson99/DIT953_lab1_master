import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Volvo240 class
 *
 * @author Birk, Emil
 * @version 1.0
 * @since 2021-01-29
 */
public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;


    /**
     * This Constructor is used to init a Volvo of model 240
     */
    public Volvo240() throws IOException {
        super(4, 100, Color.black, "Volvo240", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
        this.stopEngine();
    }

    /**
     * @return double
     */
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }



}
