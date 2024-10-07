package fi.tuomax.adventofcode.year2022.day20;

import java.util.List;

public class GrovePositioningSystem_Parser_Part2
extends GrovePositioningSystem_Parser
{

    private long decryptionKey;

    public GrovePositioningSystem_Parser_Part2(List<String> input, long decryptionKey)
    {
        super(input);
        this.decryptionKey = decryptionKey;
    }

    @Override
    protected long aocInputToLong(String line) 
    {
        return Long.valueOf(line) * decryptionKey;
    }

}
