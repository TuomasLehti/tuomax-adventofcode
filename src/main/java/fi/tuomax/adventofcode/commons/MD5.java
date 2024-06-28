package fi.tuomax.adventofcode.commons;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.fusesource.jansi.Ansi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains the actual solving (business) logic for Advent of Code puzzles in
 * which the problem is to find a hash with certain properties.
 */
public class MD5 {

    private static Logger LOGGER = LoggerFactory.getLogger(MD5.class);

    private static int LOGGING_FREQUENCY = 250_000;

    private static MessageDigest algorithm = null;

    /*
     * The initialization of the algorithm is done in a separate block in order
     * to catch and log any errors.
     */
    static {
        try {
            MD5.algorithm = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error(
                Ansi.ansi().fg(Ansi.Color.RED).a(
                    e.toString()
                ).reset().toString()
            );
        }
    }

    /** Constructs a 32-digit hexadecimal hash from a given input. */
    public static String getMD5(String input) 
    {
        /*
         * digest() returns an array of bytes. Oracle reference docs do not 
         * mention the endianness of the resulting array, but I do believe it
         * is always big-endian because that's just how hashing algos work.
         * 
         * This constructor of BigInteger takes in the sign of the number as
         * the first argument.
         * 
         * The BigInteger is converted to hexadecimal, because that is what
         * the puzzle requires, and padded with zeros, if it is shorter than
         * 32 digits.
         */
        return getMD5(input, "%032x");
    }

    /** Constructs a 32-digit hexadecimal hash from a given input. */
    public static String getMD5(String input, String format) 
    {
        /*
         * digest() returns an array of bytes. Oracle reference docs do not 
         * mention the endianness of the resulting array, but I do believe it
         * is always big-endian because that's just how hashing algos work.
         * 
         * This constructor of BigInteger takes in the sign of the number as
         * the first argument.
         * 
         * The BigInteger is converted to hexadecimal, because that is what
         * the puzzle requires, and padded with zeros, if it is shorter than
         * 32 digits.
         */
        algorithm.update(input.getBytes());
        return String.format(format, new BigInteger(1, algorithm.digest()));
    }

    /**
     * <p>Goes through millions of hashes to find one that starts with a 
     * certain string.</p>
     * 
     * <p>Suppose the ``seed`` is "abc" and ``startSearchFrom`` is 0. The 
     * search is started from "abc0", "abc1", "abc2", and so on, until a hash
     * is found which starts with ``hasToStartWith``</p>
     * 
     * @return 
     *      The number which yields the correct hash.
     * 
     * @deprecated
     *      Use ``getNumber()`` instead.
     */
    @Deprecated
    public static String getHash(
        String secretKey, 
        String hasToStartWith
    ) {
        Integer number = 0;
        String md5 = "";
        do {
            md5 = MD5.getMD5(String.format("%s%d", secretKey, number));
            if ((number % LOGGING_FREQUENCY) == 0) 
                LOGGER.debug(number + " hashes tried so far.");
            number++;
        } while (!md5.startsWith(hasToStartWith));
        number--;
        return (number.toString());
    }

    public static Integer getNumber(
        String secretKey, 
        String hasToStartWith,
        Integer startSearchFrom
    ) {
        Integer number = startSearchFrom;
        String md5 = "";
        do {
            md5 = MD5.getMD5(String.format("%s%d", secretKey, number));
            if ((number % LOGGING_FREQUENCY) == 0) 
                LOGGER.debug(number + " hashes tried so far.");
            number++;
        } while (!md5.startsWith(hasToStartWith));
        number--;
        return number;
    }

    
    /**
     * <p>Goes through millions of hashes to find one that starts with a 
     * certain string.</p>
     * 
     * <p>Suppose the ``seed`` is "abc" and ``startSearchFrom`` is 0. The 
     * search is started from "abc0", "abc1", "abc2", and so on, until a hash
     * is found which starts with ``hasToStartWith``</p>
     * 
     * @return
     *      The hash.
     */
    public static String getHash(
        String seed, 
        String hasToStartWith,
        Integer startSearchFrom
    ) {
        Integer number = startSearchFrom;
        String md5 = "";
        do {
            md5 = MD5.getMD5(String.format("%s%d", seed, number));
            if ((number % LOGGING_FREQUENCY) == 0) 
                LOGGER.debug(number + " hashes tried so far.");
            number++;
        } while (!md5.startsWith(hasToStartWith));
        number--;
        return md5;
    }


}
