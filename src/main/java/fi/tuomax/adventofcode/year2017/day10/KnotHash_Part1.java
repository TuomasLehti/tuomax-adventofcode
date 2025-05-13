package fi.tuomax.adventofcode.year2017.day10;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.IntegerListParser;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 10, part 1:
 * Knot Hash.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/10">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class KnotHash_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 10, 1,
            "Knot Hash", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new IntegerListParser(input, ",");
    }

    @Override
    protected void solve()
    {
        KnotHasher hasher = new KnotHasher(getParamInt("hash_size"));
        for (Integer i : ((IntegerListParser) parser).getIntegers()) {
            hasher.run(i);
        }
        setAnswer(hasher.getAnswer());
    }

}
