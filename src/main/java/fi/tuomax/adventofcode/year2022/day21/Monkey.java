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

    private Monkey listensTo(int idx)
    {
        return barrel.get(listensTo[idx]);
    }

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

    private Monkey(String name, String listensTo0, String listensTo1, String operator)
    {
        this.name = name;
        this.operator = operator;
        listensTo = new String[2];
        this.listensTo[0] = listensTo0;
        this.listensTo[1] = listensTo1;
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

    public String toString()
    {
        if (yells != null) return name;
        return (String.format(
            "( %s %s %s )",
            barrel.get(listensTo[0].toString()),
            name.equals("root") ? "=" : operator,
            barrel.get(listensTo[1].toString())
        ));
    }

    private Boolean hasHuman()
    {
        if (isHuman()) return true;
        if (listensTo == null) return false;
        return listensTo(0).hasHuman() || listensTo(1).hasHuman();
    }

    private Boolean isHuman()
    {
        return name.equals("humn");
    }

    public Long solveEquationForHuman()
    {
        if (barrel.get(listensTo[1]).hasHuman()) {
            String tmp = listensTo[0];
            listensTo[0] = listensTo[1];
            listensTo[1] = tmp;
        }
        Long result = listensTo(1).yell();

        Monkey monkey = listensTo(0);
        while (!monkey.isHuman()) {
            System.out.println(toString());
            Monkey moveToOtherSide = null;
            Monkey becomeThisSide = null;
            if (monkey.listensTo(0).hasHuman()) {
                moveToOtherSide = monkey.listensTo(1);
                becomeThisSide = monkey.listensTo(0);
                switch (monkey.operator) {
                    case "+":    // x + a = b => x = b - a
                        result -= monkey.listensTo(0).yell();
                        break;
                    case "-":    // x - a = b
                        break;
                    case "*":    // x * a = b => x = b / a
                        break;
                    case "/":    // x / a = b
                        break;
                }
                } else {
                moveToOtherSide = monkey.listensTo(0);
                becomeThisSide = monkey.listensTo(1);
                switch (monkey.operator) {
                    case "+":    // a + x = b => x = b - a
                        result -= monkey.listensTo(0).yell();
                        break;
                    case "-":    // a - x = b
                        break;
                    case "*":    // a * x = b
                        break;
                    case "/":    // a / x = b
                        break;
                }
                }
            String newOperator = "";
            switch (monkey.operator) {
                case "+":    
                    result -= moveToOtherSide.yell();
                    newOperator = "-";
                    break;
                case "-":    
                    result += moveToOtherSide.yell();
                    newOperator = "+";
                    break;
                case "*":   
                    result /= moveToOtherSide.yell(); 
                    newOperator = "/";
                    break;
                case "/":    
                    result *= moveToOtherSide.yell();
                    newOperator = "*";
                    break;
            }
            Monkey newOtherSide = new Monkey(
                String.format("%d", System.currentTimeMillis()),
                listensTo[1],
                moveToOtherSide.name,
                newOperator
            );
            barrel.put(newOtherSide.name, newOtherSide);
            listensTo[1] = newOtherSide.name;
            listensTo[0] = becomeThisSide.name;
            monkey = listensTo(0);
        }
        System.out.println(toString());
        return result;
    }

    public Long solveEquation(Long result)
    {
        if (isHuman()) return result;
        if (listensTo(0).hasHuman()) {
            // x on left side
            switch (operator) {
                case "+":    // x + a = b => x = b - a
                    result -= listensTo(1).yell();
                    break;
                case "-":    // x - a = b => x = b + a
                    result += listensTo(1).yell();
                    break;
                case "*":    // x * a = b => x = b / a
                    result /= listensTo(1).yell();
                    break;
                case "/":    // x / a = b => x = b * a
                    result *= listensTo(1).yell();
                    break;
            }
            return listensTo(0).solveEquation(result);
        } else {
            // x on right side
            switch (operator) {
                case "+":    // a + x = b => x = b - a
                    result -= listensTo(0).yell();
                    break;
                case "-":    // a - x = b => x = a - b
                    result = listensTo(0).yell() - result;
                    break;
                case "*":    // a * x = b => x = b / a
                    result /= listensTo(0).yell();
                    break;
                case "/":    // a / x = b => a = b * x => a / b = x
                    result = listensTo(0).yell() / result;
                    break;
            }
            return listensTo(1).solveEquation(result);
        }
    }

    public Long solveEquationStart() 
    {
        if (listensTo(1).hasHuman()) {
            return listensTo(1).solveEquation(listensTo(0).yell());
        } else {
            return listensTo(0).solveEquation(listensTo(1).yell());
        }
    }
    
}
// 7243227128687 too high
// 1728550034102 too low
// 3560324848168