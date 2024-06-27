package fi.tuomax.adventofcode.year2016.day02;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * Solves Advent of Code 2016, day 2, part 1: 
 * Bathroom Security.
 * @see 
 *      <a href="https://adventofcode.com/2016/day/2">
 *      Puzzle on the Advent of Code website.</a>
 */
public class BathroomSecurity_Part1 
extends BathroomSecurity_Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 2, 1, 
            "Bathroom Security", ""
        );
    }


    @Override
    protected boolean outOfBounds(Coordinates currentCoords) 
    {
        return 
            currentCoords.x() < -1L || currentCoords.x() > 1L ||
            currentCoords.y() < -1L || currentCoords.y() > 1L;
    }

    @Override
    protected String getKey(Coordinates currentCoords) 
    {
        if (currentCoords.equals(new Coordinates(-1L, 1L)))
            return "1";
        else if (currentCoords.equals(new Coordinates(0L, 1L)))
            return "2";
        else if (currentCoords.equals(new Coordinates(1L, 1L)))
            return "3";
        else if (currentCoords.equals(new Coordinates(-1L, 0L)))
            return "4";
        else if (currentCoords.equals(new Coordinates(0L, 0L)))
            return "5";
        else if (currentCoords.equals(new Coordinates(1L, 0L)))
            return "6";
        else if (currentCoords.equals(new Coordinates(-1L, -1L)))
            return "7";
        else if (currentCoords.equals(new Coordinates(0L, -1L)))
            return "8";
        else if (currentCoords.equals(new Coordinates(1L, -1L)))
            return "9";
        return "0";
    }


    @Override
    protected void setStartPosition() 
    {
        walker.setCurrentCoords(Coordinates.ORIGIN);
    }

}
