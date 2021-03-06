import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    public final Timer timer = new Timer(delay, new TimerListener());

    class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Vehicles.notifyObservers();
            for (Vehicle car : Vehicles.getCars()) {
                car.move();
                Vehicles.checkWindow(car);
            }

        }
    }

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    // A list of cars, modify if needed
    private ListOfVehicles Vehicles;

    public CarController(CarView frame) {
        setFrame(frame);
        initComponents();
    }


    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : Vehicles.getCars()
        ) {
            car.gas(gas);
        }
    }

    void startEngine() {
        for (Vehicle car : Vehicles.getCars()
        ) {
            car.startEngine();
        }
    }

    void turboOn() {
        for (Turbo car : Vehicles.getTurbo()
        ) {
            try {
                car.setTurboOn();
            } catch (Exception ignored) {
            }

        }
    }

    void stopEngine() {
        for (Vehicle car : Vehicles.getCars()
        ) {
            car.stopEngine();
        }
    }

    void turboOff() {
        for (Turbo car : Vehicles.getTurbo()) {
            try {
                car.setTurboOff();
            } catch (Exception ignored) {
            }


        }
    }

    void liftBed() {
        for (Ramp car : Vehicles.getRamp()) {
            try {
                car.changePlatform(70);
            } catch (Exception ignored) {
            }


        }
    }

    void lowerBed() {
        for (Ramp car : Vehicles.getRamp()) {

            try {
                car.changePlatform(0);
            } catch (Exception ignored) {
            }


        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : Vehicles.getCars()) {
            car.brake(brake);
        }
    }

    private void initComponents() {
        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        frame.gasButton.addActionListener(e -> gas(frame.gasAmount));

        frame.startButton.addActionListener(e -> startEngine());
        frame.stopButton.addActionListener(e -> stopEngine());
        frame.turboOnButton.addActionListener(e -> turboOn());
        frame.turboOffButton.addActionListener(e -> turboOff());
        frame.liftBedButton.addActionListener(e -> liftBed());
        frame.lowerBedButton.addActionListener(e -> lowerBed());
        frame.brakeButton.addActionListener(e -> brake(frame.gasAmount));
        frame.addCar.addActionListener(e -> Vehicles.addCar());
        frame.removeCar.addActionListener(e -> Vehicles.removeCar());
    }

    public void setVehicles(ListOfVehicles vehicles) {
        Vehicles = vehicles;
    }

    public ListOfVehicles getVehicles() {
        return Vehicles;
    }

    public void setFrame(CarView frame) {
        this.frame = frame;
    }

    public CarView getFrame() {
        return this.frame;
    }
}
