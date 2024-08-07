package fi.tuomax.adventofcode.commons;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.fusesource.jansi.Ansi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Contains the actual solving (business) logic for Advent of Code puzzles 
 * in which the problem is to find a hash with certain properties.</p>
 * 
 * 
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
     * Constructs a 32-digit hexadecimal MD5 hash by hashing a given input
     * many times. 
     */
    public static String getMD5(String input, Integer iterations) 
    {
        String hash = input;
        for (int i = 0; i < iterations; i++)
            hash = MD5.getMD5(hash, "%032x");
        return hash;
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

    /**
     * <p>Solves an AoC MD5 puzzle, in which a running number is added to the
     * end of a secret key, salt, or however it is descriped in a puzzle, and
     * the result is the number, which yields a MD5 hash with certain 
     * properties.</p>
     * 
     * <p>This method deals with MD5 hashes that start with a certain string,
     * and it is left here for backwards combatibility. We wouldn't want to
     * break old solvers just yet, but this method is still marked as 
     * deprecated. The new version of the method has the same name, but the
     * parameters differ.</p>
     * 
     * @param secretKey
     *      The prefix of the string to be hashed.
     * 
     * @param hasToStartWith
     *      The prefix which the MD5 hash has to have.
     * 
     * @param startSearchFrom
     *      The fist number to try.
     * 
     * @return
     *      The number which yields a hash starting with a certain string.
     */
    @Deprecated
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

    public static Integer leftOff = -1;

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
    @Deprecated
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
        MD5.leftOff = number;
        return md5;
    }

    private static Map<Integer, String> memo = new HashMap<>();

    public static void clearCache()
    {
        memo.clear();
    }

    /**
     * <p>Solves an AoC MD5 puzzle, in which a running number is added to the
     * end of a secret key, salt, or however it is descriped in a puzzle, and
     * the result is the number, which yields a MD5 hash with certain 
     * properties.</p>
     *
     * @param secretKey
     *      The prefix of the string to be hashed.
     * 
     * @param requirement
     *      The requirement the MD5 must fulfill.
     * 
     * @param startSearchFrom
     *      The fist number to try.
     * 
     * @return
     *      The number which yields a hash starting with a certain string.
     */
    public static Integer getNumber(
        String secretKey, 
        MD5Requirement requirement,
        Integer iterations,
        Integer startSearchFrom,
        Integer endSearchAt
    ) {
        Integer number = startSearchFrom;
        String md5 = "";
        Boolean finished = false;
        do {
            if (!MD5.memo.containsKey(number))
                MD5.memo.put(number, MD5.getMD5(String.format("%s%d", secretKey, number), iterations));
            md5 = MD5.memo.get(number);
//            md5 = MD5.getMD5(String.format("%s%d", secretKey, number), iterations);
            if ((number % LOGGING_FREQUENCY) == 0) 
                LOGGER.debug(number + " hashes tried so far.");
            number++;
            finished = requirement.fulfilledBy(md5) ||
                    (endSearchAt < 0 ? false : number > endSearchAt);
        } while (!finished);
        number--;
        if (endSearchAt < 0)
            return number;
        else if (number >= endSearchAt)
            return -1;
        else
            return number;
            
    }


}
