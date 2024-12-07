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

    public Set<Long> possibleAnswersForEquation(List<Long> operands)
    {
/*         StringBuilder sb = new StringBuilder();
        sb.append("  ".repeat(EquationSolver.depth));
        for (Long o : operands) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(o);
        }
        System.out.println(sb.toString()); */
        Set<Long> result = new HashSet<>();

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
            operands.add(0, left * right);
            result.addAll(possibleAnswersForEquation(operands));

            operands.remove(0);
            operands.add(0, left + right);
            result.addAll(possibleAnswersForEquation(operands));

            operands.remove(0);
            operands.add(0, right);
            operands.add(0, left);
        }
        
        return result;
    }

    public Boolean solvesEquationPart2(Long target, List<Long> operands)
    {
        Long left = Long.valueOf(operands.get(0));
        Long right = Long.valueOf(operands.get(1));
        if (operands.size() == 2) {
            return target.equals(left + right) ||
                target.equals(left * right) ||
                target.equals(Long.valueOf(left.toString() + right.toString()));
        } else {
            operands.remove(0);
            
            operands.remove(0);
            operands.add(0, left * right);
            if (solvesEquationPart2(target, operands)) return true;

            operands.remove(0);
            operands.add(0, left + right);
            if (solvesEquationPart2(target, operands)) return true;

            operands.remove(0);
            operands.add(0, Long.valueOf(String.format("%d%d", left, right)));
            if (solvesEquationPart2(target, operands)) return true;

            operands.remove(0);
            operands.add(0, right);
            operands.add(0, left);
        }
        return false;
    }

    public Set<Long> possibleAnswersForEquationPart2(List<Long> operands)
    {
        Set<Long> result = new HashSet<>();

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
            operands.add(0, left * right);
            result.addAll(possibleAnswersForEquationPart2(operands));

            operands.remove(0);
            operands.add(0, left + right);
            result.addAll(possibleAnswersForEquationPart2(operands));

            operands.remove(0);
            operands.add(0, Long.valueOf(String.format("%d%d", left, right)));
            result.addAll(possibleAnswersForEquationPart2(operands));

            operands.remove(0);
            operands.add(0, right);
            operands.add(0, left);
        }
        
        return result;
    }

}
