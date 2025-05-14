package fi.tuomax.adventofcode.year2017.day12;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Solves Advent of Code 2017, day 12, part 2:
 * Digital Plumber.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/12">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class DigitalPlumber_Part2
extends DigitalPlumber_Part1
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 12, 2,
            "Digital Plumber", ""
        );
    }

    private String findUncheckedPipe(Set<String> checkedPipes)
    {
        for (String pipe : pipes.keySet()) {
            if (!checkedPipes.contains(pipe)) {
                return pipe;
            }
        }
        return "";
    }

    @Override
    protected void solve()
    {
        pipes = ((DigitalPlumber_Parser) parser).getPipes();
        Set<String> checkedPipes = new HashSet<>();
        Integer numOfGroups = 0;
        String uncheckedPipe = findUncheckedPipe(checkedPipes);
        while (!uncheckedPipe.isEmpty()) {
            numOfGroups++;
            List<String> connectedPipes = getConnectedPipes(uncheckedPipe);
            checkedPipes.addAll(connectedPipes);
            uncheckedPipe = findUncheckedPipe(checkedPipes);
        }
        setAnswer(numOfGroups);
    }

}
