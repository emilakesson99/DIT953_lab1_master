import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    static List<Vehicle> cars = new ArrayList<>();
    static List<Turbo> turbo;
    static List<Ramp> ramp;

    public CarController(CarView frame) {
        setFrame(frame);
        initComponents();
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
            c.state.setCurrentDir(Movable.Directions.WEST);
        } else if (c.getX() < 0) {
            c.setCurrentDir(Movable.Directions.EAST);
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
            try {
                car.setTurboOn();
            } catch (Exception ignored) {
            }

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
            try {
                car.setTurboOff();
            } catch (Exception ignored) {
            }


        }
    }

    void liftBed() {
        for (Ramp car : ramp) {
            try {
                car.changePlatform(70);
            } catch (Exception ignored) {
            }


        }
    }

    void lowerBed() {
        for (Ramp car : ramp) {

            try {
                car.changePlatform(0);
            } catch (Exception ignored) {
            }


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

        frame.addCar.addActionListener(new

                                               ActionListener() {
                                                   @Override
                                                   public void actionPerformed(ActionEvent e) {
                                                       addCar();
                                                   }
                                               });

        frame.removeCar.addActionListener(new

                                                  ActionListener() {
                                                      @Override
                                                      public void actionPerformed(ActionEvent e) {
                                                          removeCar();
                                                      }
                                                  });
    }

    private void removeCar() {
        if (cars.size() > 0) {
            Vehicle v = cars.get(cars.size() - 1);
            removeFromList(v, cars);
            removeFromList(v, turbo);
            removeFromList(v, ramp);
        }
    }

    private void addCar() {
        if (cars.size() < 10) {
            String[] arr = {"Volvo240", "Saab95", "Scania"};
            int r = new RandomNumbers(2, 0).Return();
            Vehicle v;
            v = (Vehicle) (new Factory()).getObserver(arr[r]);
            v.addObserver(getFrame().drawPanel);
            cars.add(v);
        }
    }

    private <T> void removeFromList(Observers o, List<T> list) {
        list.removeIf(object -> object == o);
    }

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

    public static <T extends Turbo> List<T> dupCarListTurbo() {
        List<T> list = new ArrayList<T>();
        for (Vehicle car : cars
        ) {
            try {
                list.add((T) car);
            } catch (Exception ignored) {
            }
        }
        return list;
    }

    public static <T extends Ramp> List<T> dupCarListRamp() {
        List<T> list = new ArrayList<T>();
        for (Vehicle car : cars
        ) {
            try {
                list.add((T) car);
            } catch (Exception ignored) {
            }
        }
        return list;
    }

    public void setFrame(CarView frame) {
        this.frame = frame;
    }

    public CarView getFrame() {
        return this.frame;
    }
}
