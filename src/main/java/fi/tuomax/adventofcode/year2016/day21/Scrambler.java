package fi.tuomax.adventofcode.year2016.day21;

import java.util.Arrays;

/**
 * Scrambles a password from Advent of Code 2017, day 21.
 */
public class Scrambler {

    /** The password is stored as a char array for speed. */
    private char[] chars;

    public Scrambler(String originalPassword) 
    {
        chars = originalPassword.toCharArray();
    }

    public String toString()
    {
        return new String(chars);
    }

    /**
     * Performs a scrambling operation on the password.
     * @param operation
     *      An operation from AoC puzzle input.
     */
    public void scramble(String operation) 
    {
        String[] op;
        op = operation.split(" ");
        if (op[0].equals("swap") && op[1].equals("position"))
            swapPosition(Integer.valueOf(op[2]), Integer.valueOf(op[5]));
        else if (op[0].equals("swap") && op[1].equals("letter"))
            swapLetter(op[2].charAt(0), op[5].charAt(0));
        else if (op[0].equals("reverse"))
            reverse(Integer.valueOf(op[2]), Integer.valueOf(op[4]));
        else if (op[0].equals("rotate") && op[1].equals("right"))
            rotateRight(Integer.valueOf(op[2]));
        else if (op[0].equals("rotate") && op[1].equals("left"))
            rotateLeft(Integer.valueOf(op[2]));
        else if (op[0].equals("move"))
            move(Integer.valueOf(op[2]), Integer.valueOf(op[5]));
        else if (op[0].equals("rotate") && op[1].equals("based"))
            rotateBased(op[6].charAt(0));
    }

    /**
     * <p>Performs an unscrambling operation on the password.</p>
     * 
     * <p>Every operation (except rotate based on position of letter) is easily
     * reversable by just changing the order of the parameteres, or in the case
     * of rotation, the direction of the rotation.</p>
     * 
     * <p>The case of rotation based on the position of a letter happens to be
     * designed so, that it, too, is should be easily reversable via some 
     * mathematics using modulo operator, but it is even easier to just brute
     * force it.</p>
     * 
     * @param operation
     *      An operation from AoC puzzle input.
     */
    public void unscramble(String operation)
    {
        String[] op;
        op = operation.split(" ");
        if (op[0].equals("swap") && op[1].equals("position"))
            swapPosition(Integer.valueOf(op[2]), Integer.valueOf(op[5]));
        else if (op[0].equals("swap") && op[1].equals("letter"))
            swapLetter(op[2].charAt(0), op[5].charAt(0));
        else if (op[0].equals("reverse"))
            reverse(Integer.valueOf(op[2]), Integer.valueOf(op[4]));
        else if (op[0].equals("rotate") && op[1].equals("right"))
            rotateLeft(Integer.valueOf(op[2]));
        else if (op[0].equals("rotate") && op[1].equals("left"))
            rotateRight(Integer.valueOf(op[2]));
        else if (op[0].equals("move"))
            move(Integer.valueOf(op[5]), Integer.valueOf(op[2]));
        else if (op[0].equals("rotate") && op[1].equals("based"))
            unrotateBased(op[6].charAt(0));
    }

    private void rotateBased(char c) 
    {
        int pos = 0;
        while (pos < chars.length && chars[pos] != c)
            pos++;
        if (pos >= 4) pos++;
        pos++;
        rotateRight(pos);
    }

    private void unrotateBased(char c)
    {
        int pos = 0;
        while (pos < chars.length && chars[pos] != c)
            pos++;
        switch (pos) {
            case 0:
                rotateLeft(1);
                break;
            case 1:
                rotateLeft(1);
                break;
            case 2:
                rotateRight(2);
                break;
            case 3:
                rotateLeft(2);
                break;
            case 4:
                rotateRight(1);
                break;
            case 5:
                rotateLeft(3);
                break;
            case 6:
                break;
            case 7:
                rotateLeft(4);
                break;
        }
    }

    private void move(Integer fromIdx, Integer toIdx) 
    {
        StringBuilder sb = new StringBuilder(new String(chars));
        Character c = sb.charAt(fromIdx);
        sb.deleteCharAt(fromIdx);
        StringBuilder n = new StringBuilder();
        n.append(sb.substring(0, toIdx));
        n.append(c);
        n.append(sb.substring(toIdx));
        chars = n.toString().toCharArray();
    }

    private void rotateLeft(Integer amount) 
    {
        int newStartPos = amount % chars.length;
        char[] newStart = Arrays.copyOfRange(chars, newStartPos, chars.length);
        char[] newEnd = Arrays.copyOfRange(chars, 0, newStartPos);
        int newStartLen = newStart.length;
        int newEndLen = newEnd.length;
        System.arraycopy(newStart, 0, chars, 0, newStartLen);
        System.arraycopy(newEnd, 0, chars, newStartLen, newEndLen);
    }

    private void rotateRight(Integer amount) 
    {
        rotateLeft(chars.length - (amount % chars.length));
    }

    private void swapPosition(Integer pos, Integer other) 
    {
        char temp = chars[pos];
        chars[pos] = chars[other];
        chars[other] = temp;
    }
    
    private void swapLetter(char letter, char other) 
    {
        int pos = 0;
        while (pos < chars.length && chars[pos] != letter)
            pos++;
        int otherPos = 0;
        while (pos < chars.length && chars[otherPos] != other)
            otherPos++;
        swapPosition(pos, otherPos);
    }

    private void reverse(Integer fromIdx, Integer toIdx) 
    {
        int numOfChars = toIdx - fromIdx + 1;
        char[] temp = new char[numOfChars];
        for (int i = 0; i < numOfChars; i++) {
            temp[i] = chars[fromIdx + i];
        }
        for (int i = 0; i < numOfChars; i++) {
            chars[toIdx - i] = temp[i];
        }
    }


}
