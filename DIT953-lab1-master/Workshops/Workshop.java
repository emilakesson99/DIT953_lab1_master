import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Workshop<R> {

    private static final int maxAmountOfCars = 20;
    private int amountOfCars;

    public int getAmountOfCars() {
        return amountOfCars;
    }

    public List<R> getCars() {
        return cars;
    }

    /**
     * List of cars in the workshop
     */
    private final List<R> cars = new ArrayList<>();


    /**
     * Checks if car is accepted and turn it in to the workshop
     *
     * @param car
     * @throws IOException
     */
    public void turnInCar(R car) {
        if (amountOfCars < maxAmountOfCars) {
            cars.add(car);
            amountOfCars++;
        }
    }


    /**
     * Find the car in the workshop and remove it
     *
     * @param car
     * @throws IOException
     */
    public void getCar(R car) throws IOException {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i) == car) {
                cars.remove(i);
                amountOfCars--;
                break;
            } else throw new IOException("Car is not in workshop");
        }
    }


}

