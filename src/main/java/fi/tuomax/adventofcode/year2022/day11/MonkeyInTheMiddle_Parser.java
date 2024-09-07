package fi.tuomax.adventofcode.year2022.day11;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class MonkeyInTheMiddle_Parser
extends Parser
{

    /** It's called a barrel of monkeys after all. */
    private List<Monkey> barrel = new ArrayList<>();

    public List<Monkey> getBarrel() {
        return barrel;
    }

    public MonkeyInTheMiddle_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        Integer lineIdx = 0;
        List<String> inp = new ArrayList<>(input);

        while (lineIdx < input.size()) {
            List<String> inputForMonkey = inp.subList(lineIdx, lineIdx + 6);
            barrel.add(new Monkey(inputForMonkey));
            lineIdx += 7;
        }
    }

}
