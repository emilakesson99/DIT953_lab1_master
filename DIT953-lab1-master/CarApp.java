import java.io.IOException;
import java.util.ArrayList;

public class CarApp {

    // A list of cars, modify if needed
    static ArrayList<Vehicle> cars = new ArrayList<>();
    static ArrayList<Turbo> turbo = new ArrayList<>();
    static ArrayList<Ramp> ramp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Add Vehicles
        Saab95 s = new Saab95();
        Volvo240 v = new Volvo240();
        Scania sc = new Scania();

        cars.add(sc);
        cars.add(s);
        cars.add(v);

        //special Vehicles
        turbo.add(s);
        ramp.add(sc);

        CarController cc = new CarController(cars, turbo, ramp, new CarView("CarSim 1.0"));

        //add event observer to all Vehicles (Possible design flaw)
        for (Vehicle car : cars
        ) {
            car.addObserver(cc.getFrame().drawPanel);
        }

        // Start the timer
        cc.startTimer(cc);
    }
}
