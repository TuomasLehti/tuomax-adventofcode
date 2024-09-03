package fi.tuomax.adventofcode.year2022.day08;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 8, part 2:
 * Treetop Tree House.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/8">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class TreetopTreeHouse_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 8, 2,
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

        // The viewing distance of the edges is always zero.

        Integer maxDistance = Integer.MIN_VALUE;
        for (int row = 1; row < forest.height() - 1; row++)
            for (int col = 1; col < forest.width() - 1; col++) {
                Integer distance = 1;
                // up
                int i = row - 1;
                while (i >= 0 && forest.get(col, row).getHeight() > forest.get(col, i).getHeight())
                    i--;
                int distUp = row - i;
                if (i < 0) distUp--;
                distance *= distUp;
                // down
                i = row + 1;
                while (i < forest.height() && forest.get(col, row).getHeight() > forest.get(col, i).getHeight())
                    i++;
                int distDown = i - row;
                if (i >= forest.height()) distDown--;
                distance *= distDown;
                // left
                i = col - 1;
                while (i >= 0 && forest.get(col, row).getHeight() > forest.get(i, row).getHeight())
                    i--;
                int distLeft = col - i;
                if (i < 0) distLeft--;
                distance *= distLeft;
                // right
                i = col + 1;
                while (i < forest.height() && forest.get(col, row).getHeight() > forest.get(i, row).getHeight())
                    i++;
                int distRight = i - col;
                if (i >= forest.width()) distRight--;
                distance *= distRight;
                maxDistance = Math.max(maxDistance, distance);
            }
        setAnswer(maxDistance);
    
    }

    private void print(Grid<Tree> forest) {
        for (int row = 0; row < forest.height(); row++) {
            for (int col = 0; col < forest.width(); col++) 
                if (forest.get(col, row).isVisible())
                    System.out.print("[" + forest.get(col, row).getHeight() + "]");
                else
                    System.out.print(" " + forest.get(col, row).getHeight() + " ");
           System.out.println(); 
        }  
    }

}

// 10530 too low
// 604998 too high