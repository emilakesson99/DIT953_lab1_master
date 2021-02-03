import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing for Car class
 *
 * @author Birk, Emil
 * @version 1.0
 * @since 2021-01-29
 */
class CarTest {

    Car saab = new Saab95();
    Car volvo = new Volvo240();

    @Test
    void getNrDoors() {
        assert (saab.getNrDoors() == 2);
        assert (volvo.getNrDoors() == 4);
        assert (!(saab.getNrDoors() == 3));
        assert (!(volvo.getNrDoors() == 3));
    }

    @Test
    void getEnginePower() {
        assertEquals(saab.getEnginePower(), 125);
        assertEquals(volvo.getEnginePower(), 100);
    }

    @Test
    void getCurrentSpeed() {
        assertTrue(saab.getCurrentSpeed() >= 0);
        assertTrue(volvo.getCurrentSpeed() >= 0);
    }

    @Test
    void getColor() {
        assert (saab.getColor() == Color.red);
        assert (volvo.getColor() == Color.black);
        assert (!(saab.getColor() == Color.blue));
        assert (!(volvo.getColor() == Color.white));
    }

    @Test
    void setColor() {
        Saab95 saab1 = new Saab95();
        Volvo240 volvo1 = new Volvo240();
        saab1.setColor(Color.white);
        assert (!(saab1.getColor() == Color.red));
        assert (saab1.getColor() == Color.white);
        volvo1.setColor(Color.gray);
        assert (!(volvo1.getColor() == Color.black));
        assert (volvo1.getColor() == Color.gray);
    }

    @Test
    void startEngine() {
        saab.startEngine();
        volvo.startEngine();
        assertEquals(saab.getCurrentSpeed(), 0.1);
        assertEquals(volvo.getCurrentSpeed(), 0.1);
    }

    @Test
    void stopEngine() {
        saab.stopEngine();
        volvo.stopEngine();
        assertEquals(saab.getCurrentSpeed(), 0);
        assertEquals(volvo.getCurrentSpeed(), 0);
    }

    @Test
    void speedFactor() {
        assertTrue(volvo.speedFactor() > 0);
        assertTrue(saab.speedFactor() > 0);
    }

    @Test
    void gas() {
        double initSpeedSaab = saab.getCurrentSpeed();
        double initSpeedVolvo = volvo.getCurrentSpeed();
        saab.gas(0.4);
        volvo.gas(0.4);
        assertTrue(saab.getCurrentSpeed() < saab.getEnginePower());
        assertTrue(saab.getCurrentSpeed() > 0);
        assertTrue(volvo.getCurrentSpeed() < volvo.getEnginePower());
        assertTrue(volvo.getCurrentSpeed() > 0);

        assertTrue(initSpeedSaab < saab.getCurrentSpeed());
        assertTrue(initSpeedVolvo < volvo.getCurrentSpeed());

    }

    @Test
    void brake() {
        saab.startEngine();
        volvo.startEngine();

        saab.gas(0.4);
        volvo.gas(0.4);

        double initSpeedSaab = saab.getCurrentSpeed();
        double initSpeedVolvo = volvo.getCurrentSpeed();

        saab.brake(0.2);
        volvo.brake(0.2);

        assertTrue(saab.getCurrentSpeed() < saab.getEnginePower());
        assertTrue(saab.getCurrentSpeed() > 0);
        assertTrue(volvo.getCurrentSpeed() < volvo.getEnginePower());
        assertTrue(volvo.getCurrentSpeed() > 0);

        assertTrue(initSpeedSaab > saab.getCurrentSpeed());
        assertTrue(initSpeedVolvo > volvo.getCurrentSpeed());
    }

    @Test
    void move() {
        saab.startEngine();
        volvo.startEngine();
        saab.gas(0.4);
        volvo.gas(0.4);
        saab.move();
        volvo.move();
        assertTrue(saab.getY() != 0);
        assertTrue(volvo.getY() != 0);

        saab.setCurrentDir(Car.Directions.EAST);
        volvo.setCurrentDir(Car.Directions.EAST);
        saab.move();
        volvo.move();
        assertTrue(saab.getX() != 0);
        assertTrue(volvo.getX() != 0);
    }

    @Test
    void turnLeft() {
        saab.setCurrentDir(Car.Directions.EAST);
        volvo.setCurrentDir(Car.Directions.EAST);
        saab.turnLeft();
        volvo.turnLeft();

        assertTrue(
                saab.getCurrentDir() == Car.Directions.NORTH);
        assertTrue(
                volvo.getCurrentDir() == Car.Directions.NORTH);
    }

    @Test
    void turnRight() {
        saab.setCurrentDir(Car.Directions.EAST);
        volvo.setCurrentDir(Car.Directions.EAST);
        saab.turnRight();
        volvo.turnRight();

        assertTrue(
                saab.getCurrentDir() == Car.Directions.SOUTH);
        assertTrue(
                volvo.getCurrentDir() == Car.Directions.SOUTH);
    }
}