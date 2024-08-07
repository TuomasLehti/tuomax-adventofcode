package fi.tuomax.adventofcode.year2016.day14;

import fi.tuomax.adventofcode.commons.MD5Requirement;

public class ThreeNumbersRequirement 
extends MD5Requirement
{

    @Override
    public Boolean fulfilledBy(String md5) 
    {
        for (int i = 0; i < md5.length() - 3; i++) {
            if (md5.charAt(i) == md5.charAt(i + 1) && md5.charAt(i) == md5.charAt(i + 2))
                return true;
        }
        return false;
    }
    
}
