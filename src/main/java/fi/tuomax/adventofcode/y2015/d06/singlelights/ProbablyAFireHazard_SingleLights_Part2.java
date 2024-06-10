package fi.tuomax.adventofcode.y2015.d06.singlelights;

import java.util.List;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.y2015.d06.Light;
import fi.tuomax.adventofcode.y2015.d06.Light_Part2;
import fi.tuomax.adventofcode.y2015.d06.ProbablyAFireHazard_Parser;

/** 
 * <p>Solves Advent of Code 2015, day 6, part 2: 
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
public class ProbablyAFireHazard_SingleLights_Part2
extends PropablyAFireHazard_SingleLights
{

    @Override
    protected Light getLightInstance() 
    {
        return new Light_Part2();
    }

    @Override
    protected Metadata manufactureMetadata() {
        return new Metadata(        
            2015, 
            6, 
            2, 
            "Probably a Fire Hazard", 
            "Single lights"
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) {
        return new ProbablyAFireHazard_Parser(input);
    }
    
}
