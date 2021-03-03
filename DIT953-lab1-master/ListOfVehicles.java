import java.util.ArrayList;
import java.util.List;

public class ListOfVehicles implements Observers {

    private final List<Vehicle> cars = new ArrayList<>();
    private final List<Turbo> turbo = new ArrayList<>();
    private final List<Ramp> ramp = new ArrayList<>();
    private final String[] randomValues = {"Volvo240", "Saab95", "Scania"};

    public void removeCar() {
        if (cars.size() > 0) {
            Vehicle v = cars.get(cars.size() - 1);
            ListOp.removeFromList(v, cars);
            ListOp.removeFromList(v, turbo);
            ListOp.removeFromList(v, ramp);
        }
    }

    public void addCar(GUIObserver gui) {
        if (cars.size() < 10) {
            int r = new RandomNumbers(2, 0).Return();
            Vehicle v = (Vehicle) (new Factory()).getObserver(randomValues[r]);
            v.addObserver(gui);
            cars.add(v);
            dupCarListTurbo();
            dupCarListRamp();
        }
    }

    @Override
    public void addObserver(GUIObserver observer) {
        loop:
        for (Vehicle car : cars
        ) {
            for (int i = 0; i < car.observers.size(); i++) {
                if (car.observers.get(i) == observer) {
                    continue loop;
                }
            }
            car.addObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (Vehicle car : cars
        ) {
            car.notifyObservers();
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
}
