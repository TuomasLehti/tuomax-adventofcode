package fi.tuomax.adventofcode.year2022.day20;

import java.util.ArrayList;
import java.util.List;

public class GpsMixer 
{

    private List<GpsNumber> original = new ArrayList<>();

    private List<GpsNumber> mixed = new ArrayList<>();

    public void addInteger(int i)
    {
        GpsNumber num = new GpsNumber();
        num.num = i;
        num.currIdx = original.size();
        num.origIdx = original.size();
        original.add(num);
        mixed.add(num);
    }

    public int size()
    {
        return mixed.size();
    }

    public GpsNumber getMixed(int idx)
    {
        return mixed.get(indexToBounds(idx));
    }

    public int getMixedZeroIdx()
    {
        for (int i = 0; i < mixed.size(); i++)
            if (mixed.get(i).num == 0) return i;
        return 0;
    }

    public void move(int fromMixedIdx, int afterMixedIdx)
    {
        fromMixedIdx = indexToBounds(fromMixedIdx);
        afterMixedIdx = indexToBounds(afterMixedIdx);
        if (afterMixedIdx < fromMixedIdx) afterMixedIdx++;
        GpsNumber num = mixed.remove(fromMixedIdx);
        mixed.add(afterMixedIdx, num);
    }

    public void moveByNum(int fromOrigIdx)
    {
        GpsNumber num = original.get(fromOrigIdx);
        int fromMixedIdx = mixed.indexOf(num);
        int toMixedIdx = fromMixedIdx + num.num;
        if (num.num < 0) toMixedIdx--;
        move(fromMixedIdx, toMixedIdx);

    }

    private int indexToBounds(int idx)
    {
        while (idx < 0) idx += mixed.size();
        while (idx >= mixed.size()) idx -= mixed.size();
        return idx;
    }

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
        for (GpsNumber n : mixed) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(n.num);
        }
        return sb.toString();
    }
    
}
