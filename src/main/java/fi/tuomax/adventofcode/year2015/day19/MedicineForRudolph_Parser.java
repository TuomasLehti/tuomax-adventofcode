package fi.tuomax.adventofcode.year2015.day19;

import java.util.List;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class MedicineForRudolph_Parser 
extends Parser
{

    public MedicineForRudolph_Parser(List<String> input) 
    {
        super(input);
    }

    private enum ParseState { REPLACEMENTS, MOLECULE };

    private ParseState state = ParseState.REPLACEMENTS;

    private String molecule;

    public String getMolecule() {
        return molecule;
    }

    @Override
    public void parse() 
    {
        for (String token : input) {
            if (token.isEmpty()) {
                state = ParseState.MOLECULE;
                continue;
            }
            switch (state) {
                case MOLECULE:
                    parseMolecule(token);
                    break;
                case REPLACEMENTS:
                    parseReplacement(token);
                    break;
            }
        }
    }

    private void parseMolecule(String token)
    {
        this.molecule = token;
    }

    private void parseReplacement(String token)
    {
        String[] parts = token.split(" => ");
        if (!Rules.ruleAvailable(parts[0])) {
            Rules.rules.put(parts[0], new Rule(parts[0]));
        }
        Rules.rules.get(parts[0]).addReplacement(parts[1]);
    }

    
}
