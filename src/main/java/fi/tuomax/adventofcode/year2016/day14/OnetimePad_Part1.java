package fi.tuomax.adventofcode.year2016.day14;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.commons.MD5;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * <p>Solves Advent of Code 2016, day 14, part 1: 
 * One-time Pad.</p>
 * 
 * <p>The solution is very slow, but I hear it can be sped up by splitting the
 * counting of the hashes across multiple cores. Multithreading solution has to
 * wait, however, until I've completed other puzzles of year 2016, and then
 * the multithreaded MD5 searcher can be put to use in other MD5 puzzles as 
 * well.</p>
 * 
 * @see 
 *      <a href="https://adventofcode.com/2016/day/14">
 *      Puzzle on the Advent of Code website.</a>
 */
public class OnetimePad_Part1 
extends Solver
{

    private static final Logger LOGGER = LoggerFactory.getLogger(OnetimePad_Part1.class);

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 14, 1,
            "One-Time Pad", ""
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
        MD5.clearCache();
        int numOfKeys = parameters.getInt("num_of_keys");
        String salt = ((StringParser) parser).getString();
        int keyIdx = 0;
        int hashIdx = 0;
        while (keyIdx < (numOfKeys)) {
            ConsecutiveCharsRequirement threeReq = new ConsecutiveCharsRequirement(3);
            int three = MD5.getNumber(salt, threeReq, 1, hashIdx, -1);
            int five = MD5.getNumber(
                salt, 
                new ConsecutiveCharsRequirement(
                    threeReq.getWanted(), 5), 
                1,
                three + 1, 
                three + 1000
            );
            three++;
            if (five > -1) {
                keyIdx++;
                LOGGER.debug(String.format("Key %d found.", keyIdx));
            }
            hashIdx = three;

        }
        setAnswer(--hashIdx);
    }
    
}

// 20465 too high
// 14968 too low