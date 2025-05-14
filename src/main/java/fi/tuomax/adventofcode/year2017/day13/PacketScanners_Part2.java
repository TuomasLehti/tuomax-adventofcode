package fi.tuomax.adventofcode.year2017.day13;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;
import java.util.Map;

/**
 * <p>Solves Advent of Code 2017, day 13, part 2:
 * Packet Scanners.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/13">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class PacketScanners_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 13, 2,
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
        Map<Integer, Layer> layers = ((PacketScanners_Parser) parser).getLayers();
        Integer maxDepth = Layer.getMaxDepth(layers);

        Integer delay = 10;

        Boolean gotCaught = true;

        while (gotCaught) {

//            if ((delay % 1000) == 0) System.out.println(delay);

            gotCaught = false;
            for (int depth = 0; depth <= maxDepth; depth++) {
                Layer layer = layers.getOrDefault(depth, null);
                if (layer != null) {
                    if (layer.blocksAt(layer.getDepth() + delay)) {
                        gotCaught = true;
                        break;
                    }
                }
            }
            delay++;
        }
        setAnswer(--delay);
    }

}
