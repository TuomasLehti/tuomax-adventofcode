package fi.tuomax.adventofcode.year2024.day05;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;

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

    public void rearrange(List<RuleOrder> order) 
    {
        LoggerFactory.getLogger(getClass()).debug("Rearranging " + toString() + "...");
        List<RuleOrder> localOrder = RuleOrder.getRuleOrder(applicableRules);

        List<Integer> newNums = new ArrayList<>();
        for (RuleOrder ruleorder : localOrder)
            if (pageNumbers.contains(ruleorder.pageNumber()))
                newNums.add(ruleorder.pageNumber());
        pageNumbers = newNums;
        LoggerFactory.getLogger(getClass()).debug("=> " + toString() + "...");
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (Integer pageNumber : pageNumbers) {
            if (sb.length() > 0) sb.append(",");
            sb.append(pageNumber);
        }
        return sb.toString();
    }
    
}
