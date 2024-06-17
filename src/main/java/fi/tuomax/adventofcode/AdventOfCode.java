package fi.tuomax.adventofcode;

import org.fusesource.jansi.Ansi;

import fi.tuomax.adventofcode.framework.printing.Printer;
import fi.tuomax.adventofcode.framework.printing.Results;
import fi.tuomax.adventofcode.framework.running.LatestRunner;
import fi.tuomax.adventofcode.framework.running.Runner;
import fi.tuomax.adventofcode.framework.running.YearRunner;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.storing.Year;
import fi.tuomax.adventofcode.year2015.day01.NotQuiteLisp_Part1;
import fi.tuomax.adventofcode.year2015.day01.NotQuiteLisp_Part2;
import fi.tuomax.adventofcode.year2015.day02.IWasToldThereWouldBeNoMath_Part1;
import fi.tuomax.adventofcode.year2015.day02.IWasToldThereWouldBeNoMath_Part2;
import fi.tuomax.adventofcode.year2015.day03.PerfectlySphericalHousesInAVacuum_Part1;
import fi.tuomax.adventofcode.year2015.day03.PerfectlySphericalHousesInAVacuum_Part2;
import fi.tuomax.adventofcode.year2015.day04.TheIdealStockingStuffer_Part1;
import fi.tuomax.adventofcode.year2015.day04.TheIdealStockingStuffer_Part2;
import fi.tuomax.adventofcode.year2015.day05.DoesntHeHaveInternElvesForThis_Part1;
import fi.tuomax.adventofcode.year2015.day05.DoesntHeHaveInternElvesForThis_Part2;
import fi.tuomax.adventofcode.year2015.day06.lightranges.ProbablyAFireHazard_LightRanges_Part1;
import fi.tuomax.adventofcode.year2015.day06.lightranges.ProbablyAFireHazard_LightRanges_Part2;
import fi.tuomax.adventofcode.year2015.day06.singlelights.ProbablyAFireHazard_SingleLights_Part1;
import fi.tuomax.adventofcode.year2015.day06.singlelights.ProbablyAFireHazard_SingleLights_Part2;
import fi.tuomax.adventofcode.year2015.day07.SomeAssemblyRequired_Part1;
import fi.tuomax.adventofcode.year2015.day07.SomeAssemblyRequired_Part2;
import fi.tuomax.adventofcode.year2015.day08.Matchsticks_Part1;
import fi.tuomax.adventofcode.year2015.day08.Matchsticks_Part2;
import fi.tuomax.adventofcode.year2015.day09.AllInASingleNight_Part1;
import fi.tuomax.adventofcode.year2015.day09.AllInASingleNight_Part2;
import fi.tuomax.adventofcode.year2015.day10.ElvesLookElvesSay_Part1;
import fi.tuomax.adventofcode.year2015.day10.ElvesLookElvesSay_Part2;
import fi.tuomax.adventofcode.year2015.day11.CorporatePolicy_Part1;
import fi.tuomax.adventofcode.year2015.day11.CorporatePolicy_Part2;
import fi.tuomax.adventofcode.year2015.day12.JSAbacusFrameworkIo_Part1;
import fi.tuomax.adventofcode.year2015.day12.JSAbacusFrameworkIo_Part2;

public class AdventOfCode 
{

    private Year year = new Year();

    public void run(Settings settings)
    {
        printWelcome();
        addSolvers();
        Runner runner = manufactureRunner(settings);
        Metadata metadata = settings.metadata() != null ? settings.metadata() : Year.latestAddition;
        Results results = runner.run(metadata, year);
        Printer printer = manufacturePrinter();
        printer.print(settings, results);
    }

    private Printer manufacturePrinter() {
        return new Printer();
    }

    private Runner manufactureRunner(Settings settings) {
        if (settings.runMode() == RunMode.LATEST)
            return new LatestRunner();
        else if (settings.runMode() == RunMode.YEAR)
            return new YearRunner();
        return null;
    }

    private void addSolvers() {
        /* day 1 */
        year.addSolver(new NotQuiteLisp_Part1());
        year.addSolver(new NotQuiteLisp_Part2());
        /* day 2 */
        year.addSolver(new IWasToldThereWouldBeNoMath_Part1());
        year.addSolver(new IWasToldThereWouldBeNoMath_Part2());
        /* day 3 */
        year.addSolver(new PerfectlySphericalHousesInAVacuum_Part1());
        year.addSolver(new PerfectlySphericalHousesInAVacuum_Part2());
        /* day 4 */
        year.addSolver(new TheIdealStockingStuffer_Part1());
        year.addSolver(new TheIdealStockingStuffer_Part2());
        /* day 5 */
        year.addSolver(new DoesntHeHaveInternElvesForThis_Part1());
        year.addSolver(new DoesntHeHaveInternElvesForThis_Part2());
        /* day 6 */
        year.addSolver(new ProbablyAFireHazard_LightRanges_Part1());
        year.addSolver(new ProbablyAFireHazard_LightRanges_Part2());
        year.addSolver(new ProbablyAFireHazard_SingleLights_Part1());
        year.addSolver(new ProbablyAFireHazard_SingleLights_Part2());
        /* day 7 */
        year.addSolver(new SomeAssemblyRequired_Part1());
        year.addSolver(new SomeAssemblyRequired_Part2());
        /* day 8 */
        year.addSolver(new Matchsticks_Part1());
        year.addSolver(new Matchsticks_Part2());
        /* day 9 */
        year.addSolver(new AllInASingleNight_Part1());
        year.addSolver(new AllInASingleNight_Part2());
        /* day 10 */
        year.addSolver(new ElvesLookElvesSay_Part1());
        year.addSolver(new ElvesLookElvesSay_Part2());
        /* day 11 */
        year.addSolver(new CorporatePolicy_Part1());
        year.addSolver(new CorporatePolicy_Part2());
        /* day 12 */
        year.addSolver(new JSAbacusFrameworkIo_Part1());
        year.addSolver(new JSAbacusFrameworkIo_Part2());
    }

    private void printWelcome() {
        System.out.print("\n".repeat(2));
        System.out.println(Ansi.ansi().fgBright(Ansi.Color.WHITE).a("Tuomax's Advent of Code Framework v. 15.0").reset());
        System.out.print("\n".repeat(2));
    }

    
}
