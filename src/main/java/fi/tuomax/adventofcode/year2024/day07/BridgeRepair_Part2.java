package fi.tuomax.adventofcode.year2024.day07;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2024, day 7, part 2:
 * Bridge Repair.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/7">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class BridgeRepair_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 7, 2,
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
            EquationSolver es = new EquationSolver();
            if (es.solvesEquationPart2(eq.result(), eq.operands()))
                result += eq.result();
        }
        setAnswer(result);
    }


}