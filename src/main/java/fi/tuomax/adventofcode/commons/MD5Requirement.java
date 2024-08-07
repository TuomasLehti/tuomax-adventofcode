package fi.tuomax.adventofcode.commons;

/**
 * A requirement for a MD5 in Advent of Code puzzles.
 */
public abstract class MD5Requirement 
{

    public abstract Boolean fulfilledBy(String md5);
    
}
