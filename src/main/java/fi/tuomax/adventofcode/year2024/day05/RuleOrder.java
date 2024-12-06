package fi.tuomax.adventofcode.year2024.day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record RuleOrder (
    Integer pageNumber,
    Integer lesserNumberAmount,
    Integer greaterNumberAmount
) {

    public static List<RuleOrder> getRuleOrder(List<Rule> allRules)
    {
        Set<Integer> pageNumsInRules = new HashSet<>();
        for (Rule rule : allRules) {
            pageNumsInRules.add(rule.getBefore());
            pageNumsInRules.add(rule.getAfter());
        }

        List<RuleOrder> order = new ArrayList<>();
        for (Integer pageNum : pageNumsInRules) {
            Integer lesserAmount = 0;
            Integer greaterAmount = 0;
            for (Rule rule : allRules) {
                if (rule.getBefore().equals(pageNum)) {
                    greaterAmount++;
                } else if (rule.getAfter().equals(pageNum)) {
                    lesserAmount++;
                }
            }
            order.add(new RuleOrder(pageNum, lesserAmount, greaterAmount));
        }

        Collections.sort(order, new Comparator<RuleOrder>(){
            @Override
            public int compare(RuleOrder o1, RuleOrder o2) {
                return o1.lesserNumberAmount.compareTo(o2.lesserNumberAmount);
            }
        });

        return order;
        
    }

}