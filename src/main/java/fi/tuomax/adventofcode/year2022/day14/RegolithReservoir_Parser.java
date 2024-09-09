package fi.tuomax.adventofcode.year2022.day14;

import java.util.List;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class RegolithReservoir_Parser
extends Parser
{

    private Cave cave = new Cave();

    public Cave getCave() 
    {
        return cave;
    }

    public RegolithReservoir_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        for (String line : input) {
            String[] parts = line.split(" -> ");
            Coordinates from = null;
            Coordinates to = fromInput(parts[0]);
            for (int i = 1; i < parts.length; i++) {
                from = to;
                to = fromInput(parts[i]);
                constructRockFormation(from, to);
            }
        }
    }

    private Coordinates fromInput(String input)
    {
        return new Coordinates(
            Long.valueOf(input.split(",")[0]),
            Long.valueOf(input.split(",")[1])
        );
    }

    private void constructRockFormation(Coordinates from, Coordinates to)
    {
        if (from.y().equals(to.y())) {
            long startCol = Math.min(from.x(), to.x());
            long endCol = Math.max(from.x(), to.x());
            for (long col = startCol; col <= endCol; col++)
                cave.addRock(new Coordinates(col, from.y()));
        } else {
            long startRow = Math.min(from.y(), to.y());
            long endRow = Math.max(from.y(), to.y());
            for (long row = startRow; row <= endRow; row++)
                cave.addRock(new Coordinates(from.x(), row));

        }
    }

}
