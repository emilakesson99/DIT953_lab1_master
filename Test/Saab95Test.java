import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {
    Saab95 saab = new Saab95();

    Saab95Test() throws IOException {
    }

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