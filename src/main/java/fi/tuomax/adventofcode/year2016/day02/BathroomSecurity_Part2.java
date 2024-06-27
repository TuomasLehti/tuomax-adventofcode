package fi.tuomax.adventofcode.year2016.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * Solves Advent of Code 2016, day 2, part 2: 
 * Bathroom Security.
 * @see 
 *      <a href="https://adventofcode.com/2016/day/2">
 *      Puzzle on the Advent of Code website.</a>
 */
public class BathroomSecurity_Part2 
extends BathroomSecurity_Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 2, 2, 
            "Bathroom Security", ""
        );
    }

    private List<Coordinates> forbidden = 
            new ArrayList<>(Arrays.asList(new Coordinates[]{
                new Coordinates(-2L, 2L),
                new Coordinates(-1L, 2L),
                new Coordinates(1L, 2L),
                new Coordinates(2L, 2L),

                new Coordinates(-2L, 1L),
                new Coordinates(2L, 1L),

                new Coordinates(-2L, -1L),
                new Coordinates(2L, -1L),

                new Coordinates(-2L, -2L),
                new Coordinates(-1L, -2L),
                new Coordinates(1L, -2L),
                new Coordinates(2L, -2L),
            }));

    @Override
    protected boolean outOfBounds(Coordinates currentCoords) 
    {
        return 
            currentCoords.x() < -2L || currentCoords.x() > 2L ||
            currentCoords.y() < -2L || currentCoords.y() > 2L ||
            forbidden.contains(currentCoords);
}

    @Override
    protected String getKey(Coordinates currentCoords) 
    {
        if (currentCoords.equals(new Coordinates( 0L, +2L)))
            return "1";
        if (currentCoords.equals(new Coordinates(-1L, +1L)))
            return "2";
        if (currentCoords.equals(new Coordinates( 0L, +1L)))
            return "3";
        if (currentCoords.equals(new Coordinates(+1L, +1L)))
            return "4";
        if (currentCoords.equals(new Coordinates(-2L,  0L)))
            return "5";
        if (currentCoords.equals(new Coordinates(-1L,  0L)))
            return "6";
        if (currentCoords.equals(new Coordinates( 0L,  0L)))
            return "7";
        if (currentCoords.equals(new Coordinates(+1L,  0L)))
            return "8";
        if (currentCoords.equals(new Coordinates(+2L,  0L)))
            return "9";
        if (currentCoords.equals(new Coordinates(-1L, -1L)))
            return "A";
        if (currentCoords.equals(new Coordinates( 0L, -1L)))
            return "B";
        if (currentCoords.equals(new Coordinates(+1L, -1L)))
            return "C";
        if (currentCoords.equals(new Coordinates( 0L, -2L)))
            return "D";
        return "0";
    }

    @Override
    protected void setStartPosition() 
    {
        walker.setCurrentCoords(new Coordinates(-2L, 0L));
    }

   
}
