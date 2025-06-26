package fi.tuomax.adventofcode.year2017.day19;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 19, part 1:
 * A Series of Tubes.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/19">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class ASeriesOfTubes_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 19, 1,
            "A Series of Tubes", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new ASeriesOfTubes_Parser(input);
    }

    @Override
    protected void solve()
    {
        Diagram diagram = ((ASeriesOfTubes_Parser) parser).getDiagram();
        Packet packet = new Packet(diagram);
        packet.findTheWay();
        setAnswer(packet.getLetters());
    }

    

}
