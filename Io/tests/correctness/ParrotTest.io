doRelativeFile("../../io/Parrot.io")

ParrotTest := UnitTest clone do(

    testFoo := method(
        parrot := Parrot with(ParrotType EUROPEAN, 0, 0, false)

        speed := parrot getSpeed

        assertEquals(0.0, speed)
    )

)
