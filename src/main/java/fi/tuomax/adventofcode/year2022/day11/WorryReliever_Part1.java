package fi.tuomax.adventofcode.year2022.day11;

import java.util.List;

public class WorryReliever_Part1 
extends WorryReliever
{

    public WorryReliever_Part1(List<Monkey> barrel) 
    {
        super(barrel);
    }

    @Override
    public Long relieve(Long item) 
    {
        return item / 3;
    }
    
}
