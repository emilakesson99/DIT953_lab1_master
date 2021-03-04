import java.io.IOException;
import java.util.function.Supplier;

public class CarApp {

    public static void main(String[] args) throws IOException {
        // Add Vehicles
        Supplier<Factory> vehicleFactory = Factory::new;
        Saab95 s = (Saab95) vehicleFactory.get().getObserver("Saab95");
        Volvo240 v = (Volvo240) vehicleFactory.get().getObserver("Volvo240");
        Scania sc = (Scania) vehicleFactory.get().getObserver("Scania");

        CarController cc = new CarController(new CarView("CarSim 1.0"));

        cc.setVehicles(new ListOfVehicles());
        cc.getVehicles().getCars().add(sc);
        cc.getVehicles().getCars().add(v);
        cc.getVehicles().getCars().add(s);

        cc.getVehicles().dupCarListTurbo();
        cc.getVehicles().dupCarListRamp();

        //add event observer to all Vehicles
        cc.getVehicles().addObserver(CarView.drawPanel);
        cc.getVehicles().addObserver(CarView.speedPanel);

        // Start the timer
        cc.startTimer(cc);
    }
}
