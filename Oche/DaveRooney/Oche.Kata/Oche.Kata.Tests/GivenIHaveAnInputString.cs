namespace Oche.Kata.Tests
{
    public class GivenIHaveAnInputString
    {
        [Test]
        public void CanReverseText()
        {
            var testInput = "test";

            var sut = new Reverser();
            var result = sut.Execute(testInput);

            Assert.That(result, Is.EqualTo("tset"));
        }
    }

    public class Reverser
    {
        public string Execute(string input)
        {
            return string.Join("", input.ToCharArray().Reverse());
        }
    }
}