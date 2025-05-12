package fi.tuomax.adventofcode.year2017.day08;

import java.util.HashMap;
import java.util.Map;

public class RegisterArray 
{

    private Map<String, Register> registers = new HashMap<>();

    public Register getRegister(String name)
    {
        if (!registers.keySet().contains(name)) {
            registers.put(name, new Register());
        }
        return registers.get(name);
    }

    public Integer getHighestValue()
    {
        Integer value = Integer.MIN_VALUE;
        for (String name : registers.keySet()) 
            value = Math.max(value, getRegister(name).getValue());
        return value;
    }

    public Integer getHighestValueEver()
    {
        Integer value = Integer.MIN_VALUE;
        for (String name : registers.keySet()) 
            value = Math.max(value, getRegister(name).getHighestValue());
        return value;
    }
    
}
