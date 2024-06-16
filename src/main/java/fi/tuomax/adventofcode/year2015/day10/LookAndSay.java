package fi.tuomax.adventofcode.year2015.day10;

/**
 * Naive implementation of John Conway's look and say -sequence.
 * @see https://en.wikipedia.org/wiki/Look-and-say_sequence
 */
public class LookAndSay 
{

    public static String lookAndSay(String input)
    {
        char[] chars = input.toCharArray();
        StringBuilder result = new StringBuilder();
        int blockStart = 0;
        while (blockStart < chars.length) {
            int blockEnd = blockStart + 1;
            while (blockEnd < chars.length && chars[blockStart] == chars[blockEnd]) {
                blockEnd++;
            }
            int blockLen = blockEnd - blockStart;
            result.append(blockLen);
            result.append(chars[blockStart]);
            blockStart = blockEnd;
        }
        return result.toString();
    }
    
}
