package fi.tuomax.adventofcode.year2016.day01;

import java.util.List;

import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.commons.Walker;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2016, day 1, part 1: 
 * No Time for a Taxicab.
 * @see 
 *      <a href="https://adventofcode.com/2016/day/1">
 *      Puzzle on the Advent of Code website.</a>
 */
public class NoTimeForATaxicab_Part1 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 1, 1, 
            "No Time for a Taxicab", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new NoTimeForATaxicab_Parser(input);
    }

    protected Walker walker = null;

    @Override
    protected void solve() 
    {
        /* Takes steps according to the given instructions (puzzle input) until
         * a finished state has been reached or until there are no more 
         * instructions. */
        walker = new Walker();
        Direction.dirStrsInUse = Direction.URDL_DIRSTRS;
        Direction dir = Direction.getInstance();
        for (Instruction instruction : (NoTimeForATaxicab_Parser) parser) {
            if (instruction.getTurn() == 'R')
                dir.turn(Direction.TurnDirection.RIGHT);
            else
                dir.turn(Direction.TurnDirection.LEFT);
            for (int i = 0; i < instruction.getBlocks(); i++) {
                walker.step(dir);
                if (finished()) {
                    setAnswer(walker.getCurrentCoords().taxiCabDistance());
                    return;
                }
            }
        }
        setAnswer(walker.getCurrentCoords().taxiCabDistance());        
    }

    protected Boolean finished() 
    {
        /* No finished state per se in part 1. */
        return false;
    }
    
}
