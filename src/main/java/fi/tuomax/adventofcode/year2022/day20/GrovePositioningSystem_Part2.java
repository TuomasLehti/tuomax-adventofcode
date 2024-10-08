package fi.tuomax.adventofcode.year2022.day20;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 20, part 2:
 * Grove Positioning System.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/20">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class GrovePositioningSystem_Part2
extends GrovePositioningSystem_Part1
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 20, 2,
            "Grove Positioning System", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new GrovePositioningSystem_Parser_Part2(input, getParamLong("decryption_key"));
    }

}
