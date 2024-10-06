package fi.tuomax.adventofcode.year2022.day20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Nums 
{

    public List<Num> nums = new ArrayList<>();

    public Nums(int[] numbers) 
    {
        for (int n : numbers) {
            Num num = new Num();
            num.num = n;
            num.currIdx = nums.size();
            num.origIdx = nums.size();
            nums.add(num);
        }
    }

    public Nums(){}

    public void add(int n)
    {
        Num num = new Num();
        num.num = n;
        num.currIdx = nums.size();
        num.origIdx = nums.size();
        nums.add(num);
    }

    public Num getNum(int n)
    {
        for (Num num : nums)
            if (num.num == n)
                return num;
        return null;
    }

    public Num getIdx(int i) 
    {
        for (Num num : nums)
            if (num.currIdx == i)
                return num;
        return null;
    }

    public void moveAll()
    {
        for (Num num : nums) {
            System.out.println(num.origIdx);
            move(num);
        }
    }

    public void move(Num num)
    {
        if (num.num == 0) return;
        int amount = Math.abs(num.num);
        if (num.num < 0) {
            for (int i = 0; i < amount; i++)
                moveLeft(num);
        } else {
            for (int i = 0; i < amount; i++)
                moveRight(num);
        }
    }

    public void moveRight(Num num)
    {
        if (num.currIdx < (nums.size() - 1)) {
            for (Num n : nums)
                if (n.currIdx == (num.currIdx + 1))
                    n.currIdx--;
            num.currIdx++;
        } else {
            for (Num n : nums)
                if (n.currIdx == 0)
                    n.currIdx = nums.size() - 1;
            num.currIdx = 0;
        }
    }

    public void moveLeft(Num num)
    {
        if (num.currIdx > 0) {
            for (Num n : nums)
                if (n.currIdx == (num.currIdx - 1))
                    n.currIdx++;
            num.currIdx--;
        } else {
            for (Num n : nums)
                if (n.currIdx == (nums.size() - 1))
                    n.currIdx = 0;
            num.currIdx = nums.size() - 1;
        }
    }

    public String toString()
    {
        List<Num> printees = new ArrayList<>(nums);
        Collections.sort(printees, new Comparator<Num>(){
            @Override
            public int compare(Num o1, Num o2) {
                return o1.currIdx - o2.currIdx;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Num printee : printees) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(printee.num);
        }
        return sb.toString();
    }
    
}
