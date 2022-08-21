namespace Oche.Kata.Tests
{
    public class GivenIAmGreetedInSpanish
    {
        [TestCase(20)]
        [TestCase(23)]
        [TestCase(00)]
        [TestCase(05)]
        public void WhenItIsTheEveningOrMorning_ThenNoches_WithUsername(int hour)
        {
            var eveningTime = new TimeSpan(hour, 0, 0);
            var username = "Dave";

            var sut = new Greeter();
            var result = sut.Execute(eveningTime, username);

            Assert.That(result, Is.EqualTo($"¡Buenas noches {username}"));
        }

        [TestCase(24)]
        public void WhenAnInvalidTimeIsSupplied_ThenFAIL(int hour)
        {
            var eveningTime = new TimeSpan(hour, 0, 0);
            var username = "Dave";

            var sut = new Greeter();
            var result = sut.Execute(eveningTime, username);

            Assert.That(result, Is.EqualTo("FAIL"));
        }
    }

    public class Greeter
    {
        public string Execute(TimeSpan eveningTime, string username)
        {
            if (eveningTime.Hours >= 20 || eveningTime.Hours < 6)
            {
                return $"¡Buenas noches {username}";
            }

            return "FAIL";
        }
    }
}