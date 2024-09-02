package fi.tuomax.adventofcode.year2022.day07;

import java.util.Iterator;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class NoSpaceLeftOnDevice_Parser 
extends Parser
{

    public NoSpaceLeftOnDevice_Parser(List<String> input) 
    {
        super(input);
    }

    private Directory directoryTree;

    public Directory getDirectoryTree() 
    {
        return directoryTree;
    }

    @Override
    public void parse() 
    {
        Iterator<String> inputIterator = input.iterator();
        inputIterator.next(); // get rid of cd /
        inputIterator.next(); // get rid of first ls
        directoryTree = new Directory(inputIterator);
    }
    
}
