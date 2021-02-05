import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TransportTest {
    Transport transport = new Transport(2, 900, Color.BLACK, "Transport");

    @Test
    void speedFactor() {
    }

    @Test
    void turnOnRamp() {
        transport.stopEngine();
        transport.turnOnRamp();
        assertTrue(transport.rampActive);
    }

    @Test
    void turnOffRamp() {
        transport.stopEngine();
        transport.turnOffRamp();
        assertFalse(transport.rampActive);
    }

    @Test
    void loadCargo() {
        transport.stopEngine();
        transport.turnOnRamp();
        Car car = new Volvo240();
        car.setY(transport.getY());
        car.setX(transport.getX());
        transport.loadCargo(car);
        assertSame(transport.getCargo().get(0), car);
    }

    @Test
    void checkCargo() {
        Car car = new Volvo240();
        car.setY(transport.getY());
        car.setX(transport.getX());
        transport.loadCargo(car);
        //assertTrue(checkCargo(car));

    }

    @Test
    void deloadCargo() {
        Car car = new Volvo240();
        transport.loadCargo(car);
        transport.deloadCargo(car);
        assertEquals(transport.getCargo().size(), 0);
    }


}