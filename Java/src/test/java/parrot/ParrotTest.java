package parrot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static parrot.ParrotTypeEnum.EUROPEAN;

class ParrotTest {

    @Test
    void foo() {
        Parrot parrot = new Parrot(EUROPEAN, 0, 0.0, false);

        final double speed = parrot.getSpeed();

        assertEquals(0.0, speed);
    }
}

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
