package fi.tuomax.adventofcode.year2016.day07;

public abstract class IpSupportChecker 
{

    protected String[] parts;

    public Boolean checkSupport(String s)
    {
        parts = s.split("\\[|\\]");
        return check();
    }

    protected abstract Boolean check();

    
}
