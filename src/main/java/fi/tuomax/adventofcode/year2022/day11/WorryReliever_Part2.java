package fi.tuomax.adventofcode.year2022.day11;

public class WorryReliever_Part2 
extends WorryReliever
{

    @Override
    public Long relieve(Long item) 
    {
        item = item % (2 * 3 * 5 * 7 * 11 * 13 * 17 * 19);
        return item;
    }
    
}
