package fi.tuomax.adventofcode.year2017.day25;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 25, part 1:
 * The Halting Problem.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/25">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class TheHaltingProblem_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 25, 1,
            "The Halting Problem", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new TheHaltingProblem_Parser(input);
    }

    private TheHaltingProblem_Parser getParser()
    {
        return (TheHaltingProblem_Parser) parser;
    }

    @Override
    protected void solve()
    {
        TuringMachine machine = new TuringMachine(getParser().getStartState());
        for (int i = 0; i < getParser().getNumOfSteps(); i++)
            machine.process(getParser().getStates().get(machine.getTuringState()));
        setAnswer(machine.numOfOnes());
    }



}
