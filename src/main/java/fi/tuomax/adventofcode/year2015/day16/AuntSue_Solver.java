package fi.tuomax.adventofcode.year2015.day16;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.framework.inputting.InputFactory;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 16:
 * Aunt Sue
 * @see 
 *      <a href="https://adventofcode.com/2015/day/16">
 *      Puzzle on the Advent of Code website.</a>
 */
public abstract class AuntSue_Solver 
extends Solver
{

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new AuntSue_Parser(input);
    }

    @Override
    protected void solve() 
    {
        /* We don't want to interrupt the flow of the program in order to give
         * next solvers the chance to run. */
        Sue ticker = null;
        try {
            ticker = readticker();
        } catch (IOException e) {
            logger.warn("Ticker tape not found!");
            setAnswer(0);
            return;
        }

        List<Sue> sues = ((AuntSue_Parser) parser).getSues();
        for (int i = 0; i < sues.size(); i++) {
            if (equalSues(ticker, sues.get(i))) {
                setAnswer(i + 1);
                break;
            }
        }
    }

    /**
     * In an effort to conceal all and every concievable piece of input from
     * the repository, the ticker tape is downloaded to a file.
     */
    private Sue readticker()
    throws IOException
    {
        return Sue.fromTicker(
                InputFactory.inputFromMetadata(
                    getMetadata(), 
                    "ticker.txt"
                )
        );
    }

    protected abstract Boolean equalSues(Sue one, Sue other);
    
}
