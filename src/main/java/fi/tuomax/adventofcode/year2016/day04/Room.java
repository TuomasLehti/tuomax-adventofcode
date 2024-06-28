package fi.tuomax.adventofcode.year2016.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import fi.tuomax.adventofcode.commons.CharacterFrequency;
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
        List<CharacterFrequency> freqs = CharacterFrequency.count(encryptedName);
        Collections.sort(freqs, CharacterFrequency.AMOUNT_DESCENDING_COMPARATOR);
        StringBuilder sb = new StringBuilder();
        for (CharacterFrequency freq : freqs)
            sb.append(freq.c());
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