package fi.tuomax.adventofcode.year2017.day08;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class IHeardYouLikeRegisters_Parser
extends Parser
{

    private List<Instruction> instructions = new ArrayList<>();

    public List<Instruction> getInstructions() 
    {
        return instructions;
    }

    public IHeardYouLikeRegisters_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        for (String line : input) {
            instructions.add(new Instruction(line));
        }
    }

}
