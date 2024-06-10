package fi.tuomax.adventofcode.y2015.d06;

/**
 * Represents a command from an Advent of Code puzzle from 2015 (day 6).
 */
public enum Command {

    ON, OFF, TOGGLE;

    public static Command fromString(String input) 
    {
        if (input.equals("on")) 
            return ON; 
        else if (input.equals("off")) 
            return OFF; 
        else
            return TOGGLE;
    }
    
}
