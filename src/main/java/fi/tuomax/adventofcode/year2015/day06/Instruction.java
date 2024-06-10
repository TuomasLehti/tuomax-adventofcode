package fi.tuomax.adventofcode.year2015.day06;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * An instruction to turn an area of lights on or off.
 */
public record Instruction (
    Coordinates topLeft,
    Coordinates bottomRight,
    Command command
) {

    public static Instruction fromInput(String input) 
    {
        ArrayList<String> parts = new ArrayList<>(
            Arrays.asList(input.trim().split(" |,")));

        /*
         * The word "turn" in the beginning of on/off-insturctions is 
         * unnecessary, so it can be removed to make the parsing of the
         * rest of the string easier.
         */
        if (parts.get(0).equals("turn")) 
            parts.remove(0);

        Coordinates topLeft = new Coordinates(
            Long.valueOf(parts.get(1)), 
            Long.valueOf(parts.get(2)));
        Coordinates bottomRight = new Coordinates(
            Long.valueOf(parts.get(4)), 
            Long.valueOf(parts.get(5)));

        Command command = Command.fromString(parts.get(0));

        return new Instruction(topLeft, bottomRight, command);
    }
    
}
