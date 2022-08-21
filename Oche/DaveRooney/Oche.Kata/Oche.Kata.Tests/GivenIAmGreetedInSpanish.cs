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
    }

    public class Greeter
    {
        public string Execute(int hour, string username)
        {
            if (hour > 23)
            {
                throw new ApplicationException("Hour cannot be more than 23");
            }

            if (hour >= 20 || hour < 6)
            {
                return $"¡Buenas noches {username}";
            }

            if (hour >= 6 && hour < 12)
            {
                return $"¡Buenas dias {username}";
            }

            return "Not set yet";
        }
    }
}