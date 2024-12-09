package fi.tuomax.adventofcode.year2024.day09;

public class HistoriansFile 
implements Comparable<HistoriansFile>
{

    private Integer index;

    public Integer getIndex() {
        return index;
    }

    private Integer start;

    public Integer getStart() {
        return start;
    }

    private Integer length;

    public Integer getLength() {
        return length;
    }

    public Integer getEnd() {
        return start + length - 1;
    }

    public HistoriansFile(Integer index, Integer start, Integer length)
    {
        this.index = index;
        this.start = start;
        this.length = length;
    }

    public void move(Integer newStart)
    {
        this.start = newStart;
    }

    public void adjustLength(Integer newLength)
    {
        this.length = newLength;
    }

    public HistoriansFile copy()
    {
        return new HistoriansFile(this.index, this.start, this.length);
    }

    public Long checkSum()
    {
        Long result = 0L;
        for (int i = getStart(); i <= getEnd(); i++)
            result += (i * index);
        return result;
    }

    @Override
    public int compareTo(HistoriansFile o) 
    {
        return this.getStart().compareTo(o.getStart());
    }
    
}
