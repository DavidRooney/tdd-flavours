namespace Oche.Kata.Tests
{
    public class GivenIHaveAnInputString
    {
        [TestCase("test", "tset")]
        [TestCase("test 123 45", "54 321 tset")]
        public void CanReverseText(string input, string expectedOutput)
        {
            var sut = new Reverser();
            var result = sut.Execute(input);

            Assert.That(result, Is.EqualTo(expectedOutput));
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