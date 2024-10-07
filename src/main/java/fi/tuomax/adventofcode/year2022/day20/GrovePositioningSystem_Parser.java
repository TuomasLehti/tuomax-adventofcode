package fi.tuomax.adventofcode.year2022.day20;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class GrovePositioningSystem_Parser
extends Parser
{

    private GpsMixer nums = new GpsMixer();

    private GpsSequence seq = new GpsSequence();

    public GpsSequence getSeq() {
        return seq;
    }

    public GpsMixer getNums() 
    {
        return nums;
    }

    public GrovePositioningSystem_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        for (String line : input) {
            nums.addInteger(Integer.valueOf(line));
            seq.add(Integer.valueOf(line));
        }
    }

}
