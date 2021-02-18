import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Scania extends Vehicle {

    private double platformAngle;
    private static final double maxAngle = 70;
    private static final double minAngle = 0;

    public Scania() throws IOException {
        super(2, 540, Color.green, "Scania", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
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
        return platformAngle == 0;
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


