package fi.tuomax.adventofcode.year2024.day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class LinenLayout_Parser
extends Parser
{

    private List<String> patterns;

    public List<String> getPatterns() 
    {
        return patterns;
    }

    private List<String> designs = new ArrayList<>();

    public List<String> getDesigns() 
    {
        return designs;
    }

    public LinenLayout_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        final int PATTERNS = 0;
        final int DESIGNS = 1;
        int state = PATTERNS;

        for (String line : input) {
            if (line.isEmpty()) {
                state++;
                continue;
            }
            if (state == PATTERNS) {
                patterns = Arrays.asList(line.split(", "));
            } else if (state == DESIGNS) {
                designs.add(line);
            }
        }

        Collections.sort(patterns, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) 
            {
                return o2.length() - o1.length();
            }
        });
    }

}
