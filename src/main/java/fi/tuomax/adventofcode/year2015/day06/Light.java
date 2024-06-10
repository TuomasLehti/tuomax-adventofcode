package fi.tuomax.adventofcode.year2015.day06;

/**
 * Represents a light of an Advent of Code puzzle from 2015 (day 6).
 * The lights behave differently in different parts of the puzzle, hence the
 * need for abstraction and inheritance.
 */
public abstract class Light {

    public abstract void executeCommand(Command command);

    public abstract Integer getBrightness();
    
}
