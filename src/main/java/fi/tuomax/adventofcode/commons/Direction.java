package fi.tuomax.adventofcode.commons;

import java.util.Arrays;

/**
 * A direction in Advent of Code puzzles.
 */
public class Direction 
{

    /**
     * A mode of direction operations. There are eight possible directions in a
     * square grid, but some AoC puzzles only use four of them.
     */
    public enum DirectionMode 
    {
        FOUR_DIRS,
        EIGHT_DIRS
    }

    /**
     * The mode of direction operations. @see ``DirectionMode``. The default
     * mode is four directions due to backwards compatibility.
     */
    public static DirectionMode directionMode = DirectionMode.FOUR_DIRS;

    public static final String[] COMPASS_DIRSTRS = 
            new String[]{"N","NE","E","SE","S","SW","W","NW"};

    public static final String[] URDL_DIRSTRS =
            new String[]{"U","","R","","D","","L",""};

    public static final String[] ARROW_DIRSTRS =
            new String[]{"^","",">","","<","","v",""};
    
    /**
     * The direction string set currently in use. There are a number of ways
     * a direction can be expressed in puzzles, so a conversion to an abstract
     * direction must be made with the aid of ``fromString``-method, which uses
     * this table. The default set is arrows due to backwards compatibility.
     */
    public static String[] dirStrsInUse = ARROW_DIRSTRS;

    public static Integer NORTH = 0;
    public static Integer NORTHEAST = 1;
    public static Integer EAST = 2;
    public static Integer SOUTHEAST = 3;
    public static Integer SOUTH = 4;
    public static Integer SOUTHWEST = 5;
    public static Integer WEST = 6;
    public static Integer NORTHWEST = 7;

    private Direction(Integer dir)
    {
        currentDirection = dir;
    }

    private static Direction[] instances = new Direction[]{
        new Direction(0),
        new Direction(1),
        new Direction(2),
        new Direction(3),
        new Direction(4),
        new Direction(5),
        new Direction(6),
        new Direction(7)
    };

    public static Direction getInstance()
    {
        return instances[NORTH];
    }

    public static Direction getInstance(Integer dir)
    {
        return instances[dir];
    }

    /**
     * Converts a string from AoC puzzle input to an abstract direction.
     * @param dirStr
     *      @see ``dirStrsInUse``
     * @return
     *      An abstract direction.
     * @throws IllegalArgumentException
     *      If the given string is not in the set of direction strings.
     */
    public static Direction fromString(String dirStr)
    throws IllegalArgumentException
    {
        if (Arrays.asList(dirStrsInUse).contains(dirStr))
            return new Direction(Arrays.asList(dirStrsInUse).indexOf(dirStr));
        else    
            throw new IllegalArgumentException(
                    String.format("Unknown direction string: %s!", dirStr));
    }

    private Coordinates[] translations = new Coordinates[]{
        new Coordinates(0L, 1L),
        new Coordinates(1L, 1L),
        new Coordinates(1L, 0L),
        new Coordinates(1L, -1L),
        new Coordinates(0L, -1L),
        new Coordinates(-1L, -1L),
        new Coordinates(-1L, 0L),
        new Coordinates(-1L, 1L)
    };

    public Coordinates asCoordinates()
    {
        return translations[currentDirection];
    }

    private Integer currentDirection = NORTH;

    public Integer get()
    {
        return currentDirection;
    }

    public enum TurnDirection 
    {
        LEFT,
        RIGHT;
    }

    /**
     * @param direction
     * @return
     */
    public Direction turn(TurnDirection direction)
    {
        Integer dir = direction == TurnDirection.LEFT ? -1 : +1;
        Integer amt = directionMode == DirectionMode.FOUR_DIRS ? 2 : 1;
        Integer newDirection = (currentDirection + dir * amt + 8) % 8;
        return getInstance(newDirection);
    }
    
}
