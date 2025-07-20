package fi.tuomax.adventofcode.year2017.day01;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 1, part 1:
 * Inverse Captcha.</p>
 * 
 * <p>The solution uses a method that lengthens the input string in order to
 * get rid of the problem of the index going out of. This is arguably less
 * readable than to just take the remainder of the index mod the size of the 
 * input. This is the way I did it, however, and it works, so this is how it 
 * shall stay.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/1">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class InverseCaptcha_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 1, 1,
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

        /* Account for the circularity of the list. */
        input = input + input.substring(0, 1);
        
        int ans = 0;
        /* We examine pairs of digits, hence -1. */
        for (int idx = 0; idx < input.length() - 1; idx++) {
            if (input.charAt(idx) == input.charAt(idx + 1)) {
                /* ASCII character 0 is encoded as 48. */
                ans += input.charAt(idx) - 48;
            }
        }
        setAnswer(ans);
    }

}
