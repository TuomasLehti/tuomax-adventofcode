package fi.tuomax.adventofcode.year2022.day20;

public class GpsNumber 
{

    public long num;
    
    public int origIdx;
    
    public int currIdx;

    @Override
    public boolean equals(Object o)
    {
        if (o == null || !(o instanceof GpsNumber)) return false;
        if (o == this) return true;
        GpsNumber other = (GpsNumber) o;
        return (num == other.num && origIdx == other.origIdx);
    }
    
}
