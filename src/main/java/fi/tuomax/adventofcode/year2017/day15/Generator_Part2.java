package fi.tuomax.adventofcode.year2017.day15;

public class Generator_Part2 
extends Generator
{

    private Long resultFactor;

    public Generator_Part2(Long start, Long factor, Long resultFactor) {
        super(start, factor);
        this.resultFactor = resultFactor;
    }
    
    public Long calculate()
    {
        do {
            super.calculate();
        } while (getCurrent() % resultFactor != 0);
        return getCurrent();
    }

}
