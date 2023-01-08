const chai = require("chai");
const moment = require("moment");
const should = chai.should();

function getGreeting(currentTime, name) {
  hour = moment(currentTime).hours();

  if (hour >= 6 && hour < 12) return `Buenos días ${name}!`;

  if (hour >= 12 && hour < 20) return `!Buenas tardes ${name}!`;

  return `¡Buenas noches ${name}!`;
}

class Oche {
  constructor(name) {
    if (!name) throw "name is required";
    this.name = name;
  }
  start() {
    return `¡Buenas noches ${this.name}!`;
  }
}

describe("greeter unit tests", () => {
  const name = "Liz";
  [...Array(6).keys()].forEach((index) => {
    const hour = 6 + index;
    it(`should greet you in the morning at ${hour}`, () => {
      const time = new Date(2022, 10, 4, hour);
      const greeting = getGreeting(time, name);
      greeting.should.eq(`Buenos días ${name}!`);
    });
  });
  it("should greet you at noon", () => {
    const time = new Date(2022, 10, 4, 12);
    const greeting = getGreeting(time, name);
    greeting.should.eq(`!Buenas tardes ${name}!`);
  });

  [...Array(8).keys()].forEach((index) => {
    const hour = 12 + index;
    it(`should greet you in the afternoon at ${hour}`, () => {
      const time = new Date(2022, 10, 4, hour);
      const greeting = getGreeting(time, name);
      greeting.should.eq(`!Buenas tardes ${name}!`);
    });
  });

  it("should greet you in the night", () => {
    const time = moment(new Date(2022, 10, 4, 20));
    [...Array(8).keys()].forEach((index) => {
      const greeting = getGreeting(time.toDate(), name);
      greeting.should.eq(`¡Buenas noches ${name}!`);
      time.add(1, "hours");
    });
  });
});

describe("oche unit tests", () => {
  it("should require a name", () => {
    chai.expect(() => new Oche()).to.throw("name is required");
  });

  it("should greet you in the morning", () => {
    const name = "Alistair";
    const oche = new Oche(name);

    const result = oche.start();
    result.should.contain(name);
  });
});
