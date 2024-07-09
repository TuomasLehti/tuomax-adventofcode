package fi.tuomax.adventofcode.year2016.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import fi.tuomax.adventofcode.framework.parsing.Parser;

/**
 * Parses input for Advent of Code 2016, day 10: 
 * Balance Bots
 * @see 
 *      <a href="https://adventofcode.com/2016/day/10">
 *      Puzzle on the Advent of Code website.</a>
 */
public class BalanceBots_Parser 
extends Parser
{

    public BalanceBots_Parser(List<String> input) 
    {
        super(input);
    }

    private Map<Integer, Bot> bots = new TreeMap<>();

    public Map<Integer, Bot> getBots() 
    {
        return bots;
    }

    public Bot getBot(Integer botNumber)
    {
        return bots.get(botNumber);
    }

    public Set<Integer> getBotNumbers()
    {
        return bots.keySet();
    }

    private List<Instruction> instructions = new ArrayList<>();

    public List<Instruction> getInstructions()
    {
        return instructions;
    }

    @Override
    public void parse() 
    {
        for (String line : input) {
            if (line.startsWith("bot"))
                parseBot(line);
            else if (line.startsWith("value"))
                parseInstruction(line);
            else
                throw new IllegalArgumentException(
                    String.format(
                        "Unknown input: %s",
                        line
                    )
                );
        }
        for (int i = 900; i < 930; i++)
            bots.put(i, new Bot(i));
    }

    private void parseInstruction(String line) 
    {
        instructions.add(Instruction.fromInput(line));
    }

    private void parseBot(String line) 
    {
        Bot bot = new Bot(line);
        bots.put(bot.botNumber, bot);
    }


    
}
