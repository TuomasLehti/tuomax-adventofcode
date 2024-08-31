package fi.tuomax.adventofcode.year2022.day02;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Solves Advent of Code 2022, day 2, part 2:
 * Rock Paper Scissors.</p>
 * 
 * <p>This solver is basically a factory class. The actual solving logic is in
 * the parent class.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/2">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class RockPaperScissors_Part2
extends RockPaperScissors_Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 2, 2,
            "Rock Paper Scissors", ""
        );
    }

    @Override
    protected Map<String, Integer> manufacturePointsTable() 
    {
        final String OPP_ROCK = "A";
        final String OPP_PAPER = "B";
        final String OPP_SCISSORS = "C";
        final String LOSE = "X";
        final String DRAW = "Y";
        final String WIN = "Z";

        final Integer ROCK_PTS = 1;
        final Integer PAPER_PTS = 2;
        final Integer SCISSORS_PTS = 3;

        final Integer LOSE_PTS = 0;
        final Integer DRAW_PTS = 3;
        final Integer WIN_PTS = 6;

        Map<String, Integer> points = new HashMap<>();

        points.put(OPP_ROCK + " " + LOSE,           SCISSORS_PTS + LOSE_PTS);
        points.put(OPP_ROCK + " " + DRAW,           ROCK_PTS + DRAW_PTS);
        points.put(OPP_ROCK + " " + WIN,            PAPER_PTS + WIN_PTS);

        points.put(OPP_PAPER + " " + LOSE,          ROCK_PTS + LOSE_PTS);
        points.put(OPP_PAPER + " " + DRAW,          PAPER_PTS + DRAW_PTS);
        points.put(OPP_PAPER + " " + WIN,           SCISSORS_PTS + WIN_PTS);

        points.put(OPP_SCISSORS + " " + LOSE,       PAPER_PTS + LOSE_PTS);
        points.put(OPP_SCISSORS + " " + DRAW,       SCISSORS_PTS + DRAW_PTS);
        points.put(OPP_SCISSORS + " " + WIN,        ROCK_PTS + WIN_PTS);
        
        return points;
    }
}
