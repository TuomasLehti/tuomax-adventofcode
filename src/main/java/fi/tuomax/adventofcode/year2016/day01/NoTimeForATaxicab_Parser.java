package fi.tuomax.adventofcode.year2016.day01;

import java.util.Arrays;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.ParseableParser;

public class NoTimeForATaxicab_Parser 
extends ParseableParser<Instruction>
{

    public NoTimeForATaxicab_Parser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse()
    {
        input = Arrays.asList(input.get(0).split(", "));
        super.parse();
    }


    @Override
    public Instruction fromInput(String line) 
    {
        return new Instruction(line);
    }
    
}
