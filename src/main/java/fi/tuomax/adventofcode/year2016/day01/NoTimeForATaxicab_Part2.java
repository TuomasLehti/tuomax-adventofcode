package fi.tuomax.adventofcode.year2016.day01;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class NoTimeForATaxicab_Part2 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 1, 2, 
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
        long x = 0;
        long y = 0;
        Set<Coordinates> visited = new HashSet<>();
        visited.add(Coordinates.ORIGIN);
        for (Instruction instruction : (NoTimeForATaxicab_Parser) parser) {
            if (instruction.getTurn() == 'R')
                dir++;
            else
                dir--;
            if (dir > 3)
                dir -= 4;
            else if (dir < 0)
                dir += 4;
            for (int i = 0; i < instruction.getBlocks(); i++) {
                if (dir == 0)
                    y--;
                else if (dir == 1)
                    x++;
                else if (dir == 2)
                    y++;
                else
                    x--;
                Coordinates position = new Coordinates(x, y);
                if (visited.contains(position)) {
                    setAnswer(Math.abs(x) + Math.abs(y));
                    return;
                } else {
                    visited.add(position);
                }
            }
        }
    }
    
}
// 157 too low