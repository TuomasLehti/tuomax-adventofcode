package fi.tuomax.adventofcode.commons.pathfinding;

import fi.tuomax.adventofcode.commons.Coordinates;

/**
 * An abstract representation of an Advent of Code maze.
 */
public abstract class MazeGenerator 
{
    
    public abstract Boolean isWall(Coordinates coordinates);
    
}
