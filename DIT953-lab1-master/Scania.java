import java.awt.*;
import java.io.IOException;

public class Scania extends Car {

    public double platformAngle;
    private final double maxAngle = 70;
    private final double minAngle = 0;

    public Scania(int nDoors, double enginePower, Color color, String modelName) {
        super(nDoors, enginePower, color, modelName);
        this.stopEngine();

    }

    public Scania() {
        this(2, 540, Color.green, "Scania");
        this.stopEngine();
        platformAngle = 0;
    }


    public void changePlatform(int a) {
        if (getCurrentSpeed() == 0) {

            if (a > maxAngle) {
                platformAngle = maxAngle;
            } else if (a < minAngle) {
                platformAngle = minAngle;

            }
            platformAngle = a;

        }

    }

    public boolean platformCheck() {
        if (platformAngle == 0) {
            return true;
        } else {
            return false;
        }
    }

    public double getPlatformAngle() {
        return platformAngle;
    }

    public void startEngineScania() {
        if (platformCheck()) {
            startEngine();
        }
    }

    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
}


