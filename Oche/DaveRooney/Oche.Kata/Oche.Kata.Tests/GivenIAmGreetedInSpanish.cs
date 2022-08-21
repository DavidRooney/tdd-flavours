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
            var username = "Dave";

            var sut = new Greeter();
            var result = sut.Execute(hour, username);

            Assert.That(result, Is.EqualTo($"¡Buenas noches {username}"));
        }

        [TestCase(24)]
        public void WhenAnInvalidTimeIsSupplied_ThenFAIL(int hour)
        {
            var username = "Dave";

            var sut = new Greeter();

            Assert.Throws<ApplicationException>(() => sut.Execute(hour, username));
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

            return "Not set yet";
        }
    }
}