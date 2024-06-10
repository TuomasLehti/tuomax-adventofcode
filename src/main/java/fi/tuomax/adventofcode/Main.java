package fi.tuomax.adventofcode;

import java.util.List;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import fi.tuomax.adventofcode.framework.LatestRunner;
import fi.tuomax.adventofcode.framework.Printer;
import fi.tuomax.adventofcode.framework.Solver;
import fi.tuomax.adventofcode.framework.Year;
import fi.tuomax.adventofcode.y2015.d01.NotQuiteLisp_Part1;
import fi.tuomax.adventofcode.y2015.d01.NotQuiteLisp_Part2;
import fi.tuomax.adventofcode.y2015.d02.IWasToldThereWouldBeNoMath_Part1;
import fi.tuomax.adventofcode.y2015.d02.IWasToldThereWouldBeNoMath_Part2;

public class Main 
{

    public static void main(String[] args) 
    {
        AnsiConsole.systemInstall();

        System.out.print("\n".repeat(2));
        System.out.println(Ansi.ansi().fgBright(Ansi.Color.WHITE).a("Tuomax's Advent of Code Framework v. 15.0").reset());
        System.out.print("\n".repeat(2));

        Year year = new Year();
        year.addSolver(new NotQuiteLisp_Part1());
        year.addSolver(new NotQuiteLisp_Part2());
        year.addSolver(new IWasToldThereWouldBeNoMath_Part1());
        year.addSolver(new IWasToldThereWouldBeNoMath_Part2());

        LatestRunner runner = new LatestRunner();
        List<List<Solver>> runned = runner.run(Year.latestAddition, year);
        Printer printer = new Printer();
        printer.print(runned);
        AnsiConsole.systemUninstall();
    }
    
}
