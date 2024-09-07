package fi.tuomax.adventofcode.year2022.day11;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Solves Advent of Code 2022, day 11, part 2:
 * Monkey in the Middle.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/11">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class MonkeyInTheMiddle_Part2
extends Solver
{

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 11, 2,
            "Monkey in the Middle", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new MonkeyInTheMiddle_Parser(input);
    }

    @Override
    protected void solve()
    {
        List<Monkey> barrel = ((MonkeyInTheMiddle_Parser) parser).getBarrel();
        Integer numOfRounds = getParamInt("number_of_rounds");
        WorryReliever reliever = new WorryReliever_Part2();
        for (int round = 0; round < numOfRounds; round++) {
            for (int i = 0; i < barrel.size(); i++) {
                barrel.get(i).turn(barrel, reliever);
            }
            if (round == 20 || (round % 1000) == 0) 
                LOGGER.debug(String.format(
                        "Round %d.", 
                        round
                    ));
        }
        List<Long> itemsInspected = new ArrayList<>();
        for (Monkey monkey : barrel) {
            itemsInspected.add(monkey.getItemsInspected());
        }
        Collections.sort(itemsInspected);
        Collections.reverse(itemsInspected);

        setAnswer(itemsInspected.get(0) * itemsInspected.get(1));
    }

}
// 28188157260 too low