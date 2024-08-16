package fi.tuomax.adventofcode.year2015.day06.lightranges;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.commons.Range;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;
import fi.tuomax.adventofcode.year2015.day06.Instruction;
import fi.tuomax.adventofcode.year2015.day06.Light;
import fi.tuomax.adventofcode.year2015.day06.ProbablyAFireHazard_Parser;

/** 
 * <p>Solving logic for Advent of Code 2015, part 6:
 * Probably a Fire Hazard</p>
 * 
 * <p>This solution works by dividing the grid of lights to smaller and smaller
 * rectangles, whose lights are toggled together. In the best case this should
 * be a significant speed-up.</p>
 * 
 * <p>It turns out that my input divides the grid into about 2x2 rectangles,
 * which should cut the runtime by four. After all we are toggling once for 
 * every four lights. But then again the grid contains only million lights, and
 * the runtimes are in the vicinity of one second, so the overhead for dividing
 * and subdividing the grid comes into play.</p>
 * 
 * @see 
 *      <a href="https://adventofcode.com/2015/day/6">
 *      Puzzle on the Advent of Code website.</a>
 */
public abstract class PropablyAFireHazard_LightRanges
extends Solver
{

    public static Metadata METADATA = new Metadata(        
        2015, 
        6, 
        0, 
        "Probably a Fire Hazard", 
        "Light ranges"
    );

    private final Long WIDTH = 1000L;

    private final Long HEIGHT = 1000L;

    @Override
    protected void solve() {
        RangeTree horizontal = new RangeTree(0L, WIDTH - 1);
        RangeTree vertical = new RangeTree(0L, HEIGHT - 1);
        for (Instruction instruction : (ProbablyAFireHazard_Parser) parser) {
            horizontal.splitBefore(instruction.topLeft().x());
            horizontal.splitAfter(instruction.bottomRight().x());
            vertical.splitBefore(instruction.topLeft().y());
            vertical.splitAfter(instruction.bottomRight().y());
        }
        List<Range> horizs = horizontal.flatten();
        List<Range> vertics = vertical.flatten();

        ArrayList<LightRange> lightRanges = new ArrayList<>();
        for (Range horiz : horizs) {
            for (Range vertic : vertics) {
                lightRanges.add(new LightRange(horiz, vertic, getLightInstance()));
            }
        }

        for (Instruction instruction : (ProbablyAFireHazard_Parser) parser) {
            for (LightRange range : lightRanges) {
                range.executeInstruction(instruction);
            }
        }

        Long result = 0L;
        for (LightRange range : lightRanges) {
            result += range.getBrightness();
        }

        setAnswer(result);
    }

    protected abstract Light getLightInstance();
   
}
