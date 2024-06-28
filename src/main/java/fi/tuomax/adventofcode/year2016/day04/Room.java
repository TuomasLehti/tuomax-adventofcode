package fi.tuomax.adventofcode.year2016.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import fi.tuomax.adventofcode.framework.parsing.Parseable;

/**
 * A room of Advent of Code 2016, day 4.
 */
public class Room 
extends Parseable
{

    private String checkSum;

    private Integer sectorId;

    public Integer getSectorId() 
    {
        return sectorId;
    }

    private String encryptedName;

    public Room(String aocInput) 
    {
        super(aocInput);

        List<String> parts = new ArrayList<>(
                Arrays.asList(aocInput.split("-|\\[|\\]")));

        checkSum = parts.get(parts.size() - 1);
        sectorId = Integer.valueOf(parts.get(parts.size() - 2));

        parts = parts.subList(0, parts.size() - 2);
        encryptedName = String.join("", parts);
    }

    /** For part 1. */
    public Boolean isReal()
    {
        /* This counts the real checksum and compares it to the one given in the 
         * puzzle input. */
        Map<Character, Integer> freqs = Statistics.frequencies(encryptedName);

        Set<Integer> distinctCounts = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (Character c : freqs.keySet())
            distinctCounts.add(freqs.get(c));

        StringBuilder sb = new StringBuilder();
        for (Integer i : distinctCounts)
            for (Character c : freqs.keySet())
                if (freqs.get(c).equals(i))
                    sb.append(c);
    
        return sb.length() >= checkSum.length() && sb.toString().startsWith(checkSum);
    }
    
    /** For part 2. */
    public String getDecryptedName()
    {
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (Character c : encryptedName.toCharArray()) {
            if (ALPHABET.contains(c.toString())) {
                Integer idx = ALPHABET.indexOf(c.toString());
                idx += sectorId;
                idx %= ALPHABET.length();
                sb.append(ALPHABET.charAt(idx));
            } else {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}