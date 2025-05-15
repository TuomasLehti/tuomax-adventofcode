package fi.tuomax.adventofcode.year2017.day15;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 15, part 1:
 * Dueling Generators.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/15">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class DuelingGenerators_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 15, 1,
            "Dueling Generators", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new DuelingGenerators_Parser(input);
    }

    @Override
    protected void solve()
    {
        Generator genA = new Generator(
            ((DuelingGenerators_Parser) parser).getGenAStart(), 
            getParamLong("gen_a_factor")
        );
        Generator genB = new Generator(
            ((DuelingGenerators_Parser) parser).getGenBStart(), 
            getParamLong("gen_b_factor")
        );

        long numOfMatches = 0;
        for (long round = 1; round <= 40_000_000; round++) {
            if ((round % 100_000) == 0) {
                System.out.println(round);
            }
            long a = genA.calculate();
            long b = genB.calculate();
            if ((a & 65535) == (b & 65535)) {
                numOfMatches++;
            }
        }

        setAnswer(numOfMatches);
    }

}
