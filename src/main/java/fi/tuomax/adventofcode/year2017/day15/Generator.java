package fi.tuomax.adventofcode.year2017.day15;

public class Generator 
{

    private Long current;

    public Long getCurrent() 
    {
        return current;
    }

    private Long factor;

    public Generator(Long start, Long factor)
    {
        this.current = start;
        this.factor = factor;
    }

    public Long calculate()
    {
        current = (current * factor) % 2147483647;
        return current;
    }
    
}
