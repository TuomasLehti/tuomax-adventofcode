package fi.tuomax.adventofcode.year2024.day09;

public class HistoriansFile 
{

    private Integer index;

    public Integer getIndex() {
        return index;
    }

    private Long start;

    public Long getStart() {
        return start;
    }

    private Integer length;

    public Integer getLength() {
        return length;
    }

    public Long getEnd() {
        return start + length;
    }

    public HistoriansFile(Integer index, Long start, Integer length)
    {
        this.index = index;
        this.start = start;
        this.length = length;
    }
    
}
