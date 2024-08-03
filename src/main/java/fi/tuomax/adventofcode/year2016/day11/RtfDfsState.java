package fi.tuomax.adventofcode.year2016.day11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Radioisotope Testing Facility from Advent of Code 2016, day 11.
 */
public class RtfDfsState 
extends DfsState
{

    /* 
     * All the microchips and RTGs are stored in this array. Every element
     * has one chip and one RTG, and each pair has one index in the array.
     * The tens place denotes the floor in which the chip of a given element
     * resides, and ones place similarly denotes the RTG.
     * 
     * The actual name of the element doesn't matter. They are also 
     * interchangeable, so if all the pairs are on the same floor and you move
     * them to the next floor, it doesn't matter which pair is moved first.
     * 
     * This might be a bit complicated, but it is necessary, because otherwise
     * a microchip and its corresponding RTG wouldn't stay together when the
     * array is sorted.
     */
    private int[] things;

    public int getRtg(int index)
    {
        return things[index] % 10;
    }

    public int getChip(int index)
    {
        return things[index] / 10;
    }

    public void moveRtgUp(int index)
    {
        things[index]++;
    }

    public void moveRtgDown(int index)
    {
        things[index]--;
    }

    public void moveChipUp(int index)
    {
        things[index] += 10;
    }

    public void moveChipDown(int index)
    {
        things[index] -= 10;
    }

    public void moveThingUp(int index)
    {
        if ((index % 10) == 0)
            moveChipUp((index / 10) - 1);
        else
            moveRtgUp(index - 1);
    }

    public void moveThingDown(int index)
    {
        if ((index % 10) == 0)
            moveChipDown((index / 10) - 1);
        else
            moveRtgDown(index - 1);
    }

    private int elevator = 1;

    public int getElevator() 
    {
        return elevator;
    }

    public RtfDfsState(Integer capacity)
    {
        things = new int[capacity];
    }

    public RtfDfsState(int[] startState) 
    {
        things = Arrays.copyOf(startState, startState.length);
        elevator = 1;
    }

    public RtfDfsState(int elevator, int[] startState, int step)
    {
        things = Arrays.copyOf(startState, startState.length);
        this.elevator = elevator;
        setStep(step);
    }

    @Override
    public Set<DfsState> nextStates() 
    {
        Set<DfsState> nextStates = new HashSet<>();
        int[] onThisFloor = getThingsOnThisFloor();

        for (int thingIdx = 0; thingIdx < onThisFloor.length; thingIdx++) {
            for (int otherIdx = 0; otherIdx < onThisFloor.length; otherIdx++) {
                if (elevator < 4) {
                    elevator++;
                    if (thingIdx == otherIdx) {
                        moveThingUp(onThisFloor[thingIdx]);
                    } else {
                        moveThingUp(onThisFloor[thingIdx]);
                        moveThingUp(onThisFloor[otherIdx]);
                    }
                    if (isSafeState())
                        nextStates.add(new RtfDfsState(elevator, things, getStep() + 1));
                    if (thingIdx == otherIdx) {
                        moveThingDown(onThisFloor[thingIdx]);
                    } else {
                        moveThingDown(onThisFloor[thingIdx]);
                        moveThingDown(onThisFloor[otherIdx]);
                    }
                    elevator--;
                }
                if (elevator > 1) {
                    elevator--;
                    if (thingIdx == otherIdx) {
                        moveThingDown(onThisFloor[thingIdx]);
                    } else {
                        moveThingDown(onThisFloor[thingIdx]);
                        moveThingDown(onThisFloor[otherIdx]);
                    }
                    if (isSafeState())
                        nextStates.add(new RtfDfsState(elevator, things, getStep() + 1));
                    if (thingIdx == otherIdx) {
                        moveThingUp(onThisFloor[thingIdx]);
                    } else {
                        moveThingUp(onThisFloor[thingIdx]);
                        moveThingUp(onThisFloor[otherIdx]);
                    }
                    elevator++;
                }
            }
        }

        return nextStates;
    }

    private int[] getThingsOnThisFloor()
    {
        int[] onThisFloor = new int[things.length * 2];
        int otfIdx = 0;
        for (int thingIdx = 0; thingIdx < things.length; thingIdx++) {
            if (getChip(thingIdx) == elevator)
                onThisFloor[otfIdx++] = (thingIdx + 1) * 10;
            if (getRtg(thingIdx) == elevator)
                onThisFloor[otfIdx++] = (thingIdx + 1);
        }
        return Arrays.copyOf(onThisFloor, otfIdx);
    }

    public boolean isSafeState()
    {
        for (int thingIdx = 0; thingIdx < things.length; thingIdx++) {
            if (getChip(thingIdx) == getRtg(thingIdx))
                continue;
            for (int otherIdx = 0; otherIdx < things.length; otherIdx++) {
                if (thingIdx != otherIdx && 
                        getChip(thingIdx) == getRtg(otherIdx))
                    return false;
            }
        }
        return true;
    }

    @Override
    public Boolean isTargetState() 
    {
        for (int pair : things)
            if ((pair % 10) != 4 || (pair / 10) != 4)
                return false;
        return true;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof RtfDfsState)) return false;
        RtfDfsState other = (RtfDfsState) o;
        int[] arr = Arrays.copyOf(things, things.length);
        Arrays.sort(arr);
        int[] otherArr = Arrays.copyOf(other.things, other.things.length);
        Arrays.sort(otherArr);
        return (this.elevator == other.elevator) &&
            Arrays.equals(arr, otherArr);
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        int pow = 1;
        int[] arr = Arrays.copyOf(things, things.length);
        Arrays.sort(arr);
        for (int i : arr) {
            hash += (i / 10) * pow;
            pow *= 4;
            hash += (i % 10) * pow;
            pow *= 4;
        }
        hash += elevator * pow;
        return hash;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(elevator);
        sb.append(",");
        for (int pair : things) {
            sb.append(pair);
            sb.append(",");
        }
        return sb.toString();


    }
    
}
