import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkshopTest {
    Workshop<Car> ws1 = new MultiWorkshop<Car>();
    Workshop<Volvo240> ws2 = new SingleWorkshop<Volvo240>();
    Workshop<Saab95> ws3 = new SingleWorkshop<Saab95>();

    Volvo240 v = new Volvo240();
    Saab95 s = new Saab95();
    Car c = new Saab95();
    Car c2 = new Volvo240();

    @BeforeEach
    void setUp() {
        ws1.turnInCar(c);
        ws1.turnInCar(c2);
        ws1.turnInCar(v);
        ws1.turnInCar(s);
        ws2.turnInCar(v);
        ws3.turnInCar(s);
    }

    @Test
    void turnInCar() {
        assertEquals(ws1.getAmountOfCars(), 4);
        assertEquals(ws2.getAmountOfCars(), 1);
        assertEquals(ws3.getAmountOfCars(), 1);
    }

    @Test
    void getCar() {
        assertEquals(ws1.getCars().get(0), c);
        assertEquals(ws2.getCars().get(0), v);
        assertEquals(ws3.getCars().get(0), s);
    }
}