package fi.tuomax.adventofcode.year2022.day08;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 8, part 1:
 * Treetop Tree House.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/8">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class TreetopTreeHouse_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 8, 1,
            "Treetop Tree House", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new TreetopTreeHouse_Parser(input);
    }

    @Override
    protected void solve()
    {
        Grid<Tree> forest = ((TreetopTreeHouse_Parser) parser).getTrees();

        // Set the edges visible.
        for (int col = 0; col < forest.width(); col++) {
            forest.get(col, 0).setVisible();
            forest.get(col, forest.height() - 1).setVisible();
        }
        for (int row = 0; row < forest.height(); row++) {
            forest.get(0, row).setVisible();
            forest.get(forest.width() - 1, row).setVisible();
        }

        for (int row = 1; row < forest.height() - 1; row++)
            for (int col = 1; col < forest.width() - 1; col++) {
                // up
                Integer max = -1;
                for (int rr = row - 1; rr >= 0; rr--)
                    max = Math.max(max, forest.get(col, rr).getHeight());
                if (max < forest.get(col, row).getHeight()) {
                    forest.get(col, row).setVisible();
                    continue;
                }
                // down
                max = -1;
                for (int rr = row + 1; rr < forest.height(); rr++)
                    max = Math.max(max, forest.get(col, rr).getHeight());
                if (max < forest.get(col, row).getHeight()) {
                    forest.get(col, row).setVisible();
                    continue;
                }
                // left
                max = -1;
                for (int cc = col - 1; cc >= 0; cc--)
                    max = Math.max(max, forest.get(cc, row).getHeight());
                if (max < forest.get(col, row).getHeight()) {
                    forest.get(col, row).setVisible();
                    continue;
                }
                // right
                max = -1;
                for (int cc = col + 1; cc < forest.width(); cc++)
                    max = Math.max(max, forest.get(cc, row).getHeight());
                if (max < forest.get(col, row).getHeight()) {
                    forest.get(col, row).setVisible();
                    continue;
                }
            }
    
        Integer visible = 0;
        for (int row = 0; row < forest.height(); row++)
            for (int col = 0; col < forest.width(); col++) 
                if (forest.get(col, row).isVisible())
                    visible++;

        setAnswer(visible);
    }

}
