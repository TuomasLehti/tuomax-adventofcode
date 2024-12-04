package fi.tuomax.adventofcode.year2024.day04;

import java.util.List;

import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class CeresSearch_Parser
extends Parser
{

    private Grid<Character> cells;

    public Grid<Character> getCells() {
        return cells;
    }

    public CeresSearch_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        cells = new Grid<>(input.get(0).length(), input.size());
        Integer row = 0;
        for (String line : input) {
            Integer col = 0;
            for (Character c : line.toCharArray()) {
                cells.set(col, row, c);
                col++;
            }
            row++;
        }
    }

}
