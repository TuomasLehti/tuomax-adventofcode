package fi.tuomax.adventofcode.year2024.day08;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class ResonantCollinearity_Parser
extends Parser
{

    private List<Antenna> antennas = new ArrayList<>();

    public List<Antenna> getAntennas() 
    {
        return antennas;
    }

    private Integer width;

    public Integer getWidth() 
    {
        return width;
    }

    private Integer height;

    public Integer getHeight() 
    {
        return height;
    }

    public ResonantCollinearity_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        width = input.get(0).length();
        height = input.size();

        Integer row = 0;
        for (String line : input) {
            Integer col = 0;
            for (Character c : line.toCharArray()) {
                if (!c.equals('.'))
                    antennas.add(new Antenna(c, Coordinates.fromInteger(col, row)));
                col++;
            }
            row++;
        }
    }

}
