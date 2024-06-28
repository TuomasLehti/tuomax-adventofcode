package fi.tuomax.adventofcode.commons;

import java.util.Map;
import java.util.TreeMap;

public class Statistics 
{

    /**
     * Counts the amount of each character in a string.
     */
    public static Map<Character, Integer> frequencies(String input)
    {
        Map<Character, Integer> frequencies = new TreeMap<>();
        for (Character c : input.toCharArray())
            frequencies.put(c, frequencies.getOrDefault(c, Integer.valueOf(0)) + 1);
        return frequencies;
    }
    
}
