package fi.tuomax.adventofcode.year2022.day21;

import java.util.HashMap;
import java.util.Map;

public class Monkey 
{

    public static Map<String, Monkey> barrel = new HashMap<>();

    public static void addToBarrelFromInput(String aocInput) 
    {
        Monkey monkey = new Monkey(aocInput);
        barrel.put(monkey.name, monkey);
    }

    private String name;

    private Long yells = null;

    private String[] listensTo = null;

    private String operator;

    private Monkey(String aocInput)
    {
        String[] parts = aocInput.split(" |: ");
        name = parts[0];
        if (parts.length == 2) {
            yells = Long.valueOf(parts[1]);
        } else {
            listensTo = new String[2];
            listensTo[0] = parts[1];
            listensTo[1] = parts[3];
            operator = parts[2];
        }
    }

    public Long yell()
    {
        if (yells == null) 
            switch (operator) {
                case "+":    
                    yells = barrel.get(listensTo[0]).yell() + barrel.get(listensTo[1]).yell();
                    break;
                case "-":    
                    yells = barrel.get(listensTo[0]).yell() - barrel.get(listensTo[1]).yell();
                    break;
                case "*":    
                    yells = barrel.get(listensTo[0]).yell() * barrel.get(listensTo[1]).yell();
                    break;
                case "/":    
                    yells = barrel.get(listensTo[0]).yell() / barrel.get(listensTo[1]).yell();
                    break;
            }
        return yells;
    }
    
}
