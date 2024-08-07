package fi.tuomax.adventofcode.year2016.day14;

import fi.tuomax.adventofcode.commons.MD5Requirement;

public class ConsecutiveCharsRequirement 
extends MD5Requirement
{

    private char wanted;

    public char getWanted() 
    {
        return wanted;
    }

    private int length;

    public ConsecutiveCharsRequirement(char wanted, int length)
    {
        this.wanted = wanted;
        this.length = length;
    }

    public ConsecutiveCharsRequirement(int length)
    {
        this.wanted = '\0';
        this.length = length;
    }

    @Override
    public Boolean fulfilledBy(String md5) 
    {
        for (int i = 0; i <= md5.length() - length; i++) {
            if ((wanted == '\0' || md5.charAt(i) == wanted) && isRowOfChars(md5, i, length))
                return true;
        }
        return false;
    }

    private Boolean isRowOfChars(String md5, Integer start, Integer length)
    {
        for (int i = 1; i < length; i++) {
            if (md5.charAt(start) != md5.charAt(start + i))
                return false;
        }
        wanted = md5.charAt(start);
        return true;
    }
    
}
