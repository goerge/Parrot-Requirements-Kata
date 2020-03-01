#include <stdlib.h> /* size_t for mocka */
#include <setjmp.h> /* jmp_buf for mocka */
#include <stdarg.h> /* va_start for mocka */
#include <cmocka.h>
#include "Parrot.h"

static void test_foo(void** state)
{
    (void)state; /* unused */
    Parrot parrot;
    float speed;

    init_parrot(&parrot, EUROPEAN, 0, 0.0, false);

    speed = get_speed(&parrot);

    assert_float_equal(0.0, speed, 0.0001);
}

int main(void)
{
    const struct CMUnitTest test_suite[] = { /* */
        cmocka_unit_test(test_foo), /* */
    };

    return cmocka_run_group_tests(test_suite, NULL, NULL);
}
