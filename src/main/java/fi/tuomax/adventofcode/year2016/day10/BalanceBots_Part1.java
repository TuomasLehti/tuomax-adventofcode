package fi.tuomax.adventofcode.year2016.day10;

import org.json.JSONObject;

import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * Solves Advent of Code 2016, day 10, part 1: 
 * Explosives in Cyberspace
 * @see 
 *      <a href="https://adventofcode.com/2016/day/10">
 *      Puzzle on the Advent of Code website.</a>
 */
public class BalanceBots_Part1
extends BalanceBots_Solver
{

    public void setParameters(JSONObject parameters) 
    {
        this.parameters = parameters;
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 10, 1,
            "BalanceBots", ""
        );
    }


    @Override
    protected void solve() 
    {
        super.solve();
        Integer firstTarget = parameters.getInt("firstValue");
        Integer secondTarget = parameters.getInt("secondValue");
        for (Integer botNumber : bbParser.getBotNumbers()) {
            Bot bot = bbParser.getBot(botNumber);
            if (bot.has(firstTarget, secondTarget)) {
                setAnswer(botNumber);
                break;
            }
        }

    }
    
}
