London Code Dojo 30 - Fibonacci sequence

"Remove zero and duplicate the 1"

1 2 3 5 8 13...

Using these "Fibonacci numbers" as base for numbers, e.g.

1 = 1
2 = 10
3 - 100 or 11
4 = 101
5 = 1000 or 110

Task - show all possible representations of the numbers one to twenty
"10001"

---------------------

listOfFibonacciSumsFor(number)
.map(list -> fibonacciRepresentation(list))

----------------------

-> Large idea (which is validated), small impl steps
-> Idea should be decomposed in steps (halving?)
-> refactoring leads to new paths [high level goal same]