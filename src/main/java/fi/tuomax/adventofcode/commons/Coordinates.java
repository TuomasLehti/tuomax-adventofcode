package fi.tuomax.adventofcode.commons;

public record Coordinates(Long x, Long y) 
implements Comparable<Coordinates>
{

    public static final Coordinates ORIGIN = new Coordinates(0l, 0l);

    public Coordinates translate(Coordinates amount) 
    {
        return new Coordinates(this.x + amount.x, this.y + amount.y);
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
