package fi.tuomax.adventofcode.year2016.day10;

import java.util.List;
import org.json.JSONObject;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2016, day 10: 
 * Explosives in Cyberspace
 * @see 
 *      <a href="https://adventofcode.com/2016/day/10">
 *      Puzzle on the Advent of Code website.</a>
 */
public abstract class BalanceBots_Solver
extends Solver
{

    public void setParameters(JSONObject parameters) 
    {
        this.parameters = parameters;
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new BalanceBots_Parser(input);
    }

    protected BalanceBots_Parser bbParser;

    @Override
    protected void solve() 
    {
        bbParser = (BalanceBots_Parser) parser;
        /* Give the initial chips to bots. */
        for (Instruction instruction : bbParser.getInstructions()) {
            bbParser.getBot(instruction.bot())
                    .receive(instruction.value(), bbParser.getBots());
        }
        /* Search for a bot that has two chips and start the recursive chip-
         * passing process.. In my input's start configuration there's only one 
         * bot which has two chips. */
        for (Integer botNumber : bbParser.getBotNumbers()) {
            Bot bot = bbParser.getBot(botNumber);
            if (bot.hasTwoChips()) {
                bot.give(bbParser.getBots());
                break;
            }
        }
        /* The passing of chips is done. From here the solvers for individual 
         * parts take over. */
    }

    private void printBots()
    {
        StringBuilder sb = new StringBuilder();
        for (Integer botNumber : bbParser.getBotNumbers()) {
            if (sb.length() > 0)
                if ((botNumber % 10) != 0)
                    sb.append("  ");
                else
                    sb.append("\n");
            sb.append(bbParser.getBot(botNumber).toString());
        }
        System.out.println(sb.toString());
    }
    
}
