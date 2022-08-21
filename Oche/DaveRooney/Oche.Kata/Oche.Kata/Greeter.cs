using System.Text;

namespace Oche.Kata
{
    public class Greeter
    {
        public string Execute(int hour, string username)
        {
            GuardAgainstInvalidHour(hour);

            var greetingMessage = new StringBuilder();
            greetingMessage.Append("¡Buenas");

            if (hour >= 20 || hour < 6)
            {
                greetingMessage.Append(" noches ");
            }

            if (hour >= 6 && hour < 12)
            {
                greetingMessage.Append(" dias ");
            }

            if (hour >= 12 && hour < 20)
            {
                greetingMessage.Append(" tardes ");
            }

            greetingMessage.Append(username);

            return greetingMessage.ToString();
        }

        private static void GuardAgainstInvalidHour(int hour)
        {
            if (hour > 23)
            {
                throw new ApplicationException("Hour cannot be more than 23");
            }
        }
    }
}