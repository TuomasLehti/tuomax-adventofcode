package fi.tuomax.adventofcode.year2016.day08;

import fi.tuomax.adventofcode.commons.Grid;

public class RotateRow 
extends Command
{

    private Integer row;

    private Integer amount;

    public RotateRow(String input)
    {
        String[] parts = input.split(" |=");
        row = Integer.valueOf(parts[3]);
        amount = Integer.valueOf(parts[5]);
    }

    @Override
    public void actOn(Grid<Boolean> grid) 
    {
        for (int a = 0; a < amount; a++) {
            Boolean temp = grid.get(grid.width() - 1, row);
            for (int i = grid.width() - 1; i > 0; i--)
                grid.set(i, row, grid.get(i - 1, row));
            grid.set(0, row, temp);
        }
    }
    
}
