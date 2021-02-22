import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


public class CarApp {

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    static ArrayList<Vehicle> cars = new ArrayList<>();
    static ArrayList<Turbo> turbo = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Add cars
        Saab95 s = new Saab95();
        cars.add(new Scania());
        cars.add(s);
        cars.add(new Volvo240());
        turbo.add(s);

        CarController cc = new CarController(cars, turbo);

        // Start a new view and send a reference of self

        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.startTimer(cc);
    }
}
