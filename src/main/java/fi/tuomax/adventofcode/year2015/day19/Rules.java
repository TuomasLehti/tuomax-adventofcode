package fi.tuomax.adventofcode.year2015.day19;

import java.util.HashMap;
import java.util.Map;

public class Rules 
{

    public static Map<String, Rule> rules = new HashMap<>();

    /**
     * Is there a rule available for the first element of the molecule?
     * @param molecule
     *      The molecule.
     * @return
     *      Is there a rule available?
     */
    public static Boolean ruleAvailable(String molecule)
    {
        for (String s : Rules.rules.keySet()) 
            if (molecule.startsWith(s)) 
                return true;
        return false;
    }
    
    /**
     * Get the rule for the first element of the molecule?
     * @param molecule
     *      The molecule.
     * @return
     *      The rule.
     */
    public static Rule getRule(String molecule)
    {
        for (String s : rules.keySet()) 
            if (molecule.startsWith(s)) 
                return Rules.rules.get(s);
        return null;
    }

}
