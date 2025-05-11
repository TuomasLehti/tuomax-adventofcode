package fi.tuomax.adventofcode.year2017.day02;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 2, part 1:
 * Corruption Checksum.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/2">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class CorruptionChecksum_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 2, 1,
            "Corruption Checksum", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new IntegerArrayParser(input);
    }

    @Override
    protected void solve()
    {
        List<List<Integer>> ints = ((IntegerArrayParser) parser).getInts();
        int ans = 0;
        for (List<Integer> row : ints) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (Integer num : row) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            ans += max - min;
        }
        setAnswer(ans);
    }

}
