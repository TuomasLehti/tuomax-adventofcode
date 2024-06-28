package fi.tuomax.adventofcode.year2016.day04;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.ParseableParser;

public class RoomParser 
extends ParseableParser<Room>
{

    public RoomParser(List<String> input) 
    {
        super(input);
    }

    @Override
    public Room fromInput(String line) 
    {
        return new Room(line);
    }
    
}
