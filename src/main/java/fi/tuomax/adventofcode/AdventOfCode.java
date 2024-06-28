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
import fi.tuomax.adventofcode.year2015.day13.KnightsOfTheDinnerTable_Part1;
import fi.tuomax.adventofcode.year2015.day13.KnightsOfTheDinnerTable_Part2;
import fi.tuomax.adventofcode.year2015.day14.ReindeerOlympics_Part1;
import fi.tuomax.adventofcode.year2015.day14.ReindeerOlympics_Part2;
import fi.tuomax.adventofcode.year2015.day15.ScienceForHungryPeople_Part1;
import fi.tuomax.adventofcode.year2015.day15.ScienceForHungryPeople_Part2;
import fi.tuomax.adventofcode.year2015.day16.AuntSue_Part1;
import fi.tuomax.adventofcode.year2015.day16.AuntSue_Part2;
import fi.tuomax.adventofcode.year2015.day17.NoSuchThingAsTooMuch_Part1;
import fi.tuomax.adventofcode.year2015.day17.NoSuchThingAsTooMuch_Part2;
import fi.tuomax.adventofcode.year2015.day18.LikeAGifForYourYard_Part1;
import fi.tuomax.adventofcode.year2015.day18.LikeAGifForYourYard_Part2;
import fi.tuomax.adventofcode.year2015.day19.MedicineForRudolph_Part1;
import fi.tuomax.adventofcode.year2015.day19.MedicineForRudolph_Part2;
import fi.tuomax.adventofcode.year2015.day20.InfiniteElvesAndInfiniteHouses_Part1;
import fi.tuomax.adventofcode.year2015.day20.InfiniteElvesAndInfiniteHouses_Part2;
import fi.tuomax.adventofcode.year2015.day21.RpgSimulator20xx_Part1;
import fi.tuomax.adventofcode.year2015.day21.RpgSimulator20xx_Part2;
import fi.tuomax.adventofcode.year2015.day22.WizardSimulator20XX_Part1;
import fi.tuomax.adventofcode.year2015.day22.WizardSimulator20XX_Part2;
import fi.tuomax.adventofcode.year2015.day23.OpeningTheTuringLock_Part1;
import fi.tuomax.adventofcode.year2015.day23.OpeningTheTuringLock_Part2;
import fi.tuomax.adventofcode.year2015.day24.ItHangsInTheBalance_Part1;
import fi.tuomax.adventofcode.year2015.day24.ItHangsInTheBalance_Part2;
import fi.tuomax.adventofcode.year2015.day25.LetItSnow;
import fi.tuomax.adventofcode.year2016.day01.NoTimeForATaxicab_Part1;
import fi.tuomax.adventofcode.year2016.day01.NoTimeForATaxicab_Part2;
import fi.tuomax.adventofcode.year2016.day02.BathroomSecurity_Part1;
import fi.tuomax.adventofcode.year2016.day02.BathroomSecurity_Part2;
import fi.tuomax.adventofcode.year2016.day03.SquaresWithThreeSides_Part1;
import fi.tuomax.adventofcode.year2016.day03.SquaresWithThreeSides_Part2;
import fi.tuomax.adventofcode.year2016.day04.SecurityThroughObscurity_Part1;
import fi.tuomax.adventofcode.year2016.day04.SecurityThroughObscurity_Part2;

public class AdventOfCode 
{

    private Year year = new Year();

    public void run(Settings settings)
    {
        printWelcome();
//        addSolvers2015();
        addSolvers2016();
        Runner runner = manufactureRunner(settings);
        Metadata metadata = settings.metadata() != null ? settings.metadata() : Year.latestAddition;
        Results results = runner.run(metadata, year);
        Printer printer = manufacturePrinter();
        printer.print(settings, results);
    }

    private void addSolvers2016() 
    {
        /* day 1 */
        year.addSolver(new NoTimeForATaxicab_Part1());
        year.addSolver(new NoTimeForATaxicab_Part2());
        /* day 2 */
        year.addSolver(new BathroomSecurity_Part1());
        year.addSolver(new BathroomSecurity_Part2());
        /* day 3 */
        year.addSolver(new SquaresWithThreeSides_Part1());
        year.addSolver(new SquaresWithThreeSides_Part2());
        /* day 4 */
        year.addSolver(new SecurityThroughObscurity_Part1());
        year.addSolver(new SecurityThroughObscurity_Part2());
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

    private void addSolvers2015() {
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
        /* day 13 */
        year.addSolver(new KnightsOfTheDinnerTable_Part1());
        year.addSolver(new KnightsOfTheDinnerTable_Part2());
        /* day 14 */
        year.addSolver(new ReindeerOlympics_Part1());
        year.addSolver(new ReindeerOlympics_Part2());
        /* day 15 */
        year.addSolver(new ScienceForHungryPeople_Part1());
        year.addSolver(new ScienceForHungryPeople_Part2());
        /* day 16 */
        year.addSolver(new AuntSue_Part1());
        year.addSolver(new AuntSue_Part2());
        /* day 17 */
        year.addSolver(new NoSuchThingAsTooMuch_Part1());
        year.addSolver(new NoSuchThingAsTooMuch_Part2());
        /* day 18 */
        year.addSolver(new LikeAGifForYourYard_Part1());
        year.addSolver(new LikeAGifForYourYard_Part2());
        /* day 19 */
        year.addSolver(new MedicineForRudolph_Part1());
        year.addSolver(new MedicineForRudolph_Part2());
        /* day 20 */
        year.addSolver(new InfiniteElvesAndInfiniteHouses_Part1());
        year.addSolver(new InfiniteElvesAndInfiniteHouses_Part2());
        /* day 21 */
        year.addSolver(new RpgSimulator20xx_Part1());
        year.addSolver(new RpgSimulator20xx_Part2());
        /* day 22 */
        year.addSolver(new WizardSimulator20XX_Part1());
        year.addSolver(new WizardSimulator20XX_Part2());
        /* day 23 */
        year.addSolver(new OpeningTheTuringLock_Part1());
        year.addSolver(new OpeningTheTuringLock_Part2());
        /* day 24 */
        year.addSolver(new ItHangsInTheBalance_Part1());
        year.addSolver(new ItHangsInTheBalance_Part2());
        /* day 25 */
        year.addSolver(new LetItSnow());
    }

    private void printWelcome() {
        System.out.print("\n".repeat(2));
        System.out.println(Ansi.ansi().fgBright(Ansi.Color.WHITE).a("Tuomax's Advent of Code Framework v. 15.0").reset());
        System.out.print("\n".repeat(2));
    }

    
}