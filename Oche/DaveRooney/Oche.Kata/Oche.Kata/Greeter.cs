namespace Oche.Kata
{
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

            if (hour >= 12 && hour < 20)
            {
                return $"¡Buenas tardes {username}";
            }

            return "Not set yet";
        }
    }
}