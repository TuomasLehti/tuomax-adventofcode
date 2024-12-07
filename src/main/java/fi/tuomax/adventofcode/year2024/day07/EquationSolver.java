package fi.tuomax.adventofcode.year2024.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
 * Solves equations from Advent of Code 2024, day 7. This functionalitity is 
 * extracted to this separate class, because a separate class can be tested
 * independently.
 */ 
public class EquationSolver 
{

    public Set<Long> possibleAnswersForEquation(String equation)
    {
        Set<Long> result = new HashSet<>();
        List<String> operands = new ArrayList<>(Arrays.asList(equation.split(" ")));

        if (operands.size() == 2) {
            Long left = Long.valueOf(operands.get(0));
            Long right = Long.valueOf(operands.get(1));
            result.add(left * right);
            result.add(left + right);
        } else {
            Long left = Long.valueOf(operands.get(0));
            Long right = Long.valueOf(operands.get(1));
            operands.remove(0);
            
            operands.remove(0);
            operands.add(0, String.format("%d", left * right));
            result.addAll(possibleAnswersForEquation(String.join(" ", operands)));

            operands.remove(0);
            operands.add(0, String.format("%d", left + right));
            result.addAll(possibleAnswersForEquation(String.join(" ", operands)));
        }
        
        return result;
    }

    public Set<Long> possibleAnswersForEquationPart2(String equation)
    {
        Set<Long> result = new HashSet<>();
        List<String> operands = new ArrayList<>(Arrays.asList(equation.split(" ")));

        if (operands.size() == 2) {
            Long left = Long.valueOf(operands.get(0));
            Long right = Long.valueOf(operands.get(1));
            result.add(left * right);
            result.add(left + right);
            result.add(Long.valueOf(left.toString() + right.toString()));
        } else {
            Long left = Long.valueOf(operands.get(0));
            Long right = Long.valueOf(operands.get(1));
            operands.remove(0);
            
            operands.remove(0);
            operands.add(0, String.format("%d", left * right));
            result.addAll(possibleAnswersForEquationPart2(String.join(" ", operands)));

            operands.remove(0);
            operands.add(0, String.format("%d", left + right));
            result.addAll(possibleAnswersForEquationPart2(String.join(" ", operands)));

            operands.remove(0);
            operands.add(0, String.format("%d%d", left, right));
            result.addAll(possibleAnswersForEquationPart2(String.join(" ", operands)));
        }
        
        return result;
    }

}
