package fi.tuomax.adventofcode.year2016.day21;

import fi.tuomax.adventofcode.framework.solving.Metadata;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringListParser;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * <p>Solves Advent of Code 2016, day 21, part 2:
 * Scrambled Letters and Hash.</p>
 * 
 * <p>Once again the difficulty level doesn't rise significantly for part 2.
 * It is easy to just brute force things and we're not forced to think our
 * algorithms. Maybe doing 8 year old puzzles has that effect and these weren't
 * brute-forceable back then?</p>
 * 
 * @see
 *      <a href="https://adventofcode.com/2016/day/21">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class ScrambledLettersAndHash_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2016, 21, 2,
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
        String scramblee = parameters.getJSONObject("part2").getString("scramblee");
        Scrambler scrambler = new Scrambler(scramblee);
        List<String> operations = ((StringListParser) parser).getStrings();
        for (int idx = operations.size() - 1; idx >= 0; idx--)
            scrambler.unscramble(operations.get(idx));
        setAnswer(scrambler.toString());
    }

}

// dcgfeabh not it
// egfdbcha not it
