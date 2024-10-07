package fi.tuomax.adventofcode.year2022.day20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GpsSequence 
{

    public List<GpsNumber> nums = new ArrayList<>();

    public GpsSequence(int[] numbers) 
    {
        for (int n : numbers) {
            GpsNumber num = new GpsNumber();
            num.num = n;
            num.currIdx = nums.size();
            num.origIdx = nums.size();
            nums.add(num);
        }
    }

    public GpsSequence(){}

    public void add(int n)
    {
        GpsNumber num = new GpsNumber();
        num.num = n;
        num.currIdx = nums.size();
        num.origIdx = nums.size();
        nums.add(num);
    }

    public GpsNumber getNum(int n)
    {
        for (GpsNumber num : nums)
            if (num.num == n)
                return num;
        return null;
    }

    public GpsNumber getIdx(int i) 
    {
        for (GpsNumber num : nums)
            if (num.currIdx == i)
                return num;
        return null;
    }

    public void moveAll()
    {
        for (GpsNumber num : nums) {
            System.out.println(num.origIdx);
            move(num);
        }
    }

    public void move(GpsNumber num)
    {
        if (num.num == 0) return;
        long amount = Math.abs(num.num);
        if (num.num < 0) {
            for (int i = 0; i < amount; i++)
                moveLeft(num);
        } else {
            for (int i = 0; i < amount; i++)
                moveRight(num);
        }
    }

    public void moveRight(GpsNumber num)
    {
        if (num.currIdx < (nums.size() - 1)) {
            for (GpsNumber n : nums)
                if (n.currIdx == (num.currIdx + 1))
                    n.currIdx--;
            num.currIdx++;
        } else {
            for (GpsNumber n : nums)
                if (n.currIdx == 0)
                    n.currIdx = nums.size() - 1;
            num.currIdx = 0;
        }
    }

    public void moveLeft(GpsNumber num)
    {
        if (num.currIdx > 0) {
            for (GpsNumber n : nums)
                if (n.currIdx == (num.currIdx - 1))
                    n.currIdx++;
            num.currIdx--;
        } else {
            for (GpsNumber n : nums)
                if (n.currIdx == (nums.size() - 1))
                    n.currIdx = 0;
            num.currIdx = nums.size() - 1;
        }
    }

    public String toString()
    {
        List<GpsNumber> printees = new ArrayList<>(nums);
        Collections.sort(printees, new Comparator<GpsNumber>(){
            @Override
            public int compare(GpsNumber o1, GpsNumber o2) {
                return o1.currIdx - o2.currIdx;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (GpsNumber printee : printees) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(printee.num);
        }
        return sb.toString();
    }
    
}
