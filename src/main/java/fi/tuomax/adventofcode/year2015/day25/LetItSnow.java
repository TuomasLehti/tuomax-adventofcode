package fi.tuomax.adventofcode.year2015.day25;

import java.util.List;
import fi.tuomax.adventofcode.framework.parsing.NoopParser;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class LetItSnow 
extends Solver
{

    @Override
    protected void solve() 
    {
        Long start = 20151125L;
        final Long MULTIPLIER = 252533L;
        final Long DIVIDER = 33554393L;

        Integer row = 1;
        Integer col = 1;
        final Integer TARGET_ROW = 2981;
        final Integer TARGET_COL = 3075;
//        final Integer TARGET_ROW = 6;
//        final Integer TARGET_COL = 6;

        while (!(row.equals(TARGET_ROW) && col.equals(TARGET_COL))) {
            if (row.equals(1)) {
                row = col + 1;
                col = 1;
            } else {
                col++;
                row--;
            }
            start *= MULTIPLIER;
            start %= DIVIDER;
//            if (col.equals(1)) 
//                System.out.println(String.format("(%d,%d) %d", col, row, start));
        }
        setAnswer(start.toString());

    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(        
            2015, 
            25, 
            1, 
            "Let It Snow", 
            ""
        );    
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new NoopParser(input);
    }
    
}
