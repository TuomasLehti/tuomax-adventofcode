package fi.tuomax.adventofcode.year2017.day05;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.IntegerListParser;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 5, part 2:
 * A Maze of Twisty Trampolines, All Alike.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/5">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class AMazeOfTwistyTrampolinesAllAlike_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 5, 2,
            "A Maze of Twisty Trampolines, All Alike", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new IntegerListParser(input);
    }

    @Override
    protected void solve()
    {
        List<Integer> offsets = ((IntegerListParser) parser).getIntegers();
        Integer index = 0;
        Integer offset = 0;
        Integer count = 0;
        while (index < offsets.size()) {
            offset = offsets.get(index);
            if (offsets.get(index) >= 3) {
                offsets.set(index, offsets.get(index) -1);
            } else {
                offsets.set(index, offsets.get(index) + 1);
            }
            index += offset;
            count++;
        }
        setAnswer(count);
    }

}
