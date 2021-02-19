import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    public final Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    static ArrayList<Vehicle> cars = new ArrayList<>();

    public CarController(ArrayList<Vehicle> a) {
        setCars(a);
    }

    //methods:
    public void startTimer(CarController cc) {
        cc.timer.start();
    }

   /* public static void main(String[] args) throws IOException {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Scania());
        cc.cars.add(new Saab95());
        cc.cars.add(new Volvo240());


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }*/

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                //int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(car);

                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                if (x > 700) {
                    car.setCurrentDir(Vehicle.Directions.WEST);
                } else if (x < 0) {
                    car.setCurrentDir(Vehicle.Directions.EAST);
                }
            }

        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.gas(gas);
        }
    }

    void startEngine() {
        for (Vehicle car : cars
        ) {
            car.startEngine();
        }
    }

    void turboOn() {
        for (Vehicle car : cars
        ) {
            if (car instanceof Saab95)
                ((Saab95) car).setTurboOn();
        }
    }

    void stopEngine() {
        for (Vehicle car : cars
        ) {
            car.stopEngine();
        }
    }

    void turboOff() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }

        }
    }

    void liftBed() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).changePlatform(70);
            }
        }
    }

    void lowerBed() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).changePlatform(0);
            }
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    public void setFrame(CarView frame) {
        this.frame = frame;
    }

    public void setCars(ArrayList<Vehicle> cars) {
        this.cars = cars;
    }
}
