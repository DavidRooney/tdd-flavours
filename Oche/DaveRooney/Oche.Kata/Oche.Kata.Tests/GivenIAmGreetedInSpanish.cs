namespace Oche.Kata.Tests
{
    public class GivenIAmGreetedInSpanish
    {
        [Test]
        public void WhenItIsTheEvening_ThenNoches_WithUsername()
        {
            var eveningTime = new TimeSpan(20, 0, 0);

            var sut = new Greeter();
            var result = sut.Execute(eveningTime, "Dave");

            Assert.That(result, Is.EqualTo("¡Buenas noches"));
        }

        [Test]
        public void WhenItIsTheEarlyMorning_ThenNoches_WithUsername()
        {
            var eveningTime = new TimeSpan(3, 0, 0);

            var sut = new Greeter();
            var result = sut.Execute(eveningTime, "Dave");

            Assert.That(result, Is.EqualTo("¡Buenas noches"));
        }
    }

    public class Greeter
    {
        public string Execute(TimeSpan eveningTime)
        {
            if (eveningTime.Hours >= 20 || eveningTime.Hours < 6)
            {
                return "¡Buenas noches";
            }

            return "FAIL";
        }
    }
}