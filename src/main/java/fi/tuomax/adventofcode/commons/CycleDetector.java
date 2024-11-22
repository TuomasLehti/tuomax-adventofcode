package fi.tuomax.adventofcode.commons;

import java.util.List;

public class CycleDetector 
{

    public record CycleData(
        Long start,
        Long length
    ){}

    /**
     * Detects a cycle. The list of ints must be at least two elements long, 
     * because there can't be any cycles if it is shorter. Returns a CycleData
     * with values -1 if there a cycle is not detected.
     * @param ints
     * @return
     */
    public static CycleData detect(List<Integer> ints)
    {
        if (ints.size() < 2)
            throw new IllegalArgumentException(String.format(
                "The list must be at least two elements long (actual length %d)!",
                ints.size()
            ));

        for (int start = 0; start < ints.size(); start++) {
            for (int length = 1; length < ints.size(); length++) {
                if (isRepeating(ints, start, length)) 
                    return new CycleData((long) start, (long) length);
            }
        }
        return new CycleData(-1L, -1L);

/*         int windowLength = ints.size() / 2;
        List<Integer> one = ints.subList(0, windowLength);
        List<Integer> other = ints.subList(windowLength, ints.size());
        while (!listsEqual(one, other) && windowLength > 1) {
            windowLength--;
            one = ints.subList(0, windowLength);
            other = ints.subList(windowLength, ints.size());
        }
        return listsEqual(one, other) ?
            new CycleData(0L, (long) windowLength) :
            new CycleData(-1L, -1L);
 */    }

    public static Boolean isRepeating(List<Integer> ints, long start, long length)
    {
        long substart = start + length;
        if (substart >= ints.size()) return false;
        List<Integer> beginning = ints.subList((int) start, (int) (start + length));
        boolean works = true;
        while (substart < ints.size()) {
            long subEnd = Math.min(
                substart + length,
                ints.size()
            );
            List<Integer> other = ints.subList((int) substart, (int) subEnd);
            works &= listsEqual(beginning, other);
            substart += length;
        }
        return works;
    }

    private static Boolean listsEqual(List<Integer> one, List<Integer> other)
    {
        if (one.size() > other.size())
            one = one.subList(0, other.size());
        else if (other.size() > one.size())
            other = other.subList(0, one.size());
        for (int i = 0; i < one.size(); i++)
            if (!one.get(i).equals(other.get(i)))
                return false;
        return true;
    }
    
}
