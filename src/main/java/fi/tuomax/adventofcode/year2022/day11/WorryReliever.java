package fi.tuomax.adventofcode.year2022.day11;

import java.util.List;

public abstract class WorryReliever 
{

    public WorryReliever(List<Monkey> barrel)
    {
    }

    public abstract Long relieve(Long item);
    
}
