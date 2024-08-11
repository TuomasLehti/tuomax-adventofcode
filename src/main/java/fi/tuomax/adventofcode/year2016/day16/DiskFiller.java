package fi.tuomax.adventofcode.year2016.day16;

/**
 * Generates an appropriate initial state for Advent of Code 2016, day 16.
 */
public class DiskFiller 
{

    /**
     * Generates fisk filling data following the rules from the puzzle.
     */
    public static String fill(String a)
    {
        StringBuilder b = new StringBuilder(a);
        b = b.reverse();
        StringBuilder result = new StringBuilder(a).append("0");
        for (char c : b.toString().toCharArray()) {
            result.append(c == '1' ? '0' : '1');
        }
        return result.toString();
    }

    public static String fill(String a, Integer length)
    {
        while (a.length() < length)
            a = DiskFiller.fill(a);
        return a.substring(0, length);
    }
    
}
