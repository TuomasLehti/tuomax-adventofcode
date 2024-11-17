package fi.tuomax.adventofcode.commons;

import fi.tuomax.adventofcode.commons.Direction.TurnDirection;

/**
 * TODO: docs
 */
public record Coordinates(Long x, Long y) 
implements Comparable<Coordinates>
{

    public static final Coordinates ORIGIN = new Coordinates(0l, 0l);

    public static Coordinates fromInteger(Integer x, Integer y)
    {
        return new Coordinates((long) x, (long) y);
    }

    public Coordinates translate(Coordinates amount) 
    {
        return new Coordinates(this.x + amount.x, this.y + amount.y);
    }

    /** Supports only 90 degree rotations because of integer coordinate system. */
    public Coordinates rotate90Degrees(TurnDirection direction)
    {

        /* Matrix multiplication time!!!
         * 
         * [ a b ] [ x ]  = [ ax + by ]
         * [ c d ] [ y ]    [ cx + dy ]
         * 
         * counter-clockwise
         * 
         * [ 0 -1 ] [ 5 ] = [ 0*5 - 1*2 ] = [ 0 - 2 ] = [ -2 ]
         * [ 1  0 ] [ 2 ]   [ 1*5 + 0*2 ]   [ 5 + 0 ]   [  5 ]
         * 
         * x' = -y
         * y' = x
         * 
         * clockwise
         * 
         * [  0  1 ] [ x ]
         * [ -1  0 ] [ y ]
         * 
         * x' = 0x + 1y
         * y' = -1x + 0y
         * 
         */
        return direction == TurnDirection.LEFT ? 
            new Coordinates(this.y * -1, this.x) :
            new Coordinates(this.y, this.x * -1);
        
    }

    public Integer xAsInt() 
    throws ArithmeticException
    {
        if (x <= Integer.MAX_VALUE || x >= Integer.MIN_VALUE)
            return Integer.valueOf(x.toString());
        else
            throw new ArithmeticException(
                toString() + "X-coordinate will not fit in a 32-bit integer.");
    }

    public Integer yAsInt() 
    throws ArithmeticException
    {
        if (y <= Integer.MAX_VALUE || y >= Integer.MIN_VALUE)
            return Integer.valueOf(y.toString());
        else
            throw new ArithmeticException(
                toString() + "Y-coordinate will not fit in a 32-bit integer.");
    }

    @Override
    public int compareTo(Coordinates o) 
    {
        return this.y == o.y ? this.x.compareTo(o.x) : this.y.compareTo(o.y);
    }

    public Long taxiCabDistance()
    {
        return Math.abs(this.x) + Math.abs(this.y);
    }

    public Long taxicabDistance(Coordinates to)
    {
        return Math.abs(to.x() - this.x()) + Math.abs(to.y() - this.y());
    }

}
