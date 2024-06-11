package fi.tuomax.adventofcode.year2015.day07;

import java.util.HashMap;

/**
 * Not is the only gate with only one input.
 */
public class GateNot 
extends Gate
{

    public GateNot(String input) 
    {
        String[] inputParts = input.split(" ");
        setFirstInput(inputParts[1]);
    }

    @Override
    protected Integer calculateSignal(HashMap<String, Gate> gates) 
    {
        return ~getFirstInputSignal(gates);
    }
    
}
