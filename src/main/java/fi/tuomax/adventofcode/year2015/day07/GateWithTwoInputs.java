package fi.tuomax.adventofcode.year2015.day07;

import java.util.HashMap;

/**
 * A middle level class for parsing a gate with two inputs.
 */
public abstract class GateWithTwoInputs 
extends Gate
{

    public GateWithTwoInputs(String input)
    {
        String[] inputParts = input.split(" ");
        setFirstInput(inputParts[0]);
        setSecondInput(inputParts[2]);
    }

    @Override
    protected abstract Integer calculateSignal(HashMap<String, Gate> gates);
    
}
