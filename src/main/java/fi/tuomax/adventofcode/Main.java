package fi.tuomax.adventofcode;

import fi.tuomax.adventofcode.framework.LatestRunner;
import fi.tuomax.adventofcode.framework.Year;
import fi.tuomax.adventofcode.y2015.d01.NotQuiteLisp_Part1;
import fi.tuomax.adventofcode.y2015.d01.NotQuiteLisp_Part2;

public class Main 
{

    public static void main(String[] args) 
    {
        Year year = new Year();
        year.addSolver(new NotQuiteLisp_Part1());
        year.addSolver(new NotQuiteLisp_Part2());

        LatestRunner runner = new LatestRunner();
        runner.run(Year.latestAddition, year);
    }
    
}
