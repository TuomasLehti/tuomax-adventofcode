package fi.tuomax.adventofcode.year2015.day05;

public class StringNicenessEvaluator_Part2 
extends StringNicenessEvaluator
{

    @Override
    public Boolean isNice(String input) 
    {
        return 
            hasRepeatingLetter(input) && 
            hasRepeatingPair(input);
    }
    
    private Boolean hasRepeatingLetter(String input) 
    {
        for (int i = 0; i < input.length() - 2; i++)
            if (input.charAt(i) == input.charAt(i+2)) return true;
        return false;
    }

    private Boolean hasRepeatingPair(String input) 
    {
        for (int i = 0; i < input.length() - 3; i++) {
            String pair = input.substring(i, i+2);
            if (input.indexOf(pair, i+2) > 0)
                return true;
        }
        return false;

    }

}
