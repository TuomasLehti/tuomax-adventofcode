package fi.tuomax.adventofcode.year2015.day06.lightranges;

import java.util.List;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.year2015.day06.Light;
import fi.tuomax.adventofcode.year2015.day06.Light_Part1;
import fi.tuomax.adventofcode.year2015.day06.ProbablyAFireHazard_Parser;

/** 
 * <p>Solves Advent of Code 2015, day 6, part 1: 
 * Probably a Fire Hazard</p>
 * 
 * <p>This class boils down to a factory, because it just provides the correct
 * light object for this part of the puzzle. The actual logic for solving can 
 * be found from the parent class.</p>
 * 
 * @see 
 *      <a href="https://adventofcode.com/2015/day/6">
 *      Puzzle on the Advent of Code website.</a>
 */
public class ProbablyAFireHazard_LightRanges_Part1 
extends PropablyAFireHazard_LightRanges
{

    @Override
    protected Light getLightInstance() {
        return new Light_Part1();
    }

    @Override
    protected Metadata manufactureMetadata() {
        return new Metadata(        
            2015, 
            6, 
            1, 
            "Probably a Fire Hazard", 
            "Light ranges"
        );    
    }

    @Override
    protected Parser manufactureParser(List<String> input) {
        return new ProbablyAFireHazard_Parser(input);
    }
    
}
