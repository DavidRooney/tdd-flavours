namespace Oche.Kata.Tests
{
    public class GivenIAmGreetedInSpanish
    {
        [Test]
        public void WhenItIsTheEveningOrEarlyMorning_ThenNoches()
        {
            var eveningTime = new TimeSpan(20, 00, 00);

            var sut = new Greeter();
            var result = sut.Execute(eveningTime);

            Assert.That(result, Is.Not.Null);
        }

        public class Greeter
        {
            public object Execute(TimeSpan eveningTime)
            {
                throw new NotImplementedException();
            }
        }
    }
}