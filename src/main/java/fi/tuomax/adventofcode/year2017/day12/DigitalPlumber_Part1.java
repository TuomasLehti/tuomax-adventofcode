package fi.tuomax.adventofcode.year2017.day12;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>Solves Advent of Code 2017, day 12, part 1:
 * Digital Plumber.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/12">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class DigitalPlumber_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 12, 1,
            "Digital Plumber", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new DigitalPlumber_Parser(input);
    }

    protected Map<String, List<String>> pipes; 

    protected List<String> getConnectedPipes(String start)
    {
        List<String> queue = new ArrayList<>();
        Integer queueIdx = 0;
        queue.add(start);
        while (queueIdx < queue.size()) {
            List<String> pipe = pipes.get(queue.get(queueIdx));
            for (String connection : pipe) {
                if (!queue.contains(connection)) {
                    queue.add(connection);
                }
            }
            queueIdx++;
        }
        return queue;
    }

    @Override
    protected void solve()
    {
        pipes = ((DigitalPlumber_Parser) parser).getPipes();
        setAnswer(getConnectedPipes("0").size());
    }

}
