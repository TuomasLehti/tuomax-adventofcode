package fi.tuomax.adventofcode.year2022.day20;

/**
 * A number in a grove positioning system coordinates. A dedicated class is 
 * needed, because the Integer class in Java memoizes the smaller numbers and
 * the Aoc input has duplicate numbers. The pointers in the list of numbers
 * will point to the same instance of an integer, which is not what we want.
 */
public class GpsNumber 
{

    /** The number. */
    public long num;
    
    /** The original position of the number. */
    public int origIdx;
    
    /** The current position of the number. */
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
