package fi.tuomax.adventofcode.year2024.day05;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2024, day 5, part 2:
 * Print Queue.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/5">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class PrintQueue_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 5, 2,
            "Print Queue", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new PrintQueue_Parser(input);
    }

    @Override
    protected void solve()
    {
        List<Update> updates = ((PrintQueue_Parser) parser).getUpdates();
        List<RuleOrder> order = RuleOrder.getRuleOrder(((PrintQueue_Parser) parser).getRules());

        for (RuleOrder ruleorder : order) System.out.println(ruleorder.toString());

        Long result = 0L;
        for (Update update : updates) {
            if (!update.isInRightOrder()) {
                update.rearrange(order);
                result += update.getMiddlePageNumber();
            }
        }
        setAnswer(result);
    }

}
// 4591 too low