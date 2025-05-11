package fi.tuomax.adventofcode.year2017.day01;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 1, part 2:
 * Inverse Captcha.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/1">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class InverseCaptcha_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 1, 2,
            "Inverse Captcha", ""
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
        String input = ((StringParser) parser).getString();
        int origLength = input.length();
        input += input;
        int ans = 0;
        int offset = origLength / 2;
        for (int idx = 0; idx < origLength; idx++) {
            if (input.charAt(idx) == input.charAt(idx + offset)) {
                ans += input.charAt(idx) - 48;
            }
        }
        setAnswer(ans);
    }

}
