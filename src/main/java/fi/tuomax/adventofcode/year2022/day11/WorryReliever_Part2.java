package fi.tuomax.adventofcode.year2022.day11;

import java.util.List;

public class WorryReliever_Part2 
extends WorryReliever
{

    private Long lowestCommonDivisor = 1L;

    public WorryReliever_Part2(List<Monkey> barrel) {
        super(barrel);
        for (Monkey monkey : barrel)
            lowestCommonDivisor *= monkey.getDivisibilityTest();
    }

    @Override
    public Long relieve(Long item) 
    {
        item = item % lowestCommonDivisor;
        return item;
    }
    
}
