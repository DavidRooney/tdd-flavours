namespace Ohce.Kata
{
    public class Reverser
    {
        public string Execute(string input)
        {
            var reversedInput = string.Join("", input.ToCharArray().Reverse());

            if (input == reversedInput)
            {
                return $"{reversedInput} ¡Bonita palabra!";
            }

            return reversedInput;
        }
    }
}