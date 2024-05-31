# Advent of Code

This repository contains code for [Advent of Code](https://adventofcode.com/), 
which is a yearly collection of coding puzzles.

## Framework

The framework consists of different stages.

The first stage is InputFactory, which reads inputs from different sources and
converts them to a list of strings.

The list of strings is then passed on to different parsers, which parse the 
input so that they make sense to solvers. If InputFactory performs the physical
action of reading input to memory, then Parsers give the meaning to the inputs.

Solver takes the parsed input from the parser and solves the puzzle (or at 
least tries to).

There should be a data structure to hold all the solvers for different years,
days and parts.

There should be a way to run different sets of solvers. Some running scenarios
are:
- Run the latest addition, which is used when new puzzles are solved. If
  there are more algorithms to compare, a speed trial is going to be needed.
- Run all the solvers for a given day. This would be a kind of a speed trial,
  which reports the timings of different algorithms to the user.
- Run all the solvers for a given year, or for all the years. This should
  automatically test the speed of different algorithms used to solve a given
  day and select the fastest available algorithm.

After a set of solvers has been run, the results are taken from the solvers and 
printed out by a printer class.