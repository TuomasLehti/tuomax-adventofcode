package fi.tuomax.adventofcode.year2016.day09;

import java.util.Arrays;

/** Decompresses input from Aoc 2016, day 9, part 1. */
public class Decompressor 
{

    /**
     * Counts the decompressed length of the input.
    */
    public Long decompress(String input)
    {
        char[] chars = input.toCharArray();
        int i = 0;
        Long result = 0L;
        while (i < chars.length) {

            /* There was one lone space at the end of my input. I don't know if
             * that was intentional from the AoC creator, or if an error was
             * introduced when I copied the input to my computer. The text of
             * the problem repeatedly tells to ignore whitespace, so you gotta
             * do what you gotta do. */
            if (chars[i] == ' ') {
                // do nothing
            } else if (chars[i] != '(') {
                /* If we're not at a start of a marker, the character of the
                 * input string is added to the output, and thus the length
                 * of the output increases by one. */
                result++;
            } else {
                /* If we're at a start of a marker, we need to calculate, how
                 * many characters the decompressed string will have and add
                 * that to the total length of the output. We parse the marker
                 * and call a method to define the decompressed length. */
                i++;
                StringBuilder marker = new StringBuilder();
                while (i < chars.length && chars[i] != ')')
                    marker.append(chars[i++]);
                String[] splitMerker = marker.toString().split("x");
                Integer len = Integer.valueOf(splitMerker[0]);
                Integer amt = Integer.valueOf(splitMerker[1]);
                char[] data = Arrays.copyOfRange(chars, i + 1, i + len + 1);
                i += len;
                result += (getSectionLength(new String(data)) * amt);
            }
            i++;
        }
        return result;
    }

    /**
     * Counts the length of the uncompressed string. For part 1 this is just
     * the length indicated by the marker itself.
     */
    protected Long getSectionLength(String section)
    {
        return (long) section.length();
    }
    
}
