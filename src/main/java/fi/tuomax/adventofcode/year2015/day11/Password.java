package fi.tuomax.adventofcode.year2015.day11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Santa's password from Advent of Code 2015, day 11.
 */
public class Password 
{

    /**
     * The length of a password is always eight characters, which is why there
     * is not much in the way of error checking in this class.
     */
    public static final Integer PASSWORD_LENGTH = 8;

    /**
     * The password is stored as 8 bytes ranging from 97 to 122.
     */
    private byte[] password = new byte[PASSWORD_LENGTH];

    public Password(String password)
    {
        setPassword(password);
    }

    private void setPassword(String passwordString)
    {
        password = passwordString.getBytes();
    }

    public String getPassword()
    {
        return new String(password);
    }

    public Boolean isValid()
    {
        return 
            hasStraight() &&
            !containsInvalidLetters() &&
            hasTwoPairs();
    }

    private boolean hasTwoPairs() {
        Set<Byte> pairChars = new HashSet<>();
        Integer idx = 0;
        while (idx < PASSWORD_LENGTH - 1) {
            if (password[idx] == password[idx + 1]) {
                pairChars.add(password[idx]);
                idx++;
            }
            idx++;
        }
        return pairChars.size() >= 2;
    }

    private boolean containsInvalidLetters() {
        List<Byte> invalidChars = Arrays.asList(new Byte[]{105, 108, 111});
        for (int idx = 0; idx < PASSWORD_LENGTH; idx++) {
            if (invalidChars.contains(password[idx])) {
                return true;
            }
        }
        return false;
    }

    private boolean hasStraight() {
        for (int idx = 0; idx < PASSWORD_LENGTH - 2; idx++) {
            if (password[idx + 1] == password[idx] + 1 &&
                    password[idx + 2] == password[idx] + 2) {
                return true;
            }
        }
        return false;
    }

    public void incrementToNextValid()
    {
        do {
            increment(7);
        } while (!isValid());
    }

    /**
     * Increments the digit'th digit. 7 = least significant, 0 = most significant.
     */
    private void increment(int digit) {
        password[digit]++;
        /* roll over? */
        if (password[digit] > 122) {
            password[digit] = 97;
            /* In the case of roll over, more significant digit must also be 
             * incremented, but only if there is a more significant digit. */
            if (digit > 0) {
                increment(digit - 1);
            }
        }
    }
    
}
