package fi.tuomax.adventofcode.year2024.day05;

import java.util.List;

public class Rule 
{

    private Integer before;

    private Integer after;

    public Rule(String aocInput)
    {
        before = Integer.valueOf(aocInput.split("\\|")[0]);
        after = Integer.valueOf(aocInput.split("\\|")[1]);
    }

    public Boolean inRightOrder(List<Integer> update)
    {
        Integer beforeIdx = update.indexOf(before);
        Integer afterIdx = update.indexOf(after);
        return beforeIdx > -1 && afterIdx > -1 && afterIdx > beforeIdx;
    }

    public boolean applies(List<Integer> update)
    {
        Integer beforeIdx = update.indexOf(before);
        Integer afterIdx = update.indexOf(after);
        return beforeIdx > -1 && afterIdx > -1;
    }
    
}
