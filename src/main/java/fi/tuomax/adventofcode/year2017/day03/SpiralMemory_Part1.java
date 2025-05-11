package fi.tuomax.adventofcode.year2017.day03;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 3, part 1:
 * Spiral Memory.</p>
 * 
 * <p>In anticipation of a much, much larger target for part two I decided to use maths 
 * to calculate the answer.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/3">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class SpiralMemory_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 3, 1,
            "Spiral Memory", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new StringParser(input);
    }

    @Override
    protected void solve()
    {
        int target = Integer.valueOf(((StringParser) parser).getString());

        /*
         * The first number of a loop in the spiral can be counted by:
         * 
         *    w_n-1 * w_n-1 + n
         * 
         * where n is the number of the loop (0 for the 1 in the middle)
         * and w_n-1 is the width of the previous loop.
         * 
         * The width is 1 for the 1 in the middle, 3 for the next loop,
         * 5 for the next, and so forth.
         */

        setAnswer(getCoords(target).taxiCabDistance());

    }

    private int loopWidth(int loopNo)
    {
        return loopNo * 2 + 1;
    }

    private int firstNumOfLoop(int loopNo)
    {
        int prevLoopWidth = loopWidth(loopNo - 1);
        return prevLoopWidth * prevLoopWidth + loopNo;
    }

    private int neCornerNumber(int loopNo)
    {
        int loopWidth = loopWidth(loopNo);
        return firstNumOfLoop(loopNo) + loopWidth / 2;
    }

    private int targetLoopNo(int target)
    {
        int loopNo = 0;
        while (firstNumOfLoop(loopNo) <= target) {
            loopNo++;
        }
        return --loopNo;
    }

    private Coordinates getCoords(int target)
    {
        int targetLoopNo = targetLoopNo(target);
        int width = loopWidth(targetLoopNo);
        int eNum = firstNumOfLoop(targetLoopNo);
        int neNum = neCornerNumber(targetLoopNo);
        int nwNum = neNum + width - 1;
        int swNum = neNum + (width - 1) * 2;
        int seNum = neNum + (width - 1) * 3 + 1; // se corner is one unit further to the right
        int x = 0; 
        int y = 0;
        if (target <= neNum) {
            // NE
            x = width / 2;
            y = target - eNum;
        } else if (target <= nwNum) {
            // N
            x = width / 2 - (target - neNum);
            y = width / 2;
        } else if (target <= swNum) {
            // W
            x = -1 * width / 2;
            y = width / 2 - (target - nwNum);
        } else if (target <= seNum) {
            // S
            x = -1 * width / 2 + (target - swNum);
            y = -1 * (width / 2);
        } else {
            // SE
            x = width / 2 + 1;
            y = (-width / 2) + (target - seNum);
        }
        return Coordinates.fromInteger(x, y);
    }

}
