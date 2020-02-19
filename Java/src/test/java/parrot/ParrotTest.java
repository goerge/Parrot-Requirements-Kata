package parrot;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static parrot.ParrotTypeEnum.*;

class ParrotTest {

    /*
     * type
     * - European
     * - African
     * - Norwegian
     * - other (wrong input)
     * - null (wrong input)
     * 
     * European ... 1
     * - regardless of input -> 12
     * 
     * African ... 3
     * - numberOfCoconuts 0 -> 12
     * - numberOfCoconuts 1 -> 3
     *                         boundary is between
     * - numberOfCoconuts 2 -> 0 (min)
     * - numberOfCoconuts -1 -> 21 (wrong input)
     * 
     * Norwegian ... 4
     * - isNailed true -> 0
     * - isNailed false, 0 -> 0
     * - isNailed false, 1 -> 12
     * - isNailed false, 2 -> 24 (boundary)
     * - isNailed false, >2 -> 24 (min)
     * - isNailed false, -1 -> -12  (wrong input)
     * 
     * null
     * - -> NullPointer
     */

    @Test
    void European_constantSpeed() {
        Parrot parrot = new Parrot(EUROPEAN, 0, 0.0, false);

        double speed = parrot.getSpeed();

        assertEquals(12.0, speed, Math.ulp(12.0));
    }

    @Test
    void African_notLoaded() {
        Parrot parrot = new Parrot(AFRICAN, 0, 0.0, false);

        double speed = parrot.getSpeed();

        assertEquals(12.0, speed, Math.ulp(12.0));
    }

    @Test
    void African_loaded() {
        Parrot parrot = new Parrot(AFRICAN, 1, 0.0, false);

        double speed = parrot.getSpeed();

        assertEquals(3.0, speed, Math.ulp(12.0));
    }

    @Test
    void African_overloaded() {
        Parrot parrot = new Parrot(AFRICAN, 2, 0.0, false);

        double speed = parrot.getSpeed();

        assertEquals(0.0, speed, Math.ulp(12.0));
    }

    // not really needed, just technical check
    @Test
    void African_overloadedAtMaximum() {
        Parrot parrot = new Parrot(AFRICAN, Integer.MAX_VALUE, 0.0, false);

        double speed = parrot.getSpeed();

        assertEquals(0.0, speed, Math.ulp(12.0));
    }

    @Test
    @Disabled("skipping negative tests, not defined by business")
    void African_negative() {
        // 
    }

    @Test
    void Norwegian_nailed() {
        Parrot parrot = new Parrot(NORWEGIAN_BLUE, 0, 0.0, true);

        double speed = parrot.getSpeed();

        assertEquals(0.0, speed, Math.ulp(12.0));
    }

    @Test
    void Norwegian_noVoltage() {
        Parrot parrot = new Parrot(NORWEGIAN_BLUE, 0, 0.0, false);

        double speed = parrot.getSpeed();

        assertEquals(0.0, speed, Math.ulp(12.0));
    }

    @Test
    void Norwegian_withVoltage() {
        Parrot parrot = new Parrot(NORWEGIAN_BLUE, 0, 1.0, false);

        double speed = parrot.getSpeed();

        assertEquals(12.0, speed, Math.ulp(12.0));
    }

    @Test
    void Norwegian_highVoltage() {
        Parrot parrot = new Parrot(NORWEGIAN_BLUE, 0, 2.0, false);

        double speed = parrot.getSpeed();

        assertEquals(24.0, speed, Math.ulp(12.0));
    }

    @Test
    void Norwegian_overloadVoltage() {
        Parrot parrot = new Parrot(NORWEGIAN_BLUE, 0, 2.00001, false);

        double speed = parrot.getSpeed();

        assertEquals(24.0, speed, Math.ulp(12.0));
    }

    @Test
    void Norwegian_maxVoltage() {
        Parrot parrot = new Parrot(NORWEGIAN_BLUE, 0, Double.MAX_VALUE, false);

        double speed = parrot.getSpeed();

        assertEquals(24.0, speed, Math.ulp(12.0));
    }

    @Test
    @Disabled("skipping negative tests, not defined by business")
    void Norwegian_negative() {
        // 
    }

    @Test
    void null_exception() {
        Parrot parrot = new Parrot(null, 0, 0.0, false);

        assertThrows(NullPointerException.class, () -> parrot.getSpeed());
    }

    // mutation coverage

    // this.isNailed = isNailed; not covered
    // 1. Removed assignment to member variable isNailed → SURVIVED
    // Good catch because we say other value is ignored -> vary it

    @Test
    void Norwegian_nailedForSure() {
        Parrot parrot = new Parrot(NORWEGIAN_BLUE, 0, 1.0, true);

        double speed = parrot.getSpeed();

        assertEquals(0.0, speed, Math.ulp(12.0));
    }

    // return Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
    // 28. Decremented (a--) integer field numberOfCoconuts → SURVIVED
    // I would not test that

    @Test
    void African_doesNotChangeCoconuts() {
        Parrot parrot = new Parrot(AFRICAN, 1, 0.0, false);
        parrot.getSpeed();

        double speed = parrot.getSpeed();

        assertEquals(3.0, speed, Math.ulp(12.0));
    }

    // return getBaseSpeed();
    // 1. removed call to parrot/Parrot::getBaseSpeed → SURVIVED
    // 2. replaced double return with 0.0d for parrot/Parrot::getSpeed → SURVIVED
    // Good catch - similar, the other values should be ignored -> vary it

    @Test
    void European_constantSpeedForSure() {
        Parrot parrot = new Parrot(EUROPEAN, 1, 1.0, false);

        double speed = parrot.getSpeed();

        assertEquals(12.0, speed, Math.ulp(12.0));
    }

    // return (isNailed) ? 0 : getBaseSpeed(voltage);
    // 19. Incremented (a++) double field voltage → SURVIVED
    // 20. Decremented (a--) double field voltage → SURVIVED
    // I would not test that

    @Test
    void Norwegian_doesNotChangeVoltage() {
        Parrot parrot = new Parrot(NORWEGIAN_BLUE, 0, 1.0, false);
        parrot.getSpeed();

        double speed = parrot.getSpeed();

        assertEquals(12.0, speed, Math.ulp(12.0));
    }

}
