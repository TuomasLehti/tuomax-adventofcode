package fi.tuomax.adventofcode.year2016.day02;

import java.util.List;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.commons.Walker;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2016, day 2: 
 * Bathroom Security.
 * @see 
 *      <a href="https://adventofcode.com/2016/day/2">
 *      Puzzle on the Advent of Code website.</a>
 */

public abstract class BathroomSecurity_Solver
extends Solver
{

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new BathroomSecurity_Parser(input);
    }

    protected Walker walker = new Walker();

    @Override
    protected void solve() 
    {
        setStartPosition();

        List<List<Direction>> instructions = 
                ((BathroomSecurity_Parser) parser).getInstructions();

        String code = "";
        for (List<Direction> row : instructions) {
            for (Direction dir : row) {
                Coordinates previous = walker.getCurrentCoords();
                walker.step(dir);
                if (outOfBounds(walker.getCurrentCoords()))
                    walker.setCurrentCoords(previous);
            }
            code += getKey(walker.getCurrentCoords());
        }

        setAnswer(code);
    }

    protected abstract void setStartPosition();

    protected abstract boolean outOfBounds(Coordinates currentCoords);

    protected abstract String getKey(Coordinates currentCoords);

}
