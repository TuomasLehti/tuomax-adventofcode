package fi.tuomax.adventofcode.year2015.day20;

import java.util.HashMap;
import java.util.Map;

public class TrialDivisionPrimeFactorizer_WithMemoization
extends PrimeFactorizer
{

    private static HashMap<Long, Map<Long, Integer>> memo = new HashMap<>();

    private static Integer primeIdx = 0;

    @Override
    public Map<Long, Integer> primeFactors(Long input) 
    {
        if (input == 1) 
            return new HashMap<Long, Integer>();

        if (TrialDivisionPrimeFactorizer_WithMemoization.memo.containsKey(input))
            return new HashMap<Long, Integer>(TrialDivisionPrimeFactorizer_WithMemoization.memo.get(input));

        Long prime = Primes.primes.get(TrialDivisionPrimeFactorizer_WithMemoization.primeIdx);
        while ((input % prime) != 0) {
            TrialDivisionPrimeFactorizer_WithMemoization.primeIdx++;
            prime = Primes.primes.get(TrialDivisionPrimeFactorizer_WithMemoization.primeIdx);
        }
        input = input / prime;
        Map<Long, Integer> primeFactors = PrimeFactorizer.getInstance().primeFactors(input);
        if (!primeFactors.containsKey(prime))
            primeFactors.put(prime, 1);
        else
            primeFactors.put(prime, primeFactors.get(prime) + 1);
        if (!TrialDivisionPrimeFactorizer_WithMemoization.memo.containsKey(input * prime))
            TrialDivisionPrimeFactorizer_WithMemoization.memo.put(
                input * prime, 
                new HashMap<Long, Integer>(primeFactors));

        return primeFactors;
    }

    @Override
    public void reset() 
    {
        primeIdx = 0;
    }
    
}
