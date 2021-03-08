import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.function.Supplier;

public class CarApp {

    public static void main(String[] args) throws IOException {

        // Add Vehicles
        Supplier<Factory> vehicleFactory = Factory::new;
        Saab95 s = (Saab95) vehicleFactory.get().getObserver("Saab95");
        Volvo240 v = (Volvo240) vehicleFactory.get().getObserver("Volvo240");
        Scania sc = (Scania) vehicleFactory.get().getObserver("Scania");

        ListOfVehicles model = new ListOfVehicles();

        CarController cc = new CarController(new CarView("CarSim 1.0", model));

        model.addObserver(CarView.drawPanel);
        model.addObserver(CarView.speedPanel);

        cc.setVehicles(model);

        cc.getVehicles().getCars().add(sc);
        cc.getVehicles().getCars().add(v);
        cc.getVehicles().getCars().add(s);

        cc.getVehicles().dupCarListTurbo();
        cc.getVehicles().dupCarListRamp();


        //add event observer to all Vehicles
        /*cc.getVehicles().addObserver(CarView.drawPanel);
        cc.getVehicles().addObserver(CarView.speedPanel);*/

        // Start the timer

        ListOfVehicles.startTimer(cc);
    }
}
