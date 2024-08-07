package fi.tuomax.adventofcode.year2016.day14;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.commons.MD5;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class OnetimePad_Part2
extends Solver
{

    private static final Logger LOGGER = LoggerFactory.getLogger(OnetimePad.class);

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 14, 2,
            "One-Time Pad", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new StringParser(input);
    }

    @Override
    protected void solve() 
    {
        MD5.clearCache();
        int numOfKeys = parameters.getInt("num_of_keys");
        String salt = ((StringParser) parser).getString();
        int keyIdx = 0;
        int hashIdx = 0;
        while (keyIdx < (numOfKeys)) {
            ConsecutiveCharsRequirement threeReq = new ConsecutiveCharsRequirement(3);
            int three = MD5.getNumber(salt, threeReq, 2017, hashIdx, -1);
            int five = MD5.getNumber(
                salt, 
                new ConsecutiveCharsRequirement(
                    threeReq.getWanted(), 5), 
                2017,
                three + 1, 
                three + 1000
            );
            three++;
            if (five > -1) {
                keyIdx++;
                LOGGER.debug(String.format("Key %d found.", keyIdx));
            }
            hashIdx = three;

        }
        setAnswer(--hashIdx);
    }
    
}

// 20700 too high
