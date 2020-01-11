package parrot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParrotTest {

    @Test
    void foo() {
        Parrot parrot = new Parrot(ParrotTypeEnum.AFRICAN, 0, 0.0, false);

        final double speed = parrot.getSpeed();

        assertEquals(0.0, speed);
    }
}
