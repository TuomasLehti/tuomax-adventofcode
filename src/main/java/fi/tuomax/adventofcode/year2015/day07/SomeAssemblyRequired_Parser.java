package fi.tuomax.adventofcode.year2015.day07;

import java.util.HashMap;
import java.util.List;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class SomeAssemblyRequired_Parser 
extends Parser
{

    public SomeAssemblyRequired_Parser(List<String> input) {
        super(input);
    }

    private HashMap<String, Gate> gates = new HashMap<>();

    public HashMap<String, Gate> getGates() {
        return gates;
    }

    private void addGate(String name, Gate gate)
    {
        gates.put(name, gate);
    }

    @Override
    public void parse() {
        for (String line : input)
            parseLine(line);
    }

    private void parseLine(String token) 
    {
        String name = token.split(" -> ")[1];
        if (token.contains("AND")) addGate(name, new GateAnd(token));
        else if (token.contains("OR")) addGate(name, new GateOr(token));
        else if (token.contains("LSHIFT")) addGate(name, new GateLShift(token));
        else if (token.contains("RSHIFT")) addGate(name, new GateRShift(token));
        else if (token.contains("NOT")) addGate(name, new GateNot(token));
        else addGate(name, new GateAssign(token));
    }
    
}
