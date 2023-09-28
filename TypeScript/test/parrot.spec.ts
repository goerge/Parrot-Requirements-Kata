import { expect } from "chai";
import { Parrot, ParrotTypes } from "../src/parrot";

describe("Parrot", () => {
    describe("getSpeed", () => {
        it("should return the base speed for a European parrot", () => {
            // Arrange
            const parrot = new Parrot(ParrotTypes.EUROPEAN, 0, 0.0, false);

            // Act
            const actualSpeed = parrot.getSpeed();

            // Assert
            expect(actualSpeed).to.equal(12);
        });

        it("should return the base speed minus load factor multiplied by number of coconuts for an African parrot", () => {
            // Arrange
            const numberOfCoconuts = 2;
            const parrot = new Parrot(ParrotTypes.AFRICAN, numberOfCoconuts, 0.0, false);

            // Act
            const actualSpeed = parrot.getSpeed();

            // Assert
            // expect(actualSpeed).to.equal(12 - 9 * numberOfCoconuts);
            expect(actualSpeed).to.equal(0);
        });

        it("should return 0 for a nailed Norwegian Blue parrot", () => {
            // Arrange
            const parrot = new Parrot(ParrotTypes.NORWEGIAN_BLUE, 0, 0.0, true);

            // Act
            const actualSpeed = parrot.getSpeed();

            // Assert
            expect(actualSpeed).to.equal(0);
        });

        it("should return the base speed with voltage for an unnailed Norwegian Blue parrot", () => {
            // Arrange
            const voltage = 0.5;
            const parrot = new Parrot(ParrotTypes.NORWEGIAN_BLUE, 0, voltage, false);

            // Act
            const actualSpeed = parrot.getSpeed();

            // Assert
            expect(actualSpeed).to.equal(Math.min(24, voltage * 12));
        });
    });
});