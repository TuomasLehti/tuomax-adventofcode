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

For testing purposes, where there are more than one input to test, inputs can
be read from a json file. ```PuzzleTester```-class has methods for converting 
json test suites to ```PuzzleTestCase```-objects. Only single-line inputs are 
supported for now.

### Parsing

The list of strings is then passed on to different parsers, which parse the 
input so that they make sense to solvers. If InputFactory performs the physical
action of reading input to memory, then Parsers give the meaning to the inputs.

If a parser needs to perform a lengthy task, it should keep the user informed
of the progress via debug-level logging.

### Solving

Solver takes the parsed input from the parser and solves the puzzle (or at 
least tries to).

There may be more than one way to solve a puzzle. If this is the case, each
day can have multiple solving algorithms, each one of which is contained in
its own Solver. This means that every day can be divided into more than one
algorithm.

It should be noted, that everything will be easier if all algorithms can solve
both parts of the puzzle.

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

## Year 2015

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