package fi.tuomax.adventofcode.year2017.day25;

import java.util.HashSet;
import java.util.Set;

import fi.tuomax.adventofcode.commons.Direction.TurnDirection;

public class TuringMachine 
{

    private Set<Integer> ones = new HashSet<>();

    private Integer pos = 0;

    private String state = "A";

    public TuringMachine(String startState)
    {
        this.state = startState;
    }

    public TuringState getTuringState()
    {
        return new TuringState(state, ones.contains(pos));
    }

    public void process(TuringInst inst)
    {
        if (inst.valueToWrite()) 
            ones.add(pos);
        else
            ones.remove(pos);
        
        if (inst.dir() == TurnDirection.LEFT)
            pos--;
        else
            pos++;

        state = inst.nextState();
    }

    public Integer numOfOnes()
    {
        return ones.size();
    }
    
}
