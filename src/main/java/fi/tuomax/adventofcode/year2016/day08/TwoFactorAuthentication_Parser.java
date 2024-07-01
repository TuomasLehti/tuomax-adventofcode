package fi.tuomax.adventofcode.year2016.day08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class TwoFactorAuthentication_Parser 
extends Parser
implements Iterable<Command>
{

    public TwoFactorAuthentication_Parser(List<String> input)
    {
        super(input);
    }

    private List<Command> commands = new ArrayList<>();

    @Override
    public void parse() 
    {
        for (String line : input)
            commands.add(Command.fromInput(line));
    }

    @Override
    public Iterator<Command> iterator() 
    {
        return commands.iterator();
    }
    
}
