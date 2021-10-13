import { expect } from "chai";
import "mocha";
import { Parrot, ParrotTypes } from "../src/parrot";

describe("Parrot", () => {

    it("should foo", () => {
        var parrot = new Parrot(ParrotTypes.EUROPEAN, 0, 0.0, false);

        expect(parrot.getSpeed()).eql(0.0);
    });

});
