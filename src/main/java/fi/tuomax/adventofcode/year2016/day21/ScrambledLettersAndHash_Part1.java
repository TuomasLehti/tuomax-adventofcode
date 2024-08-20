package fi.tuomax.adventofcode.year2016.day21;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringListParser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2016, day 21, part 1:
 * Scrambled Letters and Hash.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2016/day/21">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class ScrambledLettersAndHash_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2016, 21, 1,
            "Scrambled Letters and Hash", ""
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
        String scramblee = parameters.getJSONObject("part1").getString("scramblee");
        Scrambler scrambler = new Scrambler(scramblee);
        for (String s : ((StringListParser) parser).getStrings())
            scrambler.scramble(s);
        setAnswer(scrambler.toString());
    }

}
