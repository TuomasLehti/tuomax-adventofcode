package fi.tuomax.adventofcode.year2022.day13;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringListParser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 13, part 1:
 * Distress Signal.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/13">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class DistressSignal_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 13, 1,
            "Distress Signal", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new StringListParser(input);
    }

    @Override
    protected void solve()
    {
        List<String> input = ((StringListParser) parser).getStrings();
        Integer result = 0;
        for (int row = 0; row < input.size(); row += 3)
            if (PacketComparer.inOrder(input.get(row), input.get(row + 1)) == TrinaryBoolean.TRUE)
                result += row / 3 + 1;
        setAnswer(result);
    }

}
