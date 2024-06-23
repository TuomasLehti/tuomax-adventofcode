package fi.tuomax.adventofcode.year2016.day01;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class NoTimeForATaxicab_Part1 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 1, 1, 
            "No Time for a Taxicab", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new NoTimeForATaxicab_Parser(input);
    }

    @Override
    protected void solve() 
    {
        int dir = 0;
        int x = 0;
        int y = 0;
        for (Instruction instruction : (NoTimeForATaxicab_Parser) parser) {
            if (instruction.getTurn() == 'R')
                dir++;
            else
                dir--;
            if (dir > 3)
                dir -= 4;
            else if (dir < 0)
                dir += 4;
            if (dir == 0)
                y -= instruction.getBlocks();
            else if (dir == 1)
                x += instruction.getBlocks();
            else if (dir == 2)
                y += instruction.getBlocks();
            else
                x -= instruction.getBlocks();
        }
        setAnswer(Math.abs(x) + Math.abs(y));
    }
    
}
// 370 too high