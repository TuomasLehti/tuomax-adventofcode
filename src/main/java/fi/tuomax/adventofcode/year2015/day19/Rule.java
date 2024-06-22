package fi.tuomax.adventofcode.year2015.day19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A replacement rule for the molecule generator.
 */
public class Rule 
implements Iterable<String>
{

    private String replacee;

    public String getReplacee() {
        return replacee;
    }

    private List<String> replacements = new ArrayList<>();

    public Rule(String replacee)
    {
        this.replacee = replacee;
    }

    public void addReplacement(String replacement)
    {
        replacements.add(replacement);
    }

    @Override
    public Iterator<String> iterator() {
        return replacements.iterator();
    }

}
