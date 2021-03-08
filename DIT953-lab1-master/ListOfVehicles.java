import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ListOfVehicles implements Observable {

    private static final List<Observer> observers = new ArrayList<>();
    private static final List<Vehicle> cars = new ArrayList<>();
    private static final List<Turbo> turbo = new ArrayList<>();
    private static final List<Ramp> ramp = new ArrayList<>();
    private static final String[] randomValues = {"Volvo240", "Saab95", "Scania"};

    public static void startTimer(CarController cc) {
        cc.timer.start();
    }

    void checkWindow(Vehicle c) {
        if (c.getX() > 700) {
            c.getState().setCurrentDir(Movable.Directions.WEST);
        } else if (c.getX() < 0) {
            c.setCurrentDir(Movable.Directions.EAST);
        }
    }

    public void removeCar() {
        if (cars.size() > 0) {
            Vehicle v = cars.get(cars.size() - 1);
            ListOp.removeFromList(v, cars);
            ListOp.removeFromList(v, turbo);
            ListOp.removeFromList(v, ramp);
        }
    }

    public void addCar() {
        if (cars.size() < 10) {
            int r = new RandomNumbers(2, 0).Return();
            Vehicle v = (Vehicle) (new Factory()).getObserver(randomValues[r]);

            cars.add(v);
            dupCarListTurbo();
            dupCarListRamp();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }

    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers
        ) {
            o.update();
        }
    }


    public void dupCarListTurbo() {

        for (Vehicle car : cars
        ) {
            if (ListOp.isInList(car, turbo)) {
                continue;
            }
            try {
                turbo.add((Turbo) car);
            } catch (Exception ignored) {
            }
        }
    }

    public void dupCarListRamp() {

        for (Vehicle car : cars
        ) {
            if (ListOp.isInList(car, ramp)) {
                continue;
            }
            try {
                ramp.add((Ramp) car);
            } catch (Exception ignored) {
            }
        }
    }

    public List<Vehicle> getCars() {
        return cars;
    }

    public List<Turbo> getTurbo() {
        return turbo;
    }

    public List<Ramp> getRamp() {
        return ramp;
    }

    public ListOfVehicles() {

    }
}
