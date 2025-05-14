package fi.tuomax.adventofcode.year2017.day13;

import java.util.ArrayList;
import java.util.List;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class PacketScanners_Parser
extends Parser
{


    List<Layer> layers = new ArrayList<>();

    public List<Layer> getLayers() 
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
            layers.add(layer);
        }
    }

}
