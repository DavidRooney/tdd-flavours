namespace Oche.Kata.Tests
{
    public class GivenIHaveAnInputString
    {
        [TestCase("test", "tset")]
        [TestCase("test 123 45", "54 321 tset")]
        public void ThenICanReverseAString(string input, string expectedOutput)
        {
            var sut = new Reverser();
            var result = sut.Execute(input);

            Assert.That(result, Is.EqualTo(expectedOutput));
        }
    }
}