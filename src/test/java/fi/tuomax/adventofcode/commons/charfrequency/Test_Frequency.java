package fi.tuomax.adventofcode.commons.charfrequency;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.commons.CharacterFrequency;

public class Test_Frequency 
{

    @Test
    public void test_AlphabetComparator()
    {
        List<CharacterFrequency> freqs = new ArrayList<>(Arrays.asList(new CharacterFrequency[]{
            new CharacterFrequency('a', 1),
            new CharacterFrequency('c', 2),
            new CharacterFrequency('b', 3),
            new CharacterFrequency('d', 0),
        }));
        Collections.sort(freqs, CharacterFrequency.ALPHABET_ASCENDING_COMPARATOR);
        assertEquals(Character.valueOf('a'), freqs.get(0).c());
        assertEquals(Character.valueOf('b'), freqs.get(1).c());
        assertEquals(Character.valueOf('c'), freqs.get(2).c());
        assertEquals(Character.valueOf('d'), freqs.get(3).c());
    }

    @Test
    public void test_AmountComparator()
    {
        List<CharacterFrequency> freqs = new ArrayList<>(Arrays.asList(new CharacterFrequency[]{
            new CharacterFrequency('a', 1),
            new CharacterFrequency('d', 0),
            new CharacterFrequency('b', 3),
            new CharacterFrequency('c', 2),
        }));
        Collections.sort(freqs, CharacterFrequency.AMOUNT_ASCENDING_COMPARATOR);
        assertEquals(Character.valueOf('d'), freqs.get(0).c());
        assertEquals(Character.valueOf('a'), freqs.get(1).c());
        assertEquals(Character.valueOf('c'), freqs.get(2).c());
        assertEquals(Character.valueOf('b'), freqs.get(3).c());
    }

    @Test
    public void test_AmountReverseComparator()
    {
        List<CharacterFrequency> freqs = new ArrayList<>(Arrays.asList(new CharacterFrequency[]{
            new CharacterFrequency('a', 1),
            new CharacterFrequency('d', 0),
            new CharacterFrequency('b', 3),
            new CharacterFrequency('c', 2),
        }));
        Collections.sort(freqs, CharacterFrequency.AMOUNT_DESCENDING_COMPARATOR);
        assertEquals(Character.valueOf('b'), freqs.get(0).c());
        assertEquals(Character.valueOf('c'), freqs.get(1).c());
        assertEquals(Character.valueOf('a'), freqs.get(2).c());
        assertEquals(Character.valueOf('d'), freqs.get(3).c());
    }
    
}
