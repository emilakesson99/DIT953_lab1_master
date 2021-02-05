import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Workshop {
    private int maxAmountOfCars;
    private int amountOfCars;
    /**
     * List of accepted cars
     */
    public final List<Car> acceptedCars = new ArrayList<Car>();
    /**
     * List of cars in the workshop
     */
    private final List<Car> cars = new ArrayList<Car>();

    public Workshop(int maxAmountOfCars) {
        this.maxAmountOfCars = maxAmountOfCars;
    }

    /**
     * Add a new car model to the accepted list of cars
     *
     * @param car
     */
    public void acceptNewCar(Car car) {
        acceptedCars.add(car);
    }

    /**
     * remove a car model from the accepted list of cars
     *
     * @param car
     */
    public void removeAcceptedCar(Car car) {
        acceptedCars.remove(car);
    }

    /**
     * Checks if car is accepted and turn it in to the workshop
     *
     * @param car
     * @throws IOException
     */
    public void turnInCar(Car car) throws IOException {
        if (amountOfCars < maxAmountOfCars)
            for (int i = 0; i < acceptedCars.size(); i++) {
                if (acceptedCars.get(i) == car) {
                    cars.add(car);
                    amountOfCars++;
                    break;
                } else {
                    throw new IOException("Car not accepted");
                }
            }
    }

    /**
     * Find the car in the workshop and remove it
     *
     * @param car
     * @throws IOException
     */
    public void getCar(Car car) throws IOException {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i) == car) {
                cars.remove(i);
                amountOfCars--;
                break;
            } else throw new IOException("Car is not in workshop");
        }
    }


}
