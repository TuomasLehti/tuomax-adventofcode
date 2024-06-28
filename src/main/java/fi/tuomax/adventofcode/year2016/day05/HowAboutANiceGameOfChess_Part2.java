package fi.tuomax.adventofcode.year2016.day05;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2016, day 5, part 2: 
 * How About a Nice Game of Chess?
 * @see 
 *      <a href="https://adventofcode.com/2016/day/5">
 *      Puzzle on the Advent of Code website.</a>
 */
public class HowAboutANiceGameOfChess_Part2 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 5, 2,
            "How About a Nice Game of Chess?", ""
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
        String seed = ((StringParser) parser).getString();
        String[] password = new String[]{"", "", "", "", "", "", "", ""};
        HashFinder.setSeed(seed);
        do {
            String hash = HashFinder.next();
            String idxChar = hash.substring(5, 6);
            if ("01234567".contains(idxChar)) {
                Integer idx = "01234567".indexOf(idxChar);
                if (password[idx].isEmpty())
                    password[idx] = hash.substring(6, 7);
            }
        } while (String.join("", password).length() < 8);
        String pwd = String.join("", password);
        setAnswer(pwd);
    }
    
}
