package fi.tuomax.adventofcode.year2015.day18;

import java.util.List;

import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class LikeAGifForYourYard_Parser
extends Parser
{

    private Grid<Boolean> grid = null;

    public Grid<Boolean> getGrid() 
    {
        return grid;
    }

    public LikeAGifForYourYard_Parser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        // assume a square grid
        Integer size = input.get(0).length();
        grid = new Grid<>(size, size);
        for (int row = 0; row < size; row++)
            for (int col = 0; col < size; col++)
                grid.set(col, row, input.get(row).charAt(col) == '#');
    }
    
}
