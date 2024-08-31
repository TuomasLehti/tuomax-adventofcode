package fi.tuomax.adventofcode.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A range on the whole number line.
 */
public class Range 
{

    /**
     * The first number of this range, inclusive.
     */
    private Long start;

    /**
     * Returns the first number of this range, inclusive.
     * @return
     *      The first number of this range, inclusive.
     */
    public Long getStart() {
        return start;
    }

    /**
     * The last number of this range, inclusive.
     */
    private Long end;

    /**
     * Returns the last number of this range, inclusive.
     * @return
     *      The first number of this range, inclusive.
     */
    public Long getEnd() {
        return end;
    }

    /**
     * Constructs a range.
     * @param start
     *      The first number of this range, inclusive.
     * @param end
     *      The last number of this range, inclusive.
     * @throws
     *      IllegalArgumentException if the start is greater than the end.
     */
    public Range(Long start, Long end)
    throws IllegalArgumentException
    {
        if (start > end)
            throw new IllegalArgumentException(
                String.format("Start (%d) is greater than end (%d).", start, end)
            );
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
     * Does this range contain another range?
     * @param other
     *      A range which may be contained in this range.
     * @return
     *      Is the other range contained in this range?
     */
    public Boolean contains(Range other)
    {
        return other.getStart() >= this.getStart() && 
                other.getEnd() <= this.getEnd();
    }

    /**
     * Splits the range just before a number. If the range doesn't contain the
     * number, returns the whole range as a single part.
     * @param index
     *      The number before which the range is split.
     * @return
     *      Parts of the list.
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
     * Splits the range just after a number. If the range doesn't contain the
     * number, returns the whole range as a single part.
     * @param index
     *      The number after which the range is split.
     * @return
     *      Parts of the list.
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
     * Checks if two ranges overlap.
     * @param other
     *      The range to check against.
     * @return
     *      True if the ranges overlap.
     */
    public Boolean overlaps(Range other)
    {
        return !(this.getStart() > other.getEnd() || this.getEnd() < other.getStart());
    }

    /**
     * <p>Splits a range into three parts. The middle part will be the overlap of
     * the two ranges. The first part is the part of this range which is 
     * located before the split, and the last part is the part of this range 
     * which is located after the split.</p>
     * <table>
     * <tr> <th>this</th>  <th>other</th> <th>first</th> <th>middle</th> <th>last</th>  </tr>
     * <tr> <td>10-20</td> <td>0-5</td>   <td>null</td>  <td>null</td>   <td>10-20</td> </tr>
     * <tr> <td>10-20</td> <td>0-15</td>  <td>null</td>  <td>10-15</td>  <td>16-20</td> </tr>
     * <tr> <td>10-20</td> <td>15-30</td> <td>10-14</td> <td>15-20</td>  <td>null</td>  </tr>
     * <tr> <td>10-20</td> <td>25-30</td> <td>10-20</td> <td>null</td>   <td>null</td>  </tr>
     * <tr> <td>10-20</td> <td>0-30</td>  <td>null</td>  <td>10-20</td>  <td>null</td>  </tr>
     * <tr> <td>10-20</td> <td>14-16</td> <td>10-13</td> <td>14-16</td>  <td>17-20</td> </tr>
     * </table>
     * @param other
     *      The range with which to split.
     * @return
     *      Parts of the range.
     */
    public List<Range> split(Range other)
    {
        Range[] splitted = new Range[]{null, null, null};

        if (this.getStart() > other.getEnd()) {
            splitted[2] = this;
        } else if (this.getEnd() < other.getStart()) {
            splitted[0] = this;
        } else {
            List<Range> parts = this.splitBefore(other.getStart());
            if (parts.size() > 1) {
                splitted[0] = parts.get(0);
                splitted[1] = parts.get(1);
            } else {
                splitted[1] = parts.get(0);
            }
            parts = splitted[1].splitAfter(other.getEnd());
            if (parts.size() > 1) {
                splitted[1] = parts.get(0);
                splitted[2] = parts.get(1);
            }
        }
        
        
/*        if (this.getStart() >= other.getStart() && this.getEnd() <= other.getEnd()) {
            splitted[1] = this;
        } else if (this.getStart() < other.getStart() && this.getEnd() > other.getEnd()) {
            splitted[0] = this.splitBefore(other.getStart()).get(0);
            splitted[2] = this.splitAfter(other.getEnd()).get(1);
            splitted[1] = new Range(splitted[0].getEnd() + 1, splitted[2].getStart() - 1);
        } else if (this.getStart() <= other.getStart() && this.getEnd() <= other.getEnd()) {
            splitted[0] = this.splitBefore(other.getStart()).get(0);
            splitted[1] = this.splitBefore(other.getStart()).get(1);
        } else if (this.getStart() >= other.getStart() && this.getEnd() >= other.getEnd()) {
            splitted[1] = this.splitAfter(other.getEnd()).get(0);
            splitted[2] = this.splitAfter(other.getEnd()).get(1);
        }*/
        return Arrays.asList(splitted);
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
