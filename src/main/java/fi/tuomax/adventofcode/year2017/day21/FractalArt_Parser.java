package fi.tuomax.adventofcode.year2017.day21;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class FractalArt_Parser
extends Parser
{

    private EnhancementRuleBook rules = new EnhancementRuleBook();

    public EnhancementRuleBook getRules() 
    {
        return rules;
    }

    public FractalArt_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        for (String line : input)
            rules.add(line);
    }

}
