import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {
    Saab95 saab = new Saab95();

    @Test
    void testSetTurboOn() {
        saab.setTurboOn();
        assertTrue(saab.turboOn);
    }

    @Test
    void testSetTurboOff() {
        saab.setTurboOff();
        assertTrue(!saab.turboOn);
    }

    @Test
    void testSpeedFactor() {
        assertTrue(saab.speedFactor() > 0);
    }
}