package fi.tuomax.adventofcode.year2015.day05;

public class StringNicenessEvaluator_Part1 
extends StringNicenessEvaluator
{

    @Override
    public Boolean isNice(String input) 
    {
        return 
            !hasAForbiddenPair(input) && 
            hasThreeWovels(input) && 
            hasLetterTwiceInARow(input);
    }

    private final String[] FORBIDDEN_PAIRS = 
        new String[]{"ab", "cd", "pq", "xy"};

    private final String WOVELS = "aeiou";

    private Boolean hasAForbiddenPair(String input) 
    {
        for (String s : FORBIDDEN_PAIRS)
            if (input.contains(s)) return true;
        return false;
    }

    private Boolean hasThreeWovels(String input) 
    {
        Integer wovelCount = 0;
        for (Character c : input.toCharArray()) {
            if (WOVELS.contains(c.toString())) wovelCount++;
            if (wovelCount == 3) return true;
        }
        return false;
    }

    private Boolean hasLetterTwiceInARow(String input) 
    {
        for (int i = 0; i < input.length()-1; i++)
            if (input.charAt(i) == input.charAt(i+1)) return true;
        return false;
    }
    
}
