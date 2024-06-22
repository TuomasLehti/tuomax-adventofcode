package fi.tuomax.adventofcode.year2015.day16;

import java.util.HashMap;
import java.util.List;

public class Sue 
{
    
    private HashMap<Compound, Integer> compounds = new HashMap<>();

    public static Sue fromInput(String input)
    {
        Sue sue = new Sue();
        String[] parts = input.split(": |, ");
        for (int i = 1; i < parts.length; i += 2) {
            sue.setAmount(Compound.fromString(parts[i]), Integer.valueOf(parts[i + 1]));
        }
        return sue;
    }

    /**
     * In an effort to conceal all and every concievable piece of input from
     * the repository, the ticker tape is downloaded to a file.
     */
    public static Sue fromTicker(List<String> ticker)
    {
        Sue sue = new Sue();
        for (String line : ticker) {
            sue.setAmount(
                Compound.fromString(line.split(": ")[0]), 
                Integer.valueOf(line.split(": ")[1]));
        }
        return sue;        
    }

    private void setAmount(Compound compound, Integer amount)
    {
        compounds.put(compound, amount);
    }

    public Integer getAmount(Compound compound) 
    {
        return compounds.get(compound);
    }

    public Boolean hasCompound(Compound compound)
    {
        return compounds.containsKey(compound);
    }

    public Boolean amountEqualsOrIsMissing(Compound compound, Integer amount)
    {
        /* A missing compound isn't zero, it just isn't remembered. */
        return (!compounds.containsKey(compound)) || 
                    (compounds.get(compound).equals(amount));
    }

}
