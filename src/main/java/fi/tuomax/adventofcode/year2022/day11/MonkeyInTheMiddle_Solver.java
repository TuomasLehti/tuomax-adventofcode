package fi.tuomax.adventofcode.year2022.day11;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.Collections;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 11, part 1:
 * Monkey in the Middle.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/11">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public abstract class MonkeyInTheMiddle_Solver
extends Solver
{

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new MonkeyInTheMiddle_Parser(input);
    }

    protected abstract WorryReliever manufactureWorryReliever(List<Monkey> barrel);

    @Override
    protected void solve()
    {
        List<Monkey> barrel = ((MonkeyInTheMiddle_Parser) parser).getBarrel();
        Integer numOfRounds = getParamInt("number_of_rounds");
        WorryReliever reliever = manufactureWorryReliever(barrel);
        for (int round = 0; round < numOfRounds; round++) {
            for (int i = 0; i < barrel.size(); i++) {
                barrel.get(i).turn(barrel, reliever);
            }
        }
        Collections.sort(barrel);
        Collections.reverse(barrel);

        setAnswer(barrel.get(0).getItemsInspected() * 
                barrel.get(1).getItemsInspected());
    }

}
