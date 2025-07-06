package fi.tuomax.adventofcode.year2017.day21;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EnhancementRuleBook 
{

    private Map<SparseBooleanGrid, EnhancementRule> rules = new HashMap<>();

    /**
     * @param rule
     */
    public void add(String rule)
    {
        Set<EnhancementRule> transformations = EnhancementRule.transformedRules(rule);
        for (EnhancementRule transformation : transformations) {
/*             if (transformation.getInputPattern().width().equals(2L))
                System.out.println(transformation.getInputPattern().toString() + " => " + transformation.getOutputPattern().toString());
 */            rules.put(transformation.getInputPattern(), transformation);
        }
    }

    public EnhancementRule get(SparseBooleanGrid original)
    {
        return rules.get(original);
    }
    
}
