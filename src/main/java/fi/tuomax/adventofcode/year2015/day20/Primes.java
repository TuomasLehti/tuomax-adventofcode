package fi.tuomax.adventofcode.year2015.day20;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Finds prime numbers for the Advent of Code puzzle from 2015 (day 20).
 */
public class Primes 
{

    private static Logger logger = LoggerFactory.getLogger(Primes.class);

    /**
     * The value up to which primes are counted.
     */
    public static final Integer MAX = 10_000_000;

    /**
     * The list of prime numbers.
     */
    public static List<Long> primes = new ArrayList<>();

    /**
     * Sloppy implementation of the sieve of Eratosthenes to count the primes.
     * Ten million primes in a few seconds on my machine shoukd be fine 
     * performancewise.
     * @see http://compoasso.free.fr/primelistweb/page/prime/eratosthene_en.php
     * @see https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     */
    static {
        logger.debug("Counting primes");
        boolean[] sieve = new boolean[Primes.MAX];
        for (int i = 2; i < Primes.MAX; i++) {
            if (!sieve[i]) {
                int candidate = i + i;
                while (candidate < Primes.MAX) {
                    sieve[candidate] = true;
                    candidate += i;
                }
            }
        }
        for (long i = 2; i < Primes.MAX; i++) {
            if (!sieve[(int)i]) Primes.primes.add(i);
        }
    }
    
}
