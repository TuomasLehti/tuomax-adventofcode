package fi.tuomax.adventofcode.year2022.day21;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class MonkeyMath_Parser
extends Parser
{

    public MonkeyMath_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        Monkey.barrel.clear();
        for (String line : input) {
            Monkey.addToBarrelFromInput(line);
        }
    }

}
