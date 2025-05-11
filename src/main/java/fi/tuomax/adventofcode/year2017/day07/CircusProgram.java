package fi.tuomax.adventofcode.year2017.day07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO: tidy it up
 */

public class CircusProgram 
{

    private String name;
    
    public String getName() 
    {
        return name;
    }

    private Integer weight;

    public Integer getWeight() 
    {
        return weight;
    }

    private CircusProgram parent;

    public CircusProgram getParent() 
    {
        return parent;
    }

    private void setParent(CircusProgram parent) 
    {
        this.parent = parent;
    }

    private Set<CircusProgram> children = new HashSet<>();

    public CircusProgram(String name, Integer weight)
    {
        this.name = name;
        this.weight = weight;
    }

    public void addChild(CircusProgram child)
    {
        children.add(child);
        child.setParent(this);
    }
    
    public Integer getTowerWeight()
    {
        Integer total = weight;
        for (CircusProgram child : children) {
            total += child.getTowerWeight();
        }
        return total;
    }

    public Integer getWeightOfChildren()
    {
        Integer total = 0;
        for (CircusProgram child : children) {
            total += child.getWeight();
        }
        return total;
    }

    public Integer getNumOfChildren()
    {
        return children.size();
    }

    public void countChildren()
    {
        System.out.println(name + ": " + isBalanced() + " " + children.size());
        for (CircusProgram child : children) {
            child.countChildren();
        }

    }

    public Boolean isBalanced()
    {
        for (CircusProgram one : children) {
            for (CircusProgram other : children) {
                if (!one.getTowerWeight().equals(other.getTowerWeight())) {
                    return false;
                }
            }
        }
        return true;
    }

    public CircusProgram getUnbalancedChild()
    {
        List<Integer> weights = new ArrayList<>();
        for (CircusProgram child : children) {
            weights.add(child.getTowerWeight());
        }
        Collections.sort(weights);
        Integer different = 0;
        if (!weights.get(0).equals(weights.get(1))) {
            different = weights.get(0);
        } else {
            different = weights.get(weights.size() - 1);
        }
        for (CircusProgram child : children) {
            if (child.getTowerWeight().equals(different)) {
                return child;
            }
            weights.add(child.getTowerWeight());
        }
        return null;
    }

    public Integer balance()
    {
        if (!isBalanced()) {
            /*
            System.out.println("---" + getName() + "---");
            for (CircusProgram child : children) {
                System.out.println(child.getName() + " " + child.getTowerWeight());
            }
                */
            CircusProgram unbalancedChild = getUnbalancedChild();
            if (!unbalancedChild.isBalanced()) {
                return unbalancedChild.balance();
            } else {
                int target = 0;
                for (CircusProgram child : children) {
                    if (!child.getTowerWeight().equals(unbalancedChild.getTowerWeight())) {
                        target = child.getTowerWeight();
                    }
                }
                return target - unbalancedChild.getWeightOfChildren();
            }
        }
        return 0;
    }

    
}
