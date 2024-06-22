package fi.tuomax.adventofcode.year2015.day20;

import java.util.Map;

/**
 * Counts the prime factors of a number.
 */
public abstract class PrimeFactorizer 
{

    private static PrimeFactorizer instance = null;
    
    public static PrimeFactorizer getInstance() {
        return PrimeFactorizer.instance;
    }

    public static void setInstance(PrimeFactorizer instance) {
        PrimeFactorizer.instance = instance;
    }

    /**
     * Returns the prime factors of a number.
     * @param input
     *      The number to factorize.
     * @return
     *      The prime factors of input.
     */
    public abstract Map<Long, Integer> primeFactors(Long input);

    /**
     * Resets the prime factorizer for a new calculation.
     */
    public abstract void reset();

}
