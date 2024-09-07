package fi.tuomax.adventofcode.year2022.day11;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.ArrayList;
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
public class MonkeyInTheMiddle_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 11, 1,
            "Monkey in the Middle", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new MonkeyInTheMiddle_Parser(input);
    }

    private String barrelStatus(List<Monkey> barrel)
    {
        StringBuilder sb = new StringBuilder();
        for (Monkey monkey : barrel) {
            if (sb.length() > 0) sb.append("\n");
            sb.append(monkey.getItemsAsString());
        }
        return sb.toString();
    }

    @Override
    protected void solve()
    {
        List<Monkey> barrel = ((MonkeyInTheMiddle_Parser) parser).getBarrel();
        Integer numOfRounds = getParamInt("number_of_rounds");
        WorryReliever reliever = new WorryReliever_Part1();
        for (int round = 0; round < numOfRounds; round++) {
            for (int i = 0; i < barrel.size(); i++) {
                barrel.get(i).turn(barrel, reliever);
            }
//            System.out.println("\n\nRound " + (round + 1));
//            System.out.println(barrelStatus(barrel));
        }
        List<Long> itemsInspected = new ArrayList<>();
        for (Monkey monkey : barrel) {
//            System.out.println(String.format(
//                "Monkey %d inspected items %d times.",
//                monkey.getNumber(), monkey.getItemsInspected()
//            ));
            itemsInspected.add(monkey.getItemsInspected());
        }
        Collections.sort(itemsInspected);
        Collections.reverse(itemsInspected);

        setAnswer(itemsInspected.get(0) * itemsInspected.get(1));
    }

}
