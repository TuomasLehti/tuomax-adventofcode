package fi.tuomax.adventofcode.framework.solving;

/**
 * <p>The metadata associated with <a href="https://adventofcode.com/">Advent 
 * of Code</a> puzzles.</p>
 * 
 * <p>Advent of Code is a yearly programming event. There are 25 programming
 * puzzles in each year's event, one for each day in december before christmas, 
 * and each puzzle is divided into two parts. This means that at least the 
 * year, day and part are needed to tell different puzzles apart.</p>
 * 
 * <p>Each day has a name, which is included here for pretty printouts of the
 * results of a puzzle.</p>
 * 
 * <p>Sometimes it is possible to use different algorithms to solve a puzzle.
 * The version-field tells apart the different versions of algorightm.</p>
 * 
 * @param year
 *      The year of the event.
 * @param day
 *      The day in the current event.
 * @param part
 *      The part of the current puzzle.
 * @param name
 *      The name of the puzzle.
 * @param version
 *      The version of the solving algorithm.
 */
public record Metadata(
    Integer year,
    Integer day,
    Integer part,
    String name,
    String version
) 
{
}