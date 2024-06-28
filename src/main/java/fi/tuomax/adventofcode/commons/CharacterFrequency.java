package fi.tuomax.adventofcode.commons;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record CharacterFrequency(
    Character c,
    Integer amt
) 
{

    public CharacterFrequency increment()
    {
        return new CharacterFrequency(c(), amt() + 1);
    }

    public static List<CharacterFrequency> count(String s)
    {
        Map<Character, CharacterFrequency> freqs = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (!freqs.containsKey(c))
                freqs.put(c, new CharacterFrequency(c, 0));
            freqs.put(c, freqs.get(c).increment());
        }
        List<CharacterFrequency> result = new ArrayList<>();
        for (Character c : freqs.keySet())
            result.add(freqs.get(c));
        return result;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof CharacterFrequency)) return false;
        CharacterFrequency other = (CharacterFrequency) o;
        return this.c().equals(other.c());
    }

    public static final Comparator<CharacterFrequency> ALPHABET_ASCENDING_COMPARATOR = new Comparator<>(){
        @Override
        public int compare(CharacterFrequency o1, CharacterFrequency o2) {
            return o1.c().compareTo(o2.c());
        }
    };

    public static final Comparator<CharacterFrequency> AMOUNT_ASCENDING_COMPARATOR = new Comparator<>(){
        @Override
        public int compare(CharacterFrequency o1, CharacterFrequency o2) {
            return o1.amt().compareTo(o2.amt());
        }
    };

    public static final Comparator<CharacterFrequency> AMOUNT_DESCENDING_COMPARATOR = new Comparator<>(){
        @Override
        public int compare(CharacterFrequency o1, CharacterFrequency o2) {
            return o2.amt().compareTo(o1.amt());
        }
    };

    
}
