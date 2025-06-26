package fi.tuomax.adventofcode.year2017.day18;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 18, part 2:
 * Duet.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/18">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class Duet_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 18, 2,
            "Duet", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new Duet_Parser(input);
    }

    @Override
    protected void solve()
    {
        Cpu one = ((Duet_Parser) parser).getOne();
        Cpu other = ((Duet_Parser) parser).getOther();
        Boolean oneDeadLocked = false;
        Boolean otherDeadLocked = false;
        while (!(oneDeadLocked && otherDeadLocked)) {
            one.run();
            other.run();
            oneDeadLocked = 
                (one.getCpuState() == one.CPU_STOPPED) && 
                (Duet_Send.ques.get(1).isEmpty());
            otherDeadLocked = 
                (other.getCpuState() == other.CPU_STOPPED) && 
                (Duet_Send.ques.get(0).isEmpty());
        }
        setAnswer(Duet_Send.sent[1]);
    }

}

// 254 too low