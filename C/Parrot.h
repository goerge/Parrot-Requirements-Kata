enum ParrotType { EUROPEAN, AFRICAN, NORWEGIAN_BLUE};

typedef struct
{
    ParrotType parrotType;
    int numberOfCoconuts;
    float voltage;
    bool isNailed;
} Parrot;

extern Parrot* init_parrot(Parrot* parrot, ParrotType parrotType, int numberOfCoconuts, float voltage, bool isNailed);
extern float get_speed(Parrot *parrot);
