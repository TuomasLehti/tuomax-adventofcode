package fi.tuomax.adventofcode.year2016.day08;

import fi.tuomax.adventofcode.commons.Grid;

public class RotateCol 
extends Command
{

    private Integer col;

    private Integer amount;

    public RotateCol(String input)
    {
        String[] parts = input.split(" |=");
        col = Integer.valueOf(parts[3]);
        amount = Integer.valueOf(parts[5]);
    }

    @Override
    public void actOn(Grid<Boolean> grid) 
    {
        for (int a = 0; a < amount; a++) {
            Boolean temp = grid.get(col, grid.height() - 1);
            for (int i = grid.height() - 1; i > 0; i--)
                grid.set(col, i, grid.get(col, i - 1));
            grid.set(col, 0, temp);
        }
    }
    
}
