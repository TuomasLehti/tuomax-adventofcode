package fi.tuomax.adventofcode.year2016.day10;

import java.util.Deque;
import java.util.Map;

public class Bot 
implements Comparable<Bot>
{

    public Integer botNumber = -1;

    private Integer lowGivenTo;

    private Integer highGivenTo;

    private int firstChip = -1;

    public int getFirstChip() 
    {
        return firstChip;
    }

    private int secondChip = -1;

    public Bot(String input)
    {
        String[] parts = input.split(" ");
        botNumber = Integer.valueOf(parts[1]);
        lowGivenTo = Integer.valueOf(parts[6]);
        if (parts[5].equals("output"))
            lowGivenTo += 900;
        highGivenTo = Integer.valueOf(parts[11]);
        if (parts[10].equals("output"))
            highGivenTo += 900;
    }

    public Bot(Integer botNumber)
    {
        this.botNumber = botNumber;
    }

    public void give(Map<Integer, Bot> bots)
    {
        bots.get(lowGivenTo).receive(Math.min(firstChip, secondChip));
        if (bots.get(lowGivenTo).hasTwoChips())
            bots.get(lowGivenTo).give(bots);
        bots.get(highGivenTo).receive(Math.max(firstChip, secondChip));
        if (bots.get(highGivenTo).hasTwoChips())
            bots.get(highGivenTo).give(bots);
    }

    public void receive(int chip)
    {
        if (firstChip == -1)
            firstChip = chip;
        else if (secondChip == -1)
            secondChip = chip;
        else
            throw new IllegalStateException(
                String.format(
                    "Bot %d has too many chips.",
                    botNumber
                )
            );
    }

    public Boolean has(int aChip, int otherChip)
    {
        return
            (firstChip == aChip && secondChip == otherChip) ||
            (firstChip == otherChip && secondChip == aChip);
    }

    public Boolean hasTwoChips()
    {
        return firstChip > -1 && secondChip > -1;
    }

    public Boolean hasOneChip()
    {
        return firstChip > -1;
    }

    public String toString()
    {
        return String.format(
            "%3d: %2d %2d",
            botNumber,
            firstChip,
            secondChip
        );
    }

    @Override
    public int compareTo(Bot o) 
    {
        return this.botNumber.compareTo(o.botNumber);
    }
    
}
