package fi.tuomax.adventofcode.year2016.day04;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2016, day 4, part 2: 
 * Security Through Obscurity.
 * @see 
 *      <a href="https://adventofcode.com/2016/day/4">
 *      Puzzle on the Advent of Code website.</a>
 */
public class SecurityThroughObscurity_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 4, 2, 
            "Security Through Obscurity", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new RoomParser(input);
    }

    @Override
    protected void solve() 
    {
        /* Part 2 of the puzzle doesn't give away the target string, it needs
         * to be found from the set of decrypted room names manually. */
        final String TARGET = "northpoleobjectstorage";
        for (Room room : (RoomParser) parser) {
            String rotted = room.getDecryptedName();
            if (rotted.equals(TARGET)) {
                setAnswer(room.getSectorId());
                return;
            }
        }
        setAnswer(Integer.MIN_VALUE);
    }
    
}
