package fi.tuomax.adventofcode.year2022.day15;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class BeaconExclusionZone_Parser
extends Parser
{

    private List<Sensor> sensors = new ArrayList<>();

    public List<Sensor> getSensors() 
    {
        return sensors;
    }

    public BeaconExclusionZone_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        for (String line : input) {
            sensors.add(new Sensor(line));
        }
    }

}
