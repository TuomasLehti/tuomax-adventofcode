package fi.tuomax.adventofcode.year2015.day07;

import java.util.HashMap;

public class GateAnd
extends GateWithTwoInputs
{

    public GateAnd(String input) {
        super(input);
    }

    @Override
    protected Integer calculateSignal(HashMap<String, Gate> gates) 
    {
        return getFirstInputSignal(gates) & getSecondInputSignal(gates);
    }

}
