package fi.tuomax.adventofcode.year2016.day22;

import java.util.List;

import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class GridComputing_Parser 
extends Parser
{

    Grid<Node> grid = new Grid<>(34, 31);

    public GridComputing_Parser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        for (String line : input) {
            try {
                Node node = new Node(line);
                grid.set(node.position().xAsInt(), node.position().yAsInt(), node);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    public Grid<Node> getGrid() 
    {
        return grid;
    }
    
}
