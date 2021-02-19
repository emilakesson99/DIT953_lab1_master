import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;


public class CarApp {

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    static ArrayList<Vehicle> cars = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Add cars
        cars.add(new Scania());
        cars.add(new Saab95());
        cars.add(new Volvo240());

        CarController cc = new CarController(cars);

        // Start a new view and send a reference of self

        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.startTimer(cc);
    }
}
