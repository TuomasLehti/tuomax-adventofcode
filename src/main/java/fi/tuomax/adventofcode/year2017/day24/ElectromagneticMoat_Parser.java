package fi.tuomax.adventofcode.year2017.day24;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class ElectromagneticMoat_Parser
extends Parser
{

    private Set<Component> components = new HashSet<>();

    public Set<Component> getComponents()
    {
        return components;
    }

    public ElectromagneticMoat_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        for (String line : input) {
            components.add(Component.fromAocInput(line));
        }
    }

}
