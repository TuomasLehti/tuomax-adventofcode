package fi.tuomax.adventofcode.year2016.day22;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2016, day 22, part 1:
 * Grid Computing.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2016/day/22">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class GridComputing_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2016, 22, 1,
            "Grid Computing", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new GridComputing_Parser(input);
    }

    @Override
    protected void solve()
    {
        Grid<Node> grid = ((GridComputing_Parser) parser).getGrid();

        Integer viablePairs = 0;
        for (int y = 0; y < 31; y++) {
            for (int x = 0; x < 34; x++) {
                Node nodeA = grid.get(x, y);
                if (nodeA != null) {
                    for (int j = 0; j < 31; j++) {
                        for (int i = 0; i < 34; i++) {
                            Node nodeB = grid.get(i, j);
                            if (nodeB != null &&
                                    !nodeA.equals(nodeB) && 
                                        !nodeA.getUsed().equals(0) && 
                                                nodeB.getAvail() >= nodeA.getUsed()) {
                                viablePairs++;
                            }
                        }
                    }
    
                }
            }
        }
        setAnswer(viablePairs);
    }

}

// 92 not it
// 934 for someone else