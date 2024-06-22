package fi.tuomax.adventofcode.year2015.day19;

import java.util.Set;
import java.util.HashSet;

/**
 * Represents a molecule, which is a collection of elements.
 */
public class Molecule 
{

    /** This is the molecule. */
    private String molecule;

    public String getMolecule() {
        return molecule;
    }

    public Molecule(String molecule)
    {
        this.molecule = molecule;
    }

    /**
     * Generates all possible molecules from this molecule.
     * @return
     *      A list of possible molecules.
     */
    public Set<String> generate()
    {
        Set<String> result = new HashSet<>();
        Integer idx = 0;
        while (idx < molecule.length()) {
            String left = molecule.substring(0, idx);
            String right = molecule.substring(idx);
            if (Rules.ruleAvailable(right)) {
                Rule rule = Rules.getRule(right);
                for (String replacement : rule) 
                    result.add(
                            left + replacement + right.substring(rule.getReplacee().length())
                        );
                idx += rule.getReplacee().length();
            } else {
                idx++;
            }
        }
        return result;
    }

}
