# Advent of Code

This repository contains code for [Advent of Code](https://adventofcode.com/), 
which is a yearly collection of coding puzzles.

## Framework

The framework consists of different stages, which are
1) inputting,
1) parsing,
1) solving, and 
1) printing the results

### Inputting

The first stage is InputFactory, which reads inputs from different sources and
converts them to a list of strings.

Puzzle inputs should not be distributed, which is why I've not included them in
this repository. They should be stored in the local machine, and methods in the
```InputFactory```-class should be used to locate and load them based on the 
metadata for the year and day.

The default directory for the inputs and other files for a given day is
```<project_dir>/inputs/yearYYYY/dayDD/```, where YYYY is the year and DD is
the day. The default file name for the input is ```YYYY-DD input.txt``` and
for the parameters ```YYYY-DD parameters.json```.

For testing purposes, where there are more than one input to test, inputs can
be read from a json file. ```PuzzleTester```-class has methods for converting 
json test suites to ```PuzzleTestCase```-objects.

An example testing json from the very first puzzle (2015, day 1). These inputs
are not included in the Advent of Code site, so no worries there.
```
{   
    "part1" : [ 
        {
            "input": "(((()))(((()))",
            "answer": "2"
        },
        {
            "input": "()())()(",
            "answer": "0"
        },
    ],
    "part2" : [ 
        {
            "file": "2015-01 test.txt",
            "answer": "..."
        }
    ]
}
```

### Parsing

The list of strings is then passed on to different parsers, which parse the 
input so that they make sense to solvers. If InputFactory performs the physical
action of reading input to memory, then Parsers give the meaning to the inputs.

If a parser needs to perform a lengthy task, it should keep the user informed
of the progress via debug-level logging.

### Solving

Solver takes the parsed input from the parser and solves the puzzle (or at 
least tries to). If the puzzle includes information, which the solver needs
for solving the puzzle, but which is not given in the puzzle input, a solver
can receive a set of parameters in JSON format.

There may be more than one way to solve a puzzle. If this is the case, each
day can have multiple solving algorithms, each one of which is contained in
its own Solver. This means that every day can be divided into more than one
algorithm.

It should be noted, that everything will be easier if all algorithms can solve
both parts of the puzzle.

Solvers may have parameters, which are essential parts for solving the puzzle,
which are not included in the puzzle input. The width and the height of a grid
could be parameters, if they can't be deduced from the puzzle input.

These parameters reside in a json file in the input directory for a puzzle.
Each part of the puzzle should have a json object in the file, located in the
root node of the json.

A special case of a parameter is the expected puzzle answer. This is, of 
course, not known, when first solving the puzzle, but it may be useful later,
when refactoring. The printers can and will format things differently based
upon the correctness of the answer.

An example json file could look like this:

```
{
    "part1" : {
        "width" : 100,
        "height" : 100,
        "expected_answer" : "10000"
    },
    "part2" : {
        "width" : 500,
        "height" : 500,
        "expected_answer" : "250000"
    }
}
```

If a solver needs to perform a lengthy task, it should keep the user informed
of the progress via debug-level logging.

### Reasoning for Separate Parsing and Solving

Parsing and solving are separated, because they are different responsibilities,
at least in my mind. Separation also makes the code clearer in a case where the 
solving logic is the same for both parts of a puzzle, but parsing logic is
different, at least in my mind. I haven't come across such puzzles yet, but I
guess it's good to futureproof things. At the very least, the parsing can get
quite complicated and extracting it to its own class makes code cleaner, at
least in my mind, once again.

That being said, it is also true, that parsers should not be used by 
themselves, at least not in the "production side". They are always an integral
part of a solver.

Testing parsers independently, however, should not be only allowed but also 
encouraged.

### Storing Solvers

There is a data structure to hold all the solvers for different years, days, 
algorithms and parts.

The place, in which the solvers are added to the data strucure, has not yet
been finally decided.

### Running Solvers

There will be a few different ways to run different sets of solvers. Some 
running scenarios are:

- Run the latest addition, which is used when new puzzles are solved. If
  there are more algorithms to compare, a speed trial is going to be needed.
