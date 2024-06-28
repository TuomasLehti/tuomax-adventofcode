package fi.tuomax.adventofcode.year2016.day07;

public class IpTlsSupportChecker 
extends IpSupportChecker
{

    @Override
    protected Boolean check() {
        for (int i = 1; i < parts.length; i+= 2)
            if (hasAbba(parts[i]))
                return false;
        for (int i = 0; i < parts.length; i+= 2)
            if (hasAbba(parts[i]))
                return true;
        return false;
    }
    
    private boolean hasAbba(String s) 
    {
        for (int i = 0; i < s.length() - 3; i++)
            if (isAbba(s.substring(i, i+4)))
                return true;
        return false;
    }

    private boolean isAbba(String s)
    {
        return 
            s.length() == 4 &&
            s.charAt(0) == s.charAt(3) &&
            s.charAt(1) == s.charAt(2) &&
            s.charAt(0) != s.charAt(1);
    }

}
