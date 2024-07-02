package fi.tuomax.adventofcode.year2016.day08;

import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.parsing.Parseable;

public abstract class Command 
extends Parseable
{

    public Command(String aocInput) 
    {
        super(aocInput);
    }

    public static Command fromInput(String input)
    {
        if (input.startsWith("rect"))
            return new Rect(input);
        else if (input.contains("row"))
            return new RotateRow(input);
        else if (input.contains("column"))
            return new RotateCol(input);
        else
            throw new IllegalStateException("Unknown command: " + input);
    }

    public abstract void actOn(Grid<Boolean> grid);
    
}
