package fi.tuomax.adventofcode.year2017.day21;

import java.util.HashSet;
import java.util.Set;

import fi.tuomax.adventofcode.commons.SparseBooleanGrid;
import fi.tuomax.adventofcode.commons.Direction.TurnDirection;

public class EnhancementRule 
{

    private SparseBooleanGrid inputPattern;

    public SparseBooleanGrid getInputPattern() 
    {
        return inputPattern;
    }

    private SparseBooleanGrid outputPattern;

    public SparseBooleanGrid getOutputPattern() 
    {
        return outputPattern;
    }

    public EnhancementRule(String aocInput)
    {
        String[] parts = aocInput.split(" => ");
        inputPattern = new SparseBooleanGrid(parts[0], "/", '#');
        outputPattern = new SparseBooleanGrid(parts[1], "/", '#');
    }

    private EnhancementRule(SparseBooleanGrid inputPattern, SparseBooleanGrid outputPattern)
    {
        this.inputPattern = inputPattern;
        this.outputPattern = outputPattern;
    }

    public static Set<EnhancementRule> transformedRules(String aocInput)
    {
        EnhancementRule rule = new EnhancementRule(aocInput);

        SparseBooleanGrid inputPattern = rule.getInputPattern();
        inputPattern = (SparseBooleanGrid) inputPattern.copy();

        Set<EnhancementRule> rules = new HashSet<>();
        
        rules.add(new EnhancementRule(inputPattern, rule.getOutputPattern()));
//        System.out.println(inputPattern.toString() + " => " + rule.getOutputPattern().toString());

        inputPattern = (SparseBooleanGrid) inputPattern.copy();
        inputPattern.rotate(TurnDirection.RIGHT);
        rules.add(new EnhancementRule(inputPattern, rule.getOutputPattern()));
//        System.out.println(inputPattern.toString() + " => " + rule.getOutputPattern().toString());

        inputPattern = (SparseBooleanGrid) inputPattern.copy();
        inputPattern.rotate(TurnDirection.RIGHT);
        rules.add(new EnhancementRule(inputPattern, rule.getOutputPattern()));
//        System.out.println(inputPattern.toString() + " => " + rule.getOutputPattern().toString());

        inputPattern = (SparseBooleanGrid) inputPattern.copy();
        inputPattern.rotate(TurnDirection.RIGHT);
        rules.add(new EnhancementRule(inputPattern, rule.getOutputPattern()));
//        System.out.println(inputPattern.toString() + " => " + rule.getOutputPattern().toString());

        inputPattern = (SparseBooleanGrid) inputPattern.copy();
        inputPattern.rotate(TurnDirection.RIGHT);
        inputPattern.reflectHorizontally();
        rules.add(new EnhancementRule(inputPattern, rule.getOutputPattern()));
//        System.out.println(inputPattern.toString() + " => " + rule.getOutputPattern().toString());

        inputPattern = (SparseBooleanGrid) inputPattern.copy();
        inputPattern.rotate(TurnDirection.RIGHT);
        rules.add(new EnhancementRule(inputPattern, rule.getOutputPattern()));
//        System.out.println(inputPattern.toString() + " => " + rule.getOutputPattern().toString());

        inputPattern = (SparseBooleanGrid) inputPattern.copy();
        inputPattern.rotate(TurnDirection.RIGHT);
        rules.add(new EnhancementRule(inputPattern, rule.getOutputPattern()));
//        System.out.println(inputPattern.toString() + " => " + rule.getOutputPattern().toString());

        inputPattern = (SparseBooleanGrid) inputPattern.copy();
        inputPattern.rotate(TurnDirection.RIGHT);
        rules.add(new EnhancementRule(inputPattern, rule.getOutputPattern()));
//        System.out.println(inputPattern.toString() + " => " + rule.getOutputPattern().toString());

        inputPattern = (SparseBooleanGrid) inputPattern.copy();
        inputPattern.rotate(TurnDirection.RIGHT);
        inputPattern.reflectVertically();
        rules.add(new EnhancementRule(inputPattern, rule.getOutputPattern()));
//        System.out.println(inputPattern.toString() + " => " + rule.getOutputPattern().toString());

        inputPattern = (SparseBooleanGrid) inputPattern.copy();
        inputPattern.rotate(TurnDirection.RIGHT);
        rules.add(new EnhancementRule(inputPattern, rule.getOutputPattern()));
//        System.out.println(inputPattern.toString() + " => " + rule.getOutputPattern().toString());

        inputPattern = (SparseBooleanGrid) inputPattern.copy();
        inputPattern.rotate(TurnDirection.RIGHT);
        rules.add(new EnhancementRule(inputPattern, rule.getOutputPattern()));
//        System.out.println(inputPattern.toString() + " => " + rule.getOutputPattern().toString());

        inputPattern = (SparseBooleanGrid) inputPattern.copy();
        inputPattern.rotate(TurnDirection.RIGHT);
        rules.add(new EnhancementRule(inputPattern, rule.getOutputPattern()));
//        System.out.println(inputPattern.toString() + " => " + rule.getOutputPattern().toString());
        
        return rules;
    }

    @Override
    public String toString()
    {
        return String.format(
            "%s => %s",
            inputPattern.toString(),
            outputPattern.toString()
        );
    }
    
}
