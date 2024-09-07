package fi.tuomax.adventofcode.year2022.day11;

import java.util.ArrayList;
import java.util.List;

public class Monkey 
implements Comparable<Monkey>
{

    private Integer number;

    public Integer getNumber() 
    {
        return number;
    }

    private List<Long> items = new ArrayList<>();

    private String operation;

    private String firstOperand;

    private String secondOperand;

    private Integer divisibilityTest;

    public Integer getDivisibilityTest() 
    {
        return divisibilityTest;
    }

    private Integer throwsToOnTrue;

    private Integer throwsToOnFalse;

    private Long itemsInspected = 0L;

    public Long getItemsInspected() 
    {
        return itemsInspected;
    }

    /**
     * Constructs a monkey.
     * @param aocInput
     *      The five lines of input that define this monkey.
     */
    public Monkey(List<String> aocInput)
    {
        number = Integer.valueOf(aocInput.get(0).split(" |:")[1]);
        parseItems(aocInput.get(1));
        firstOperand = aocInput.get(2).strip().split(" ")[3];
        operation = aocInput.get(2).strip().split(" ")[4];
        secondOperand = aocInput.get(2).strip().split(" ")[5];
        divisibilityTest = Integer.valueOf(aocInput.get(3).strip().split(" ")[3]);
        throwsToOnTrue = Integer.valueOf(aocInput.get(4).strip().split(" ")[5]);
        throwsToOnFalse = Integer.valueOf(aocInput.get(5).strip().split(" ")[5]);
    }

    private void parseItems(String input) 
    {
        String[] parts = input.split(": |, ");
        for (int i = 1; i < parts.length; i++) 
            items.add(Long.valueOf(parts[i]));
    }

    public void turn(List<Monkey> barrel, WorryReliever reliever)
    {
        while (!items.isEmpty()) {
            itemsInspected++;
            Long item = items.get(0);
            items.remove(0);
//            System.out.println(String.format("Monkey %d inspects item %d.", number, item));
            item = calculateNewWorryLevel(item);
            item = reliever.relieve(item);
            throwItem(item, barrel);
        }
    }

    private Long calculateNewWorryLevel(Long oldWorryLevel)
    {
        Long first = 
            isNumber(firstOperand) ? 
            Integer.valueOf(firstOperand) : 
            oldWorryLevel;
        Long second = 
            isNumber(secondOperand) ? 
            Integer.valueOf(secondOperand) : 
            oldWorryLevel;
        return
            operation.equals("*") ?
            first * second :
            first + second;
    }

    private Boolean isNumber(String s)
    {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void throwItem(Long item, List<Monkey> barrel) 
    {
        Integer recipient =
            (item % divisibilityTest) == 0 ?
            throwsToOnTrue :
            throwsToOnFalse;
        barrel.get(recipient).receive(item);
    }

    private void receive(Long item) 
    {
        items.add(item);
    }

    public Object getItemsAsString() 
    {
        StringBuilder sb = new StringBuilder();
        for (Long item : items) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(item);
        }
        return String.format("Monkey %d: %s", number, sb.toString());
    }

    @Override
    public int compareTo(Monkey o) 
    {
        return this.itemsInspected.compareTo(o.itemsInspected);
    }

    
}
