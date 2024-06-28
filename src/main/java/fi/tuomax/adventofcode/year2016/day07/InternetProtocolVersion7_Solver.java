package fi.tuomax.adventofcode.year2016.day07;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringListParser;
import fi.tuomax.adventofcode.framework.solving.Solver;

public abstract class InternetProtocolVersion7_Solver 
extends Solver
{

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new StringListParser(input);
    }

    @Override
    protected void solve() 
    {
        IpSupportChecker checker = manufactureChecker();
        Integer sum = 0;
        for (String line : ((StringListParser) parser).getStrings())
            if (checker.checkSupport(line))
                sum++;
        setAnswer(sum);
    }

    protected abstract IpSupportChecker manufactureChecker();
    
}
