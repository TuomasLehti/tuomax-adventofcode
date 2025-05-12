package fi.tuomax.adventofcode.year2017.day09;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 9, part 2:
 * Stream Processing.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/9">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class StreamProcessing_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 9, 2,
            "Stream Processing", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new StringParser(input);
    }

    @Override
    protected void solve()
    {
        char[] chars = ((StringParser) parser).getString().toCharArray();
        boolean inGarbage = false;
        int idx = 0;
        int garbageCount = 0;
        while (idx < chars.length) {
            if (!inGarbage) {
                if (chars[idx] == '<') {
                    inGarbage = true;
                }
            } else {
                if (chars[idx] == '!') {
                    idx++;
                } else if (chars[idx] == '>') {
                    inGarbage = false;
                } else {
                    garbageCount++;
                }
            }
            idx++;
        }
        setAnswer(garbageCount);
}

}
