import { expect } from "chai";
import { Parrot, ParrotTypes } from "../src/parrot";

describe("Parrot", () => {
    describe("getSpeed", () => {
        it("should return the base speed for a European parrot", () => {
            const parrot = new Parrot(ParrotTypes.EUROPEAN, 0, 0.0, false);
            expect(parrot.getSpeed()).to.equal(12);
        });

        it("should return the base speed minus load factor multiplied by number of coconuts for an African parrot", () => {
            const numberOfCoconuts = 2;
            const parrot = new Parrot(ParrotTypes.AFRICAN, numberOfCoconuts, 0.0, false);
            const expectedSpeed = 12 - 9 * numberOfCoconuts;
            expect(parrot.getSpeed()).to.equal(expectedSpeed);
        });

        it("should return 0 for a nailed Norwegian Blue parrot", () => {
            const parrot = new Parrot(ParrotTypes.NORWEGIAN_BLUE, 0, 0.0, true);
            expect(parrot.getSpeed()).to.equal(0);
        });

        it("should return the base speed with voltage for an unnailed Norwegian Blue parrot", () => {
            const voltage = 0.5;
            const parrot = new Parrot(ParrotTypes.NORWEGIAN_BLUE, 0, voltage, false);
            const expectedSpeed = Math.min(24, voltage * 12);
            expect(parrot.getSpeed()).to.equal(expectedSpeed);
        });
    });
});
