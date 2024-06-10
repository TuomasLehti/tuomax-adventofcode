package fi.tuomax.adventofcode.year2015.day06.lightranges;

import java.util.ArrayList;
import java.util.List;

public class RangeTree 
extends Range
{

    private List<RangeTree> children = null;

    public RangeTree(Long start, Long end) 
    {
        super(start, end);
    }

    public RangeTree(Range range)
    {
        super(range.getStart(), range.getEnd());
    }

    public List<Range> splitBefore(Long index)
    {
        if (!contains(index) || index.equals(getStart()))
            return flatten();
        if (children == null) {
            List<Range> childRanges = super.splitBefore(index);
            children = new ArrayList<>();
            for (Range range : childRanges) {
                children.add(new RangeTree(range));
            }
        } else {
            for (RangeTree tree : children) {
                tree.splitBefore(index);
            }
        }
        return flatten();
    }

    public List<Range> splitAfter(Long index)
    {
        if (!contains(index) || index.equals(getEnd()))
            return flatten();
        if (children == null) {
            List<Range> childRanges = super.splitAfter(index);
            children = new ArrayList<>();
            for (Range range : childRanges) {
                children.add(new RangeTree(range));
            }
        } else {
            for (RangeTree tree : children) {
                tree.splitAfter(index);
            }
        }
        return flatten();
    }

    public List<Range> flatten()
    {
        List<Range> result = new ArrayList<>();
        if (children == null) {
            result.add(this);
        } else {
            for (RangeTree child : children) {
                result.addAll(child.flatten());
            }
        }
        return result;
    }
    
}
