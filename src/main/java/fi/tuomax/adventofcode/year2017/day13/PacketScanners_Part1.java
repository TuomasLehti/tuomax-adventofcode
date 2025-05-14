package fi.tuomax.adventofcode.year2017.day13;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 13, part 1:
 * Packet Scanners.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/13">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class PacketScanners_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 13, 1,
            "Packet Scanners", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new PacketScanners_Parser(input);
    }

    @Override
    protected void solve()
    {
        List<Layer> layers = ((PacketScanners_Parser) parser).getLayers();
        Integer totalSeverity = 0;
        for (Layer layer : layers) {
            if (layer.blocksAt(layer.getDepth())) {
                totalSeverity += layer.getDepth() * layer.getRange();
            }
        }
        setAnswer(totalSeverity);
    }

}
