package fi.tuomax.adventofcode.year2022.day08;

import java.util.List;

import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class TreetopTreeHouse_Parser
extends Parser
{

    private Grid<Tree> trees;

    public Grid<Tree> getTrees() 
    {
        return trees;
    }

    public TreetopTreeHouse_Parser(List<String> input)
    {
        super(input);
        Integer width = input.get(0).length();
        Integer height = input.size();
        trees = new Grid<>(width, height);
    }

    @Override
    public void parse()
    {
        int row = 0;
        int column = 0;
        for (String line : input) {
            for (Character character : line.toCharArray()) {
                trees.set(column, row, new Tree(Integer.valueOf(character.toString())));
                column++;
            }
            row++;
            column = 0;
        }
    }

}
