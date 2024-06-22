package fi.tuomax.adventofcode.year2015.day20;

import java.util.Map;

/**
 * Counts the sum of factors of a number.
 * @see https://planetmath.org/FormulaForSumOfDivisors
 */
public class SumOfFactors 
{
    
    public static Long sumOfFactors(Long input)
    {
        PrimeFactorizer.getInstance().reset();
        Map<Long, Integer> primeFactors = PrimeFactorizer.getInstance().primeFactors(input);
        Long result = 1L;
        for (Long prime : primeFactors.keySet()) {
            Long top = pow(prime, primeFactors.get(prime) + 1) - 1;
            Long bottom = prime - 1;
            result *= (top / bottom);
        }

/*
        for (int i = 0; i < primeFactors.size(); i++) {
            if (primeFactors.get(primeFactors.keySet().get(i)) > 0) {
                Long top = pow(Primes.primes.get(i), primeFactors.get(i) + 1) - 1;
                Long bottom = Primes.primes.get(i) - 1;
                result *= (top / bottom);
            }
        }*/

        return result;
    }

    public static Long sumOfFactors(Map<Long, Integer> primeFactors)
    {
        Long result = 1L;
        for (Long prime : primeFactors.keySet()) {
            Long top = pow(prime, primeFactors.get(prime) + 1) - 1;
            Long bottom = prime - 1;
            result *= (top / bottom);
        }
        return result;
    }

    private static Long pow(Long num, Integer integer) {
        return Math.round(Math.pow(Double.valueOf(num), Double.valueOf(integer)));
    }

}
