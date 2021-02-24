import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private CarView frame;
    // A list of cars, modify if needed
    static ArrayList<Vehicle> cars;
    static ArrayList<Turbo> turbo;
    static ArrayList<Ramp> ramp;

    public CarController(ArrayList<Vehicle> a, ArrayList<Turbo> t, ArrayList<Ramp> r, CarView frame) {
        setFrame(frame);
        initComponents();
        setCars(a, t, r);
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move();
                checkWindow(car);
                car.notifyObservers();
            }

        }
    }

    //methods:
    public void startTimer(CarController cc) {
        cc.timer.start();
    }

    void checkWindow(Vehicle c) {
        if (c.getX() > 700) {
            c.setCurrentDir(Vehicle.Directions.WEST);
        } else if (c.getX() < 0) {
            c.setCurrentDir(Vehicle.Directions.EAST);
        }
    }

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
        for (Turbo car : turbo
        ) {

            car.setTurboOn();
        }
    }

    void stopEngine() {
        for (Vehicle car : cars
        ) {
            car.stopEngine();
        }
    }

    void turboOff() {
        for (Turbo car : turbo) {
            car.setTurboOff();
        }
    }

    void liftBed() {
        for (Ramp car : ramp) {

            car.changePlatform(70);

        }
    }

    void lowerBed() {
        for (Ramp car : ramp) {

            car.changePlatform(0);

        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    private void initComponents() {
        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        frame.gasButton.addActionListener(new

                                                  ActionListener() {
                                                      @Override
                                                      public void actionPerformed(ActionEvent e) {
                                                          gas(frame.gasAmount);
                                                      }
                                                  });

        frame.startButton.addActionListener(new

                                                    ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            startEngine();
                                                        }
                                                    });
        frame.stopButton.addActionListener(new

                                                   ActionListener() {
                                                       @Override
                                                       public void actionPerformed(ActionEvent e) {
                                                           stopEngine();
                                                       }
                                                   });
        frame.turboOnButton.addActionListener(new

                                                      ActionListener() {
                                                          @Override
                                                          public void actionPerformed(ActionEvent e) {
                                                              turboOn();
                                                          }
                                                      });

        frame.turboOffButton.addActionListener(new

                                                       ActionListener() {
                                                           @Override
                                                           public void actionPerformed(ActionEvent e) {
                                                               turboOff();
                                                           }
                                                       });

        frame.liftBedButton.addActionListener(new

                                                      ActionListener() {
                                                          @Override
                                                          public void actionPerformed(ActionEvent e) {
                                                              liftBed();
                                                          }
                                                      });
        frame.lowerBedButton.addActionListener(new

                                                       ActionListener() {
                                                           @Override
                                                           public void actionPerformed(ActionEvent e) {
                                                               lowerBed();
                                                           }
                                                       });

        frame.brakeButton.addActionListener(new

                                                    ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            brake(frame.gasAmount);
                                                        }
                                                    });
    }

    public void setFrame(CarView frame) {
        this.frame = frame;
    }

    public CarView getFrame() {
        return this.frame;
    }

    public void setCars(ArrayList<Vehicle> cars, ArrayList<Turbo> turbo, ArrayList<Ramp> ramp) {
        CarController.cars = cars;
        CarController.turbo = turbo;
        CarController.ramp = ramp;
    }
}
