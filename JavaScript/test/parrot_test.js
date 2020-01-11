const {expect} = require('chai');
const {Parrot, PARROT_TYPES} = require('../src/parrot');

describe("Parrot", function() {

  it("should foo", function() {
    var parrot = new Parrot(PARROT_TYPES.AFRICAN, 0, 0.0, false);

    var speed = parrot.getSpeed();

    expect(speed).to.equal(0.0);
  });

});
