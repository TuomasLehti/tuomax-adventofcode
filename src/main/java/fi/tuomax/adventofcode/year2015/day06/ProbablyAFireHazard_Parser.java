package fi.tuomax.adventofcode.year2015.day06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import fi.tuomax.adventofcode.framework.parsing.Parser;

/**
 * Parses input for Advend of Code 2015, part 6.
 */
public class ProbablyAFireHazard_Parser 
extends Parser
implements Iterable<Instruction>
{

    public ProbablyAFireHazard_Parser(List<String> input) {
        super(input);
    }

    private List<Instruction> instructions = new ArrayList<>();

    @Override
    public void parse() {
        for (String line : input)
            instructions.add(Instruction.fromInput(line));
    }

    @Override
    public Iterator<Instruction> iterator() {
        return instructions.iterator();
    }

    
}
