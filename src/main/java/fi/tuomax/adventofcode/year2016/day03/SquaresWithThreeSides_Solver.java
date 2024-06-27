package fi.tuomax.adventofcode.year2016.day03;

import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solving logic for Advent of Code 2016, day 3: 
 * Squares With Three Sides.
 * @see 
 *      <a href="https://adventofcode.com/2016/day/3">
 *      Puzzle on the Advent of Code website.</a>
 */
public abstract class SquaresWithThreeSides_Solver
extends Solver
{

    @Override
    protected void solve() {
        Integer numOfPossibles = 0;
        for (Triangle triangle : (SquaresWithThreeSides_Parser) parser)
            if (triangle.isPossible())
                numOfPossibles++;
        setAnswer(numOfPossibles);
    }
    
}