- Run all the solvers for a given day. This would be a kind of a speed trial,
  which reports the timings of different algorithms to the user.
- Run all the solvers for a given year, or for all the years. This should
  automatically test the speed of different algorithms used to solve a given
  day and select the fastest available algorithm.

### Printing

After a set of solvers has been run, the results are taken from the solvers and 
printed out by a printer class.

## Roadmap

The development is divided into many branches.

The y2016-branch concentrates on refactoring puzzles from Advent of Code 2016.

The y2015-branch concentrates on refactoring the slow algorithms from the first 
year.

Years 2022 and 2023 have been partially solved earlier in a different 
environment. Each one has its own branch to migrate them to this framework and
to complete them.

Framework is being worked on in its own branch. Periodically the other branches
may be rebased from this branch, if they benefit from framework updates.

To do:
- 2015 day 23: convert to generic cpu
- Totally revamp the MD5 puzzle algorithm, which is a mess after so many tweaks
  needed by so many puzzles.

## Progress through the years

In this framework I did years 2015 and 2016 first. Then I started to import 
solutions from year 2022 to this framework, which got put to the back burner
while I solved year 2020 and watched Dylan Beattie's streams of year 2020 after
first solving them myself. This process was still in progress when the event
for year 2024 began, so I consentrated on that next.

## Year 2024

| Day | Part 1 | Part 2 | Notes |
|---|---|---|---|
| 1  | 1.12.2024 | 1.12.2024 |  |
| 2  | 2.12.2024 | 2.12.2024 |  |
| 3  | 3.12.2024 | 3.12.2024 |  |
| 4  | 4.12.2024 | 4.12.2024 |  |
| 5  | 5.12.2024 |  |  |
| 6  |  |  |  |
| 7  | 7.12.2024 | 7.12.2024 |  |
| 8  | 8.12.2024 | 8.12.2024 |  |
| 9  | 9.12.2024 | 9.12.2024 |  |
| 10 |  |  |  |
| 11 |  |  |  |
| 12 |  |  |  |
| 13 |  |  |  |
| 14 | 14.12.2024 | 14.12.2024 |  |
| 15 |  |  |  |
| 16 |  |  |  |
| 17 |  |  |  |
| 18 |  |  |  |
| 19 |  |  |  |
| 20 |  |  |  |
| 21 |  |  |  |
| 22 |  |  |  |
| 23 |  |  |  |
| 24 |  |  |  |
| 25 |  |  |  |


## Year 2022

Days 1 to 7 were solved in a different environment. The dates mentioned here
are the dates of migrating these puzzles to this framework.

| Day | Part 1 | Part 2 | Notes |
|---|---|---|---|
| 1  | 30.8.2024 | 30.8.2024 |  |
| 2  | 31.8.2024 | 31.8.2024 |  |
| 3  | 31.8.2024 | 31.8.2024 |  |
| 4  | 31.8.2024 | 31.8.2024 |  |
| 5  | 2.9.2024 | 2.9.2024 |  |
| 6  | 2.9.2024 | 2.9.2024 |  |
| 7  | 2.9.2024 | 2.9.2024 |  |
| 8  | 3.9.2024 | 3.9.2024 |  |
| 9  | 4.9.2024 | 4.9.2024 |  |
| 10 | 5.9.2024 | 5.9.2024 |  |
| 11 | 6.9.2024 | 7.9.2024 |  |
| 12 | 7.9.2024 | 7.9.2024 |  |
| 13 | 8.9.2024 | 8.9.2024 |  |
| 14 | 8.9.2024 | 8.9.2024 |  |
| 15 | 9.9.2024 | 10.9.2024 |  |
| 16 |  |  |  |
| 17 |  |  |  |
| 18 |  |  |  |
| 19 |  |  |  |
| 20 |  |  |  |
| 21 |  |  |  |
| 22 |  |  |  |
| 23 |  |  |  |
| 24 |  |  |  |
| 25 |  |  |  |


## Year 2016

Solving the puzzles of 2016 in 2024 seemed pretty easy. You could brute-force
your way through the problems quite easily and not think about clever 
algorithms. Maybe doing 8 year old puzzles has that effect and these weren't
brute-forceable back then?

