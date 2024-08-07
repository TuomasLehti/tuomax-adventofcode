package fi.tuomax.adventofcode.year2016.day15;

/** 
 * A disc from Advent of Code 2016, day 15. 
 */
public record Disc(
    Integer numOfPositions,
    Integer startPosition
) {

    public static Disc fromInput(String input)
    {
        String[] parts = input.split(" |\\.");
        return new Disc(
            Integer.valueOf(parts[3]),
            Integer.valueOf(parts[11])
        );
    }

    public Integer positionAt(Integer time)
    {
        return (startPosition + time) % numOfPositions;
    }
    
}
