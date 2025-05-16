package fi.tuomax.adventofcode.year2017.day16;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.Arrays;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * <p>Solves Advent of Code 2017, day 16, part 1:
 * Permutation Promenade.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/16">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class PermutationPromenade_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 16, 1,
            "Permutation Promenade", ""
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
        char[] danceFloor = getParamStr("dancefloor").toCharArray();
        String[] moves = ((StringParser) parser).getString().split(",");
        for (String move : moves) {
            LoggerFactory.getLogger(getClass()).trace(new String(danceFloor));
            if (move.startsWith("s")) {
                spin(move, danceFloor);
            } else if (move.startsWith("x")) {
                exchange(move, danceFloor);
            } else if (move.startsWith("p")) {
                partner(move, danceFloor);
            } else {
                LoggerFactory.getLogger(getClass()).warn("Unknown move: " + move);
            }
        }
        LoggerFactory.getLogger(getClass()).trace(new String(danceFloor));
        setAnswer(new String(danceFloor));
    }

    private void spin(String move, char[] danceFloor) 
    {
        int amount = Integer.valueOf(move.substring(1));
        int index = danceFloor.length - amount;
        char[] oldEnding = Arrays.copyOfRange(danceFloor, index, danceFloor.length);
        char[] oldBeginning = Arrays.copyOfRange(danceFloor, 0, index);
        System.arraycopy(oldEnding, 0, danceFloor, 0, oldEnding.length);
        System.arraycopy(oldBeginning, 0, danceFloor, oldEnding.length, oldBeginning.length);
    }

    private void exchange(String move, char[] danceFloor) 
    {
        int from = Integer.valueOf(move.substring(1, move.indexOf("/")));
        int to = Integer.valueOf(move.substring(move.indexOf("/") + 1));
        char temp = danceFloor[from];
        danceFloor[from] = danceFloor[to];
        danceFloor[to] = temp;
    }

    private void partner(String move, char[] danceFloor) 
    {
        int from = new String(danceFloor).indexOf(move.substring(1, 2));
        int to = new String(danceFloor).indexOf(move.substring(3));
        char temp = danceFloor[from];
        danceFloor[from] = danceFloor[to];
        danceFloor[to] = temp;
    }

}