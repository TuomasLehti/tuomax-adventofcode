package fi.tuomax.adventofcode.year2017.day04;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringListParser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Solves Advent of Code 2017, day 4, part 1:
 * High-Entropy Passphrases.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/4">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class HighentropyPassphrases_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 4, 1,
            "High-Entropy Passphrases", ""
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
        int ans = 0;
        for (String passPhrase : ((StringListParser) parser).getStrings()) {
            List<String> words = Arrays.asList(passPhrase.split(" "));
            Set<String> distinctWords = new HashSet<>(words);
            if (words.size() == distinctWords.size()) {
                ans++;
            }
            setAnswer(ans);
        }
            
    }

}
