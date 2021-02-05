import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Workshop {
    private int maxAmountOfCars;
    private int amountOfCars;
    public final List<Car> acceptedCars = new ArrayList<Car>();
    private final List<Car> cars = new ArrayList<Car>();

    public Workshop(int maxAmountOfCars) {
        this.maxAmountOfCars = maxAmountOfCars;
    }

    public void acceptNewCar(Car car) {
        acceptedCars.add(car);
    }

    public void removeAcceptedCar(Car car) {
        acceptedCars.remove(car);
    }

    public void turnInCar(Car car) throws IOException {
        if (amountOfCars < maxAmountOfCars)
            for (int i = 0; i < acceptedCars.size(); i++) {
                if (acceptedCars.get(i) == car) {
                    cars.add(car);
                    amountOfCars++;
                } else {
                    throw new IOException("Car not accepted");
                }
            }
    }

    public void getCar(Car car) throws IOException {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i) == car) {
                cars.remove(i);
                break;
            } else throw new IOException("Car is not in workshop");
        }
    }
}
