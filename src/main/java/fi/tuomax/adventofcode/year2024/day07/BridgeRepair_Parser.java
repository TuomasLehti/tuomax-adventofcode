package fi.tuomax.adventofcode.year2024.day07;

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
        for (String line : input)
            equations.add(new Equation(
                Long.valueOf(line.split(": ")[0]),
                line.split(": ")[1]
            ));
    }

}
