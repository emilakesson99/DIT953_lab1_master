import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

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

    CarTest() throws IOException {
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

        saab.setCurrentDir(Movable.Directions.EAST);
        volvo.setCurrentDir(Movable.Directions.EAST);
        saab.move();
        volvo.move();
        assertTrue(saab.getX() != 0);
        assertTrue(volvo.getX() != 0);
    }

    @Test
    void turnLeft() {
        saab.setCurrentDir(Movable.Directions.EAST);
        volvo.setCurrentDir(Movable.Directions.EAST);
        saab.turnLeft();
        volvo.turnLeft();

        assertTrue(
                saab.getCurrentDir() == Movable.Directions.NORTH);
        assertTrue(
                volvo.getCurrentDir() == Movable.Directions.NORTH);
    }

    @Test
    void turnRight() {
        saab.setCurrentDir(Movable.Directions.EAST);
        volvo.setCurrentDir(Movable.Directions.EAST);
        saab.turnRight();
        volvo.turnRight();

        assertTrue(
                saab.getCurrentDir() == Movable.Directions.SOUTH);
        assertTrue(
                volvo.getCurrentDir() == Movable.Directions.SOUTH);
    }
}