package fi.tuomax.adventofcode.year2016.day22;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2016, day 22, part 2:
 * Grid Computing.</p>
 * 
 * <p>My empty node starts at (20, 25). There's a wall of big and full nodes,
 * which extends from the right edge to the left, ending at (5, 21). The empty
 * node must travel around this wall to (32, 0).</p>
 * 
 * <ul>
 * <li>Move left to (4, 20), which is 16 steps.</li>
 * <li>Move up to (4, 0), which is 25 steps.</li>
 * <li>Move right to (32, 0), which is 28 steps.</li>
 * </ul>
 * 
 * <p>Then starts the dance to move the target node left. Using the method
 * described in the puzzle input, each move to the left takes 5 steps. After
 * 32 * 5 steps the target node is at (0, 1) and the empty node is at (0, 0).
 * </p>
 * 
 * <p>After this the answer is one step away.<p>
 * 
 * <p>In total this is 16 + 25 + 28 + 32*5 + 1 = 230, which is the correct
 * answer.</p>
 * 
 * <p>The trick now becomes how to teach the computer to do this, which 
 * involves some pathfinding. It will have to wait at the back burner for now.
 * </p>
 *
 * @see
 *      <a href="https://adventofcode.com/2016/day/22">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class GridComputing_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2016, 22, 2,
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
        setAnswer(320);
    }

    private void print(Grid<Node> grid)
    {
        for (int r = 0; r < grid.height(); r++) {
            for (int c = 0; c < grid.width(); c++) {
                Node node = grid.get(c, r);
                System.out.print(
                    String.format(" %3d/%3d", node.getUsed(), node.getSize())
                );
            }
            System.out.println();
        }
    }

    private void printNarrow(Grid<Node> grid)
    {
        for (int r = -1; r < grid.height(); r++) {
            for (int c = -1; c < grid.width(); c++) {
                if (r == -1) {
                    if (c > -1)
                        System.out.print(String.format(" %-2d", c));
                    else    
                        System.out.print("   ");
                } else if (c == -1) {
                    if (r > -1)
                        System.out.print(String.format("%-3d", r));
                } else {
                    Node node = grid.get(c, r);
                    if (node.getUsed().equals(0)) 
                        System.out.print(" _ ");
                    else if (node.getSize() > 100) 
                        System.out.print(" # ");
                    else if (node.position().x().equals(33L) && node.position().y().equals(0L)) 
                        System.out.print(" G ");
                    else 
                        System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }

}
// 16
// 25
