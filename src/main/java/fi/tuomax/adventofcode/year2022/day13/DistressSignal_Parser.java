package fi.tuomax.adventofcode.year2022.day13;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class DistressSignal_Parser
extends Parser
{

    private List<JSONArray> packets = new ArrayList<>();

    public List<JSONArray> getPackets() 
    {
        return packets;
    }

    public DistressSignal_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        for (String line : input)
            if (!line.isEmpty())
                packets.add(new JSONArray(line));
    }

}
