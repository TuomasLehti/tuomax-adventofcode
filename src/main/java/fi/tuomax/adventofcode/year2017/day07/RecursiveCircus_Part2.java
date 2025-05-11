package fi.tuomax.adventofcode.year2017.day07;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 7, part 2:
 * Recursive Circus.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/7">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class RecursiveCircus_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 7, 2,
            "Recursive Circus", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new RecursiveCircus_Parser(input);
    }

    @Override
    protected void solve()
    {
        CircusProgram tree = ((RecursiveCircus_Parser) parser).getProgramTree();
        tree.balance();
        setAnswer(tree.balance());
    }

}
