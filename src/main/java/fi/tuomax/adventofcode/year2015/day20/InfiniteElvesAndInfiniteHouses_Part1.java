package fi.tuomax.adventofcode.year2015.day20;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class InfiniteElvesAndInfiniteHouses_Part1 
extends Solver
{

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 20, 1,
            "Infinite Elves and Infinite Houses", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new InfiniteElvesAndInfiniteHouses_Parser(input);
    }

    @Override
    protected void solve() 
    {
        PrimeFactorizer.setInstance(new TrialDivisionPrimeFactorizer_WithMemoization());
        Long target = ((InfiniteElvesAndInfiniteHouses_Parser) parser).getTarget();
        Long house = 1L;
        Long presents = SumOfFactors.sumOfFactors(house) * 10;
        logger.debug(String.format("House %d got %d presents.", house, presents));
        while (presents <= target) {
            house++;
            presents = SumOfFactors.sumOfFactors(house) * 10;
            if ((house % 10000) == 0)
                logger.debug(String.format("House %d got %d presents.", house, presents));
        }
        setAnswer(house);
    }

}
