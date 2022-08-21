namespace Oche.Kata.Tests
{
    public class GivenIAmGreetedInSpanish
    {
        private const string _username = "Dave";

        private Greeter _greeter;

        [SetUp]
        public void SetUp()
        {
            _greeter = new Greeter();
        }

        [TestCase(20)]
        [TestCase(23)]
        [TestCase(00)]
        [TestCase(05)]
        public void WhenItIsTheEveningOrEarlyMorning_ThenNoches_WithUsername(int hour)
        {
            var result = _greeter.Execute(hour, _username);

            Assert.That(result, Is.EqualTo($"¡Buenas noches {_username}"));
        }

        [TestCase(24)]
        public void WhenAnInvalidTimeIsSupplied_ThenFAIL(int hour)
        {
            Assert.Throws<ApplicationException>(() => _greeter.Execute(hour, string.Empty));
        }

        [TestCase(6)]
        [TestCase(11)]
        public void WhenItIsTheMorning_ThenDias_WithUsername(int hour)
        {
            var result = _greeter.Execute(hour, _username);

            Assert.That(result, Is.EqualTo($"¡Buenas dias {_username}"));
        }

        [TestCase(12)]
        [TestCase(19)]
        public void WhenItIsTheAfternoon_ThenTardes_WithUsername(int hour)
        {
            var result = _greeter.Execute(hour, _username);

            Assert.That(result, Is.EqualTo($"¡Buenas tardes {_username}"));
        }
    }
}