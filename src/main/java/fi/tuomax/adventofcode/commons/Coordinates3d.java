package fi.tuomax.adventofcode.commons;

public record Coordinates3d (
    Long x,
    Long y, 
    Long z
) {

    public static Coordinates3d fromIntegers(Integer x, Integer y, Integer z) 
    {
        return new Coordinates3d((long) x, (long) y, (long) z);
    }
    
}
