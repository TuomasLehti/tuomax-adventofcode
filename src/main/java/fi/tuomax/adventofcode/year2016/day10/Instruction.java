package fi.tuomax.adventofcode.year2016.day10;

/** 
 * An instruction, which specifies that a specific-valued microchip should be
 * given to a specific bot.
 */
public record Instruction(
    Integer value,
    Integer bot
) {
    
    public static Instruction fromInput(String input)
    {
        String[] parts = input.split(" ");
        return new Instruction(
            Integer.valueOf(parts[1]),
            Integer.valueOf(parts[5])
        );
    }

}
