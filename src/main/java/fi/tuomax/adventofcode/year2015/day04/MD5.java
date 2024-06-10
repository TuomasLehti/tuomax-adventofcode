package fi.tuomax.adventofcode.year2015.day04;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.fusesource.jansi.Ansi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains the actual solving (business) logic for Advent of Code 2015, day 4.
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
        algorithm.update(input.getBytes());
        return String.format("%032x", new BigInteger(1, algorithm.digest()));
    }

    /** Goes through millions of hashes to find the one. */
    public static String getSantasHash(
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
    
}
