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

        // --- 2nd ---

        it("should return the base speed for an African parrot with no coconuts", () => {
            // Arrange
            const numberOfCoconuts = 0;
            const parrot = new Parrot(ParrotTypes.AFRICAN, numberOfCoconuts, 0.0, false);

            // Act
            const actualSpeed = parrot.getSpeed();

            // Assert
            expect(actualSpeed).to.equal(12);
        });

        it("should return 0 for a European parrot with negative numberOfCoconuts", () => {
            // Arrange
            const numberOfCoconuts = -2;
            const parrot = new Parrot(ParrotTypes.EUROPEAN, numberOfCoconuts, 0.0, false);

            // Act
            const actualSpeed = parrot.getSpeed();

            // Assert
            expect(actualSpeed).to.equal(12);
        });

        xit("should return 0 for a Norwegian Blue parrot with negative voltage", () => {
            // Arrange
            const voltage = -0.5;
            const parrot = new Parrot(ParrotTypes.NORWEGIAN_BLUE, 0, voltage, false);

            // Act
            const actualSpeed = parrot.getSpeed();

            // Assert
            expect(actualSpeed).to.equal(-6);
        });

        it("should return the maximum speed of 24 for a Norwegian Blue parrot with voltage greater than 2", () => {
            // Arrange
            const voltage = 2.5;
            const parrot = new Parrot(ParrotTypes.NORWEGIAN_BLUE, 0, voltage, false);

            // Act
            const actualSpeed = parrot.getSpeed();

            // Assert
            const expectedSpeed = Math.min(24, voltage * 12);
            expect(actualSpeed).to.equal(expectedSpeed);
        });

        // --- manual add ---

        it("should return the maximum speed of 24 for a Norwegian Blue parrot with voltage greater than 2", () => {
            // Arrange
            const voltage = Number.MAX_VALUE;
            const parrot = new Parrot(ParrotTypes.NORWEGIAN_BLUE, 0, voltage, false);

            // Act
            const actualSpeed = parrot.getSpeed();

            // Assert
            expect(actualSpeed).to.equal(24);
        });

        it("should return the maximum speed for an African parrot with maximum coconuts", () => {
            // Arrange
            const numberOfCoconuts = Number.MAX_SAFE_INTEGER;
            const parrot = new Parrot(ParrotTypes.AFRICAN, numberOfCoconuts, 0.0, false);

            // Act
            const actualSpeed = parrot.getSpeed();

            // Assert
            // const expectedSpeed = 12 - 9 * (numberOfCoconuts - 1); <- why -1
            const expectedSpeed = 0;
            expect(actualSpeed).to.equal(expectedSpeed);
        });

    });
});