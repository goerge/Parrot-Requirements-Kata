#include <stdio.h>      /* printf */
#include "Parrot.h"

int main()
{
    puts("Parrots!");

    Parrot parrots[3];
    int last = 0;
    init_parrot(parrots + last++, EUROPEAN, 0, 0, false);
    init_parrot(parrots + last++, AFRICAN, 1, 0, false);
    init_parrot(parrots + last++, NORWEGIAN_BLUE, 0, 2.0, false);

    int index;
    for(index = 0; index < last; index++) {
        printf("speed %.1f\n", get_speed(parrots + index));
    }
    printf("\n");

    return 0;
}
