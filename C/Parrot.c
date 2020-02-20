#include <assert.h>
#include "Parrot.h"
#define MIN(x, y) (((x) < (y)) ? (x) : (y))
#define MAX(x, y) (((x) > (y)) ? (x) : (y))

void init_parrot(Parrot* parrot, ParrotType parrotType, int numberOfCoconuts, float voltage, bool isNailed)
{
    parrot->parrotType = parrotType;
    parrot->numberOfCoconuts = numberOfCoconuts;
    parrot->voltage = voltage;
    parrot->isNailed = isNailed;
}

float get_base_speed() {
    return 12.0;
}

float get_load_factor() {
    return 9.0;
}

float get_base_speed_with_voltage(float current_voltage) {
    return MIN(24.0, current_voltage * get_base_speed());
}

float get_speed(Parrot *parrot)
{
    switch (parrot->parrotType) {
        case EUROPEAN:
            return get_base_speed();
        case AFRICAN:
            return MAX(0.0, get_base_speed() - get_load_factor() * parrot->numberOfCoconuts);
        case NORWEGIAN_BLUE:
            return (parrot->isNailed) ? 0 : get_base_speed_with_voltage(parrot->voltage);
        default:
            /* Should be unreachable */
            assert(false);
            return -1;
    }

}
