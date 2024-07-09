package fi.tuomax.adventofcode.year2016.day10;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class BalanceBots_Part2
extends Solver
{

    private Map<Integer, Bot> bots = new HashMap<>();

    public void setParameters(JSONObject parameters) 
    {
        this.parameters = parameters;
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 10, 2,
            "BalanceBots", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new BalanceBots_Parser(input);
    }

    private BalanceBots_Parser bbParser;

    @Override
    protected void solve() 
    {
        Integer firstTarget = parameters.getInt("firstValue");
        Integer secondTarget = parameters.getInt("secondValue");

        bbParser = (BalanceBots_Parser) parser;
        for (Instruction instruction : bbParser.getInstructions()) {
            bbParser.getBot(instruction.bot()).receive(instruction.value());
        }

//        printBots();
        while (!(bbParser.getBot(900).hasOneChip() && bbParser.getBot(901).hasOneChip() && bbParser.getBot(902).hasOneChip())) {
            for (Integer botNumber : bbParser.getBotNumbers()) {
                Bot bot = bbParser.getBot(botNumber);
                if (bot.hasTwoChips()) {
                    bot.give(bbParser.getBots());
                }
            }
//            printBots();
        }
        setAnswer(
            bbParser.getBot(900).getFirstChip() *
            bbParser.getBot(901).getFirstChip() *
            bbParser.getBot(902).getFirstChip());
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
