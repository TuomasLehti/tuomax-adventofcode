package fi.tuomax.adventofcode.y2015.d06.lightranges;

import java.util.ArrayList;
import java.util.List;

/**
 * A range on the whole number line.
 */
public class Range 
{

    /**
     * The first number of this range.
     */
    private Long start;

    /**
     * Returns the first number of this range.
     * @return
     *      The first number of this range.
     */
    public Long getStart() {
        return start;
    }

    /**
     * The last number of this range.
     */
    private Long end;

    /**
     * Returns the last number of this range.
     * @return
     *      The first number of this range.
     */
    public Long getEnd() {
        return end;
    }

    /**
     * Constructs a range.
     * @param start
     *      The first number of this range.
     * @param end
     *      The last number of this range.
     */
    public Range(Long start, Long end)
    {
        this.start = start;
        this.end = end;
    }

    /**
     * Returns the length of this range.
     * @return
     *      The length of this range.
     */
    public Long getLength()
    {
        return end - start + 1;
    }

    /**
     * Does this range contain a number?
     * @param index
     *      A number which is searched.
     * @return
     *      Is the number included in the range?
     */
    public Boolean contains(Long index)
    {
        return start <= index && index <= end;
    }

    /**
     * Splits the range just before a number.
     * @param index
     *      The number before which the range is split.
     * @return
     *      Two parts of the list.
     */
    public List<Range> splitBefore(Long index)
    {
        List<Range> result = new ArrayList<>();
        if (!contains(index) || index.equals(start)) {
            result.add(this);
        } else {
            result.add(new Range(start, index - 1));
            result.add(new Range(index, end));
        }
        return result;
    }

    /**
     * Splits the range just after a number.
     * @param index
     *      The number after which the range is split.
     * @return
     *      Two parts of the list.
     */
    public List<Range> splitAfter(Long index)
    {
        List<Range> result = new ArrayList<>();
        if (!contains(index) || index.equals(end)) {
            result.add(this);
        } else {
            result.add(new Range(start, index));
            result.add(new Range(index + 1, end));
        }
        return result;
    }

    /**
     * Two ranges are considered the same, if their first and last numbers
     * are the same.
     */
    @Override
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Range)) return false;
        Range other = (Range) o;
        return 
            this.getStart().equals(other.getStart()) &&
            this.getEnd().equals(other.getEnd());
    }

    @Override
    public String toString()
    {
        return String.format("Range [%d-%d]", getStart(), getEnd());
    }

}
