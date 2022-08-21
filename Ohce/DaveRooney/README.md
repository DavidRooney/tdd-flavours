# Additional notes
Firstly I accidently made a spelling mistake with the name. Renaming it means the git history isn't part of the folder any more but since it's the first in the repository it's not too much of a big deal (I hope).

For me, I start with the simpliest thing I can. I get that working and I focus on functionality and ignore the fact the kata wants a console application. I focus on simple tests that make sense to move me forward. Then in the end I can connect the smaller modules together to produce something "useful" (the kata solution). I think of code like Lego pieces.

Things that pop into my mind now are that I want an integration test for the console app. but this is about TDD and not a testing strategy. This makes me think if I'm missing the overall story in TDD. But this isn't how I've learned TDD. I Don't write a big story at the start I simply take small steps in functionality and when things feel whole then I organise them.

There's also the question of breaking "contracts" that have been described in the kata story. I change the Greeter from handling TimeSpans to handing an int as an hour parameter. Have I just broken a contract here? Changing the Greeter class now would mean breaking changes for it's callers. In the end I have the tests to help me and they are very small and self contained.

I hope this kata helps!