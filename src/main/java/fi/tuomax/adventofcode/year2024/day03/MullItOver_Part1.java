package fi.tuomax.adventofcode.year2024.day03;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringListParser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Solves Advent of Code 2024, day 3, part 1:
 * Mull It Over.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/3">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class MullItOver_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 3, 1,
            "Mull It Over", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new StringListParser(input);
    }

    @Override
    protected void solve()
    {
        Pattern mul = Pattern.compile("(mul\\(\\d+,\\d+\\))");
        String input = String.join("", ((StringListParser) parser).getStrings());
        Matcher matcher = mul.matcher(input);

        Long result = 0L;
        while (matcher.find()) {
            String[] parts = matcher.group(0).split("\\(|,|\\)");
            Long one = Long.valueOf(parts[1]);
            Long other = Long.valueOf(parts[2]);
            Long product = one * other;
            result += product;
        }

        setAnswer(result);
    }

}
// 28357231 too low
// 188116424
