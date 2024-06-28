package fi.tuomax.adventofcode.year2016.day06;

import java.util.Collections;
import java.util.List;
import fi.tuomax.adventofcode.commons.CharacterFrequency;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class SignalsAndNoise_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 6, 2,
            "Signals and Noise", ""
        );
    }


    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new SignalsAndNoise_Parser(input);
    }

    @Override
    protected void solve() 
    {
        StringBuilder result = new StringBuilder();
        for (String line : (SignalsAndNoise_Parser) parser) {
            List<CharacterFrequency> frequencies = CharacterFrequency.count(line);
            Collections.sort(frequencies, CharacterFrequency.AMOUNT_ASCENDING_COMPARATOR);
            result.append(frequencies.get(0).c());
        }
        setAnswer(result.toString());
    }
    
}
