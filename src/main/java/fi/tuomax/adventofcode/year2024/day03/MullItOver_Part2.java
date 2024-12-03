package fi.tuomax.adventofcode.year2024.day03;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Solves Advent of Code 2024, day 3, part 2:
 * Mull It Over.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/3">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class MullItOver_Part2
extends MullItOver_Part1
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 3, 2,
            "Mull It Over", ""
        );
    }

    @Override
    protected Long scan(String input)
    {

        String mulStr = "mul\\(\\d+,\\d+\\)";
        String dodoStr = "do\\(\\)";
        String dontStr = "don't\\(\\)";

        Pattern pat = Pattern.compile(String.format(
                "(%s|%s|%s)", mulStr, dodoStr, dontStr));
        Matcher matcher = pat.matcher(input);

        Long result = 0L;
        Boolean enabled = true;
        while (matcher.find()) {
            String group = matcher.group(0);
            System.out.println(group);
            if (group.matches(dodoStr))
                enabled = true;
            else if (group.matches(dontStr))
                enabled = false;
            else if (group.matches(mulStr) && enabled) 
                result += multiply(group);
        }
        return result;
    }
    

}
