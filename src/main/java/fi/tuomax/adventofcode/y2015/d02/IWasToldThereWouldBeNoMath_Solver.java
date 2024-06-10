package fi.tuomax.adventofcode.y2015.d02;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

public abstract class IWasToldThereWouldBeNoMath_Solver 
extends Solver
{

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new IWasToldThereWouldBeNoMath_Parser(input);
    }

    /**
     * Finds the smallest of three integers.
     */
    public Integer minimum(Integer i1, Integer i2, Integer i3) 
    {
        return (Math.min(i1, Math.min(i2, i3)));
    }

    protected abstract Integer calculation(Present present);

    @Override
    protected void solve() {
        Integer result = 0;
        for (Present present : (IWasToldThereWouldBeNoMath_Parser) parser) {
            result += calculation(present);
        }
        setAnswer(result);
    }
    
}
