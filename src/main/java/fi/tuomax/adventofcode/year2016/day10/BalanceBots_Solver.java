package fi.tuomax.adventofcode.year2016.day10;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

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
        for (Instruction instruction : bbParser.getInstructions()) {
            bbParser.getBot(instruction.bot()).receive(instruction.value());
        }
        for (Integer botNumber : bbParser.getBotNumbers()) {
            Bot bot = bbParser.getBot(botNumber);
            if (bot.hasTwoChips()) {
                bot.give(bbParser.getBots());
                break;
            }
        }
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
