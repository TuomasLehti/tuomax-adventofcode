package fi.tuomax.adventofcode.year2024.day07;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.LoggerFactory;

/**
 * <p>Solves Advent of Code 2024, day 7, part 1:
 * Bridge Repair.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/7">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class BridgeRepair_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 7, 1,
            "Bridge Repair", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new BridgeRepair_Parser(input);
    }

    protected BridgeRepair_Parser parser()
    {
        return (BridgeRepair_Parser) parser;
    }

    @Override
    protected void solve()
    {
        Long result = 0L;
        for (Equation eq : parser().getEquations()) {
//            LoggerFactory.getLogger(getClass()).debug(eq.toString());
            EquationSolver es = new EquationSolver();
            if (es.possibleAnswersForEquation(eq.operands()).contains(eq.result()))
                result += eq.result();
        }
        setAnswer(result);
    }


}
