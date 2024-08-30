package fi.tuomax.adventofcode.year2022.day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

/**
 * Reads the calorie counts from the input and gathers them per elf. The list
 * of each elf's calories is sorted at the end so that the largest amount is
 * in the end.
 */
public class CalorieCounting_Parser 
extends Parser
{

    public CalorieCounting_Parser(List<String> input) 
    {
        super(input);
    }

    private List<Integer> caloriesOfElves = new ArrayList<>();

    public List<Integer> getCaloriesOfElves() 
    {
        return caloriesOfElves;
    }

    @Override
    public void parse() 
    {
        Integer current = 0;
        for (String line : input) {
            if (line.isEmpty()) {
                caloriesOfElves.add(current);
                current = 0;
            } else {
                current += Integer.valueOf(line);
            }
        } 
        caloriesOfElves.add(current);
        Collections.sort(caloriesOfElves);
    }
    
}
