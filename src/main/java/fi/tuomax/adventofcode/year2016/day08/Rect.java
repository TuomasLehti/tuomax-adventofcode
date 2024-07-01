package fi.tuomax.adventofcode.year2016.day08;

import fi.tuomax.adventofcode.commons.Grid;

public class Rect 
extends Command
{

    private Integer width;

    private Integer height;

    public Rect(String input)
    {
        String[] parts = input.split(" |x");
        this.width = Integer.valueOf(parts[1]);
        this.height = Integer.valueOf(parts[2]);
    }

    @Override
    public void actOn(Grid<Boolean> grid) 
    {
        for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++)
                grid.set(col, row, true);
    }
    
}
