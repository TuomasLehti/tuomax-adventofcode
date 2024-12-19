package fi.tuomax.adventofcode.year2024.day18;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class Coordinatess_Parser 
extends Parser
{
    public Coordinatess_Parser(List<String> input)
    {
        super(input);
    }

    private List<Coordinates> coords = new ArrayList<>();

    public List<Coordinates> getCoords() 
    {
        return coords;
    }

    private Pattern pattern = Pattern.compile("(\\d+,\\d+)");

    @Override
    public void parse() 
    {
        for (String line : input) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                coords.add(new Coordinates(
                    Long.valueOf(matcher.group(0).split(",")[0]),
                    Long.valueOf(matcher.group(0).split(",")[1])
                ));
            }
        }
    }
    
}