| Day | Part 1 | Part 2 | Notes |
|---|---|---|---|
| 1  | 23.6.2024 | 23.6.2024 |  |
| 2  | 27.6.2024 | 27.6.2024 |  |
| 3  | 27.6.2024 | 27.6.2024 |  |
| 4  | 27.6.2024 | 27.6.2024 |  |
| 5  | 28.6.2024 | 28.6.2024 |  |
| 6  | 28.6.2024 | 28.6.2024 |  |
| 7  | 28.6.2024 | 28.6.2024 |  |
| 8  | 1.7.2024  | 1.7.2024  | (1) |
| 9  | 6.7.2024  | 7.7.2024  |  |
| 10 | 9.7.2024  | 9.7.2024  |  |
| 11 | 3.8.2024  | 3.8.2024  | (2) |
| 12 | 3.8.2024  | 2.8.2024  |  |
| 13 | 5.8.2024  | 5.8.2024  |  |
| 14 | 6.8.2024 | 6.8.2024 |  |
| 15 | 7.8.2024 | 7.8.2024 |  |
| 16 | 11.8.2024 | 11.8.2024 |  |
| 17 | 11.8.2024 | 11.8.2024 |  |
| 18 | 12.8.2024 | 12.8.2024 |  |
| 19 | 12.8.2024 | 14.8.2024 |  |
| 20 | 17.8.2024 | 17.8.2024 |  |
| 21 | 19.8.2024 | 20.8.2024 |  |
| 22 | 20.8.2024 | 21.8.2024 |  |
| 23 | 22.8.2024 | 23.8.2024 | (3) |
| 24 | 24.8.2024 | 24.8.2024 |  |
| 25 | 28.8.2024 | n/a       |  |

1) Part 2 is solved visually. It should be converted to use text recognition
   just for the fun of it.

2) No parser included yet.

3) Assembunny computer could use an optimizer.

## Year 2015

Dates are for the first solve on a previous framework, if not otherwise noted.

| Day | Part 1 | Part 2 | Notes |
|---|---|---|---|
| 1  | 31.12.2023 | 31.12.2023 |  |
| 2  | 31.12.2023 | 31.12.2023 |  |
| 3  | 1.1.2024   | 1.1.2024   |  |
| 4  | 1.1.2024   | 1.1.2024   |  |
| 5  | 1.1.2024   | 1.1.2024   |  |
| 6  | 5.1.2024   | 5.1.2024   | Includes two algorithms. |
| 7  | 6.1.2024   | 6.1.2024   |  |
| 8  | 6.1.2024   | 6.1.2024   |  |
| 9  | 11.1.2024  | 11.1.2024  |  |
| 10 | 12.1.2024  | 13.1.2024  |  |
| 11 | 16.1.2024  | 16.1.2024  |  |
| 12 | 17.1.2024  | 17.1.2024  |  |
| 13 | 24.1.2024  | 24.1.2024  |  |
| 14 | 24.1.2024  | 24.1.2024  |  |
| 15 | 26.1.2024  | 26.1.2024  |  |
| 16 | 26.1.2024  | 26.1.2024  |  |
| 17 | 28.1.2024  | 28.1.2024  |  |
| 18 | 30.3.2024  | 30.3.2024  |  |
| 19 | 22.6.2024  | 22.6.2024  | (1) (2) |
| 20 | 10.5.2024  | 10.5.2024  | (3) |
| 21 | 16.5.2024  | 16.5.2024  |  |
| 22 | 23.6.2024  | 23.6.2024  | (1) (4) |
| 23 | 19.5.2024  | 19.5.2024  |  |
| 24 | 19.5.2024  | 19.5.2024  | (5) |
| 25 | 23.6.2024  | n/a        | (1) |

1) The date of import to this framework.

2) I don't consider part 2 solved yet, because I had to look the solution up.

3) Very slow algorithm (1-2 minutes), must be made faster.

4) The code is a slow mess and produces right results when part 2 is run 
   independently, but not when preceeded by part 1. This must be refactored 
   or even rewritten.

5) Needs refactoring.

