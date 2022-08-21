namespace Oche.Kata
{
    public class Reverser
    {
        public string Execute(string input)
        {
            return string.Join("", input.ToCharArray().Reverse());
        }
    }
}