package fi.tuomax.adventofcode.year2017.day13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class PacketScanners_Parser
extends Parser
{

    Map<Integer, Layer> layers = new HashMap<>();

    public Map<Integer, Layer> getLayers() 
    {
        return layers;
    }

    public PacketScanners_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        for (String line : input) {
            Layer layer = new Layer(line);
            layers.put(layer.getDepth(), layer);
        }
    }

}
