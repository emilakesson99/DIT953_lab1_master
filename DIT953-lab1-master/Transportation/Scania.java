import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Scania extends Vehicle implements Ramp {

    private double platformAngle;
    private static final double maxAngle = 70;
    private static final double minAngle = 0;

    public Scania() {
        super(2, 540, Color.green, "Scania");
        this.stopEngine();
        changePlatform(0);
    }


    public void changePlatform(int a) {
        if (getCurrentSpeed() == 0) {

            if (a > maxAngle) {
                platformAngle = maxAngle;
            } else if (a < minAngle) {
                platformAngle = minAngle;

            } else
                platformAngle = a;

        }

    }

    public boolean platformCheck() {
        return getPlatformAngle() == 0;
    }

    public double getPlatformAngle() {
        return platformAngle;
    }

    @Override
    public void startEngine() {
        if (platformCheck()) {
            super.startEngine();
        }
    }

    @Override
    public void gas(double a) {
        if (platformCheck()) {
            super.gas(a);
        }
    }

    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void move() {
        if (platformCheck()) {
            super.move();
        }
    }

}


