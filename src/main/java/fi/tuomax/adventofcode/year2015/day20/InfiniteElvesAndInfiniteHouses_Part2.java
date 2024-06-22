package fi.tuomax.adventofcode.year2015.day20;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class InfiniteElvesAndInfiniteHouses_Part2
extends Solver
{

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 20, 2,
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
        Long presents = 0L;
        Long house = 1L;
        Long finishedElf = -1L;
        while (presents < target) {

            if ((house % 50) == 1) finishedElf++;

            PrimeFactorizer.getInstance().reset();
            
            Map<Long, Integer> primeFactors = PrimeFactorizer.getInstance().primeFactors(house);

            Long sumOfFactors = SumOfFactors.sumOfFactors(primeFactors);
            for (long i = 1L; i <= finishedElf; i++) {
                if ((house % i) == 0)
                    sumOfFactors -= i;
            }
            presents = sumOfFactors * 11;
            if ((house % 10000) == 0)
                logger.debug(String.format("House %d got %d presents.", house, presents));
            house++;
        }
        house--;
        setAnswer(house.toString());
    }
    
}
