package fi.tuomax.adventofcode.year2016.day08;

import java.util.List;

import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.parsing.ParseableParser;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class TwoFactorAuthentication_Part1 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 8, 1, 
            "Two-Factor Authentication", ""  
        );
    }

    ParseableParser<Command> parseableParser;

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        /* Must be constructed here, because the input is available only here. */
        parseableParser = new ParseableParser<Command>(input) {
            @Override
            public Command fromInput(String line) 
            {
                return Command.fromInput(line);
            }
        };
        return parseableParser;
    }

    protected Grid<Boolean> grid;

    @Override
    protected void solve() 
    {
        grid = new Grid<>(50, 6);
        for (int row = 0; row < grid.height(); row++)
            for (int col = 0; col < grid.width(); col++)
                grid.set(col, row, false);
        for (Command command : parseableParser)
            command.actOn(grid);
        Integer result = 0;
        for (int row = 0; row < grid.height(); row++)
            for (int col = 0; col < grid.width(); col++)
                if (grid.get(col, row))
                    result++;
        setAnswer(result);
    }
    
}
