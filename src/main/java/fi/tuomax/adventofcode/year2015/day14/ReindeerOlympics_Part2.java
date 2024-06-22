package fi.tuomax.adventofcode.year2015.day14;

import java.util.Collections;
import java.util.List;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 14, part 2:
 * Reindeer Olympics
 * @see 
 *      <a href="https://adventofcode.com/2015/day/14">
 *      Puzzle on the Advent of Code website.</a>
 */
public class ReindeerOlympics_Part2 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 14, 2,
            "Reindeer Olympics", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new ReindeerOlympics_Parser_Part2(input);
    }

    @Override
    protected void solve() 
    {
        List<Participant> herd = ((ReindeerOlympics_Parser_Part2) parser).getHerd();
        for (int time = 1; time <= 2503; time++) {
            for (Participant participant : herd) {
                participant.step(time);
            }
            Collections.sort(herd); // Sorted by distance travelled
            herd.get(0).awardPoint();
            Integer idx = 1;
            while (idx < herd.size() && herd.get(idx).getDistance().equals(herd.get(0).getDistance())) {
                herd.get(idx).awardPoint();
                idx++;
            }
        }
        Integer maxScore = Integer.MIN_VALUE;
        for (Participant participant : herd)
            maxScore = Math.max(maxScore, participant.getScore());
        setAnswer(maxScore);
    }


}
