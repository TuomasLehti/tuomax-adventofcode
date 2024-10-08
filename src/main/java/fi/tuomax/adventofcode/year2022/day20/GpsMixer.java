package fi.tuomax.adventofcode.year2022.day20;

import java.util.ArrayList;
import java.util.List;

/**
 * Decrypts a sequence.
 */
public class GpsMixer 
{

    /** The sequence of numbers in its original order. */
    private List<GpsNumber> original = new ArrayList<>();

    /** The sequence of numbers in its current order. */
    private List<GpsNumber> mixed = new ArrayList<>();

    public void addNumber(long i)
    {
        GpsNumber num = new GpsNumber();
        num.num = i;
        num.currIdx = original.size();
        num.origIdx = original.size();
        original.add(num);
        mixed.add(num);
    }

    /** The size of the sequence of numbers. */
    public int size()
    {
        return mixed.size();
    }

    /**
     * Gets a number with its current index. If index is out of bounds, it
     * will be mapped back to bounds.
     */
    public GpsNumber getMixed(int idx)
    {
        return mixed.get(indexToBounds(idx));
    }

    /**
     * Gets the index of number zero in the current order.
     */
    public int getMixedZeroIdx()
    {
        for (int i = 0; i < mixed.size(); i++)
            if (mixed.get(i).num == 0) return i;
        return 0;
    }

    /**
     * Moves a number from an index in the current order after an index in the
     * current order. If either index is out of bounds, it will be mapped so 
     * that it will be in bounds.
     */
    public void move(int fromMixedIdx, int afterMixedIdx)
    {
        fromMixedIdx = indexToBounds(fromMixedIdx);
        afterMixedIdx = indexToBounds(afterMixedIdx);
        if (afterMixedIdx < fromMixedIdx) afterMixedIdx++;
        GpsNumber num = mixed.remove(fromMixedIdx);
        mixed.add(afterMixedIdx, num);
    }

    /**
     * Move a number by a number steps.
     * 
     * There is a catch that's missing from the example input: moving a number
     * by a number of steps which is greater than the size of the list. A number
     * is removed from the list as soon as the moving starts, which means that
     * it is at the starting index every size-1 steps. 
     * 
     * A move of 7 steps is the same as a move of 2 steps, and so are moves of
     * 12 and 17 steps, if there are 6 numbers in the sequence.
     *
     *              vv
     *      0  10 11 X  12 13
     * 1  | 0  10 11 12 X  13  
     * 2  | 0  10 11 12 13 X   = X  0  10 11 12 13
     * 3  | 0  X  10 11 12 13
     * 4  | 0  10 X  11 12 13
     * 5  | 0  10 11 X  12 13
     * 6  | 0  10 11 12 X  13
     * 7  | 0  10 11 12 13 X   = X  0  10 11 12 13
     * 8  | 0  X  10 11 12 13
     * 9  | 0  10 X  11 12 13
     * 10 | 0  10 11 X  12 13
     * 11 | 0  10 11 12 X  13
     * 12 | 0  10 11 12 13 X   = X  0  10 11 12 13
     *
     *              vv
     *      0  10 11 X  12 13
     * 1  | 0  10 X  11 12 13
     * 2  | 0  X  10 11 12 13
     * 3  | X  0  10 11 12 13 = 0  10 11 12 13 X
     * 4  | 0  10 11 12 X  13
     * 5  | 0  10 11 X  12 13
     * 6  | 0  10 X  11 12 13
     * 7  | 0  X  10 11 12 13
     * 8  | X  0  10 11 12 13 = 0  10 11 12 13 X
     * 9  | 0  10 11 12 X  13
     * 10 | 0  10 11 X  12 13
     * 11 | 0  10 X  11 12 13
     * 12 | 0  X  10 11 12 13
     * 13 | X  0  10 11 12 13 = 0  10 11 12 13 X
     * 14 | 0  10 11 12 X  13
     * 15 | 0  10 11 X  12 13
     */     
    public void moveByNum(int fromOrigIdx)
    {
        GpsNumber num = original.get(fromOrigIdx);
        long amount = num.num % (mixed.size() - 1);
        /* If moving left the number goes after the previous index. */
        if (amount < 0) amount--;
        int fromMixedIdx = mixed.indexOf(num);
        int toMixedIdx = fromMixedIdx + (int) amount;
        move(fromMixedIdx, toMixedIdx);

    }

    /** 
     * If an index is out of bounds, move it back to bounds. This could also
     * be done by modulus, but if my undestranding of this code is correct,
     * this will only be called when the index is not that far off. (If there
     * are 6 numbers in the sequence, the index will be between -6 and 12.)
     * Still using while to prevent bugs if my understanding is not correct.
    */
    private int indexToBounds(int idx)
    {
        while (idx < 0) idx += mixed.size();
        while (idx >= mixed.size()) idx -= mixed.size();
        return idx;
    }

    /**
     * The sequence of numbers is circular. Zero is a number which won't be
     * duplicated, because it is used in the final calculation, so we can
     * also use it as a starting point when comparing two sequences.
     */
    public boolean equals(Object o)
    {
        if (o == null || !(o instanceof GpsMixer)) return false;
        if (o == this) return true;
        GpsMixer other = (GpsMixer) o;
        if (mixed.size() != other.mixed.size()) return false;
        int zero = getMixedZeroIdx();
        int otherZero = other.getMixedZeroIdx();
        for (int i = 0; i < mixed.size(); i++)
            if (getMixed(zero + i).num != other.getMixed(otherZero + i).num) 
                return false;
        return true;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        int zero = getMixedZeroIdx();
        for (int i = 0; i < mixed.size(); i++) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(getMixed(zero + i).num);
        }
        return sb.toString();
    }
    
}
