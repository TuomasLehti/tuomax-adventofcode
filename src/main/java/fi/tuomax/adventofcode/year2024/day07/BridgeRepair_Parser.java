package fi.tuomax.adventofcode.year2024.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class BridgeRepair_Parser
extends Parser
{

    private Set<Equation> equations = new HashSet<>();

    public Set<Equation> getEquations() {
        return equations;
    }

    public BridgeRepair_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        for (String line : input) {
            
            List<String> parts = Arrays.asList(line.split(": ")[1].split(" "));
            List<Long> operands = new ArrayList<>();
            for (String part : parts)
                operands.add(Long.valueOf(part));

            equations.add(new Equation(
                Long.valueOf(line.split(": ")[0]),
                operands
            ));

        }
    }

}
