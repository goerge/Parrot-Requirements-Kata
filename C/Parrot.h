#include <stdbool.h>
typedef enum { EUROPEAN, AFRICAN, NORWEGIAN_BLUE } ParrotType;

typedef struct
{
    ParrotType parrotType;
    int numberOfCoconuts;
    float voltage;
    bool isNailed;
} Parrot;

extern void init_parrot(Parrot* parrot, ParrotType parrotType, int numberOfCoconuts, float voltage, bool isNailed);
extern float get_speed(Parrot *parrot);
