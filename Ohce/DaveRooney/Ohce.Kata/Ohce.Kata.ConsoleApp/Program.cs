using Ohce.Kata;

Console.WriteLine("Whats your name?");
var usersName = Console.ReadLine();

Console.WriteLine(new Greeter().Execute(DateTime.Now.Hour, usersName));

while (true)
{
    Console.WriteLine("What text do you want to reverse?");
    var inputText = Console.ReadLine();

    if (inputText.ToLowerInvariant() == "stop")
    {
        Environment.Exit(1);
    }

    var reversedText = new Reverser().Execute(inputText);
    Console.WriteLine(reversedText);

}