package fi.tuomax.adventofcode.year2022.day06;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 6, part 1:
 * Tuning Trouble.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/6">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class TuningTrouble_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 6, 1,
            "Tuning Trouble", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new StringParser(input);
    }

    private Boolean allDifferent(char[] chars)
    {
        for (int i = 0; i < chars.length; i++)
            for (int j = i + 1; j < chars.length; j++)
                if (chars[i] == chars[j]) return false;
        return true;
    }

    @Override
    protected void solve()
    {
        Integer markerLength = getParamInt("marker_length");
        String buffer = ((StringParser) parser).getString();
        for (int i = 0; i < (buffer.length() - markerLength + 1); i++)
            if (allDifferent(buffer.substring(i, i + markerLength).toCharArray())) {
                setAnswer(i + markerLength);
                return;
            }
        setAnswer("not found");
    }

}
