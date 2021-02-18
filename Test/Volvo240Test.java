import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {
    Volvo240 volvo240 = new Volvo240();

    Volvo240Test() throws IOException {
    }

    @Test
    void testSpeedFactor() {
        assertTrue(volvo240.speedFactor() > 0);
    }
}