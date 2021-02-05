import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Transport extends Car implements Ramp {
    private final List<Car> cargo = new ArrayList<Car>();
    public boolean rampActive = false;
    public double maxCargo;
    public int maxAmountCars;
    public int amountOfCars = 0;


    /**
     * Constructor
     *
     * @param nrDoors     This is the amount of doors
     * @param enginePower This is enginepower
     * @param color       This is car color
     * @param modelName   This is car model name
     */
    public Transport(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }


    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Activates ramp
     */
    @Override
    public void turnOnRamp() {
        if (getCurrentSpeed() == 0)
            rampActive = true;
    }

    /**
     * Deactivates ramp
     */
    @Override
    public void turnOffRamp() {
        rampActive = false;
    }

    /**
     * Loads a car onto the truck if it is possible
     *
     * @param car
     */
    public void loadCargo(Car car) {
        if (amountOfCars < maxAmountCars
                && rampActive
                && Math.abs(this.getX() - car.getX()) <= 1
                && Math.abs(this.getY() - car.getY()) <= 1) {

            cargo.add(car);
            car.setX(this.getX());
            car.setY(this.getY());
            amountOfCars++;
        }
    }

    /**
     * Deloads the all the cars until the targeted car is out.
     *
     * @param car
     */
    public void deloadCargo(Car car) {
        if (checkCargo(car) && !(car instanceof Transport))
            if (rampActive) {
                for (int i = 0; i < cargo.size(); i++) {

                    cargo.get(i).setX(this.getX() + 1);
                    cargo.get(i).setY(this.getY() + 1);

                    if (cargo.get(i) == car) {
                        cargo.remove(car);
                        amountOfCars--;
                        break;
                    } else {
                        cargo.remove(i);
                        amountOfCars--;
                    }

                }
            }


    }

    /**
     * @param car
     * @return true if car is on the truck, false otherwise
     */
    public boolean checkCargo(Car car) {
        for (int i = 0; i < cargo.size(); i++) {
            if (cargo.get(i) == car) {
                return true;
            }
        }
        return false;
    }
}
