package fi.tuomax.adventofcode.year2024.day05;

import java.util.ArrayList;
import java.util.List;

public class Update 
{

    private List<Integer> pageNumbers = new ArrayList<>();

    public Integer getMiddlePageNumber()
    {
        return pageNumbers.get(pageNumbers.size() / 2);
    }

    private List<Rule> applicableRules = new ArrayList<>();

    public Update(String aocInput, List<Rule> rules)
    {
        setPageNumbers(aocInput);
        setApplicableRules(rules);
    }

    private void setPageNumbers(String aocInput)
    {
        for (String value : aocInput.split(","))
            pageNumbers.add(Integer.valueOf(value));
    }

    private void setApplicableRules(List<Rule> allRules)
    {
        for (Rule rule : allRules)
            if (rule.applies(pageNumbers))
                applicableRules.add(rule);
    }

    public Boolean isInRightOrder()
    {
        for (Rule rule : applicableRules)
            if (!rule.inRightOrder(pageNumbers))
                return false;
        return true;
    }
    
}
