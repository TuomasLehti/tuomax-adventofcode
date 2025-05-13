package fi.tuomax.adventofcode.year2017.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KnotHasher 
{

    private List<Integer> list = new ArrayList<>();

    public List<Integer> getSparseHash() 
    {
        return list;
    }

    private Integer currentPosition = 0;

    private Integer skipSize = 0;

    public KnotHasher(Integer lengthOfList)
    {
        for (int i = 0; i < lengthOfList; i++) {
            list.add(i);
        }
    }

    private List<Integer> getSublist(Integer start, Integer length)
    {
        if ((start + length) <= list.size()) {
            return list.subList(start, start + length);
        } else {
            List<Integer> subList = new ArrayList<>();
            subList.addAll(list.subList(start, list.size()));
            subList.addAll(list.subList(0, length - subList.size()));
            return subList;
        }
    }

    private void setSubList(Integer start, List<Integer> subList)
    {
        List<Integer> newList = new ArrayList<>();
        if ((start + subList.size()) <= list.size()) {
            newList.addAll(list.subList(0, start));
            newList.addAll(subList);
            newList.addAll(list.subList(start + subList.size(), list.size()));
        } else {
            Integer lastIndex = (start + subList.size()) % list.size();
            Integer firstIndexOfSubList = subList.size() - lastIndex;
            newList.addAll(subList.subList(firstIndexOfSubList, subList.size()));
            newList.addAll(list.subList(lastIndex, start));
            newList.addAll(subList.subList(0, firstIndexOfSubList));
        }
        list = newList;
    }

    public void runRound(Integer length)
    {
        if (length > 1) {
            List<Integer> subList = getSublist(currentPosition, length);
            Collections.reverse(subList);
            setSubList(currentPosition, subList);
        } else if (length == list.size()) {

        }
        currentPosition += length + skipSize;
        currentPosition %= list.size();
        skipSize++;
    }

    /**
     * Hashing a list of integers is only applicable for part 1, which is why 
     * only one round is calculated.
     * @param lengths
     */
    public void hashIntegers(List<Integer> lengths)
    {
        for (Integer length : lengths) {
            runRound(length);
        }
    }

    public void hashString(String string)
    {
        List<Integer> lengths = new ArrayList<>();
        for (char c : string.toCharArray()) {
            lengths.add((int) c);
        }
        lengths.addAll(Arrays.asList(new Integer[]{17, 31, 73, 47, 23}));

        for (int i = 0; i < 64; i++) {
            hashIntegers(lengths);
        }
    }

    public String getDenseHash()
    {
        List<Integer> denseHash = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            int densedigit = list.get(i * 16);
            for (int j = 1; j < 16; j++) {
                densedigit ^= list.get(i * 16 + j);
            }
            denseHash.add(densedigit);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer digit : denseHash) {
            if (digit < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(digit));
        }
        return sb.toString();
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(i);
        }
        return sb.toString();
    }

}
