package fi.tuomax.adventofcode.year2017.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnotHasher 
{

    private List<Integer> list = new ArrayList<>();

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

    public void run(Integer length)
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

    public Integer getAnswer()
    {
        return list.get(0) * list.get(1);
    }
    
}
