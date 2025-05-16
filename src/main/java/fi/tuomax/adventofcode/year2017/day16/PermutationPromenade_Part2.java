package fi.tuomax.adventofcode.year2017.day16;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 16, part 2:
 * Permutation Promenade.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/16">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class PermutationPromenade_Part2
extends PermutationPromenade_Part1
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 16, 2,
            "Permutation Promenade", ""
        );
    }

    @Override
    protected void dance()
    {
        List<String> danceFloors = new ArrayList<>();
        String danceFloorStr = new String(danceFloor);
        while (!danceFloors.contains(danceFloorStr)) {
            danceFloors.add(danceFloorStr);
            danceForOneRound();
            danceFloorStr = new String(danceFloor);
        }
        int cycleStart = danceFloors.indexOf(danceFloorStr);
        long target = 1_000_000_000L;
        int indexOfTarget = CycleCalculator.indexOfTarget(
                cycleStart, danceFloors.size(), target);
        setAnswer(danceFloors.get(indexOfTarget));
    }

}
