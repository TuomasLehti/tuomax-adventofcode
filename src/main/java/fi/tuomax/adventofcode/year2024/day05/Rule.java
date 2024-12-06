package fi.tuomax.adventofcode.year2024.day05;

import java.util.ArrayList;
import java.util.List;

public class Rule 
implements Comparable<Rule>
{

    private Integer before;

    public Integer getBefore() {
        return before;
    }

    private Integer after;

    public Integer getAfter() {
        return after;
    }

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

    public void swap(List<Integer> update)
    {
        Integer beforeIdx = update.indexOf(before);
        Integer afterIdx = update.indexOf(after);

        Integer temp = update.get(beforeIdx);
        update.set(beforeIdx, update.get(afterIdx));
        update.set(afterIdx, temp);
    }

    public static List<Rule> rules = new ArrayList<>();
    
    @Override
    public int compareTo(Rule other) 
    {
        return this.before.compareTo(other.before);
    }

    
}
