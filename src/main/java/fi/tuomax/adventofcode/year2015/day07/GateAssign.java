package fi.tuomax.adventofcode.year2015.day07;

import java.util.HashMap;

public class GateAssign 
extends GateWithTwoInputs
{

    public GateAssign(String input) {
        super(input);
    }

    @Override
    protected Integer calculateSignal(HashMap<String, Gate> gates) 
    {
        return getFirstInputSignal(gates);
    }
    
}
