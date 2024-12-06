package fi.tuomax.adventofcode;

import org.fusesource.jansi.Ansi;

import fi.tuomax.adventofcode.framework.printing.Printer;
import fi.tuomax.adventofcode.framework.printing.Results;
import fi.tuomax.adventofcode.framework.running.DaySpeedRunner;
import fi.tuomax.adventofcode.framework.running.LatestRunner;
import fi.tuomax.adventofcode.framework.running.Runner;
import fi.tuomax.adventofcode.framework.running.YearRunner;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.storing.All;
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
import fi.tuomax.adventofcode.year2016.day05.HowAboutANiceGameOfChess_Part1;
import fi.tuomax.adventofcode.year2016.day05.HowAboutANiceGameOfChess_Part2;
import fi.tuomax.adventofcode.year2016.day06.SignalsAndNoise_Part1;
import fi.tuomax.adventofcode.year2016.day06.SignalsAndNoise_Part2;
import fi.tuomax.adventofcode.year2016.day07.InternetProtocolVersion7_Part1;
import fi.tuomax.adventofcode.year2016.day07.InternetProtocolVersion7_Part2;
import fi.tuomax.adventofcode.year2016.day08.TwoFactorAuthentication_Part1;
import fi.tuomax.adventofcode.year2016.day08.TwoFactorAuthentication_Part2;
import fi.tuomax.adventofcode.year2016.day09.ExplosivesInCyberspace_Part1;
import fi.tuomax.adventofcode.year2016.day09.ExplosivesInCyberspace_Part2;
import fi.tuomax.adventofcode.year2016.day10.BalanceBots_Part1;
import fi.tuomax.adventofcode.year2016.day10.BalanceBots_Part2;
import fi.tuomax.adventofcode.year2016.day11.RadioisotopeThermoelectricGenerators_Part1;
import fi.tuomax.adventofcode.year2016.day11.RadioisotopeThermoelectricGenerators_Part2;
import fi.tuomax.adventofcode.year2016.day12.LeonardosMonorail_Part1;
import fi.tuomax.adventofcode.year2016.day12.LeonardosMonorail_Part2;
import fi.tuomax.adventofcode.year2016.day13.AMazeOfTwistyLittleCubicles_Part1;
import fi.tuomax.adventofcode.year2016.day13.AMazeOfTwistyLittleCubicles_Part2;
import fi.tuomax.adventofcode.year2016.day15.TimingIsEverything_Part1;
import fi.tuomax.adventofcode.year2016.day15.TimingIsEverything_Part2;
import fi.tuomax.adventofcode.year2016.day16.DragonChecksum_Part1;
import fi.tuomax.adventofcode.year2016.day16.DragonChecksum_Part2;
import fi.tuomax.adventofcode.year2016.day17.TwoStepsForward_Part1;
import fi.tuomax.adventofcode.year2016.day17.TwoStepsForward_Part2;
import fi.tuomax.adventofcode.year2016.day18.LikeARogue_Part1;
import fi.tuomax.adventofcode.year2016.day18.LikeARogue_Part2;
import fi.tuomax.adventofcode.year2016.day20.FirewallRules_Part1;
import fi.tuomax.adventofcode.year2016.day20.FirewallRules_Part2;
import fi.tuomax.adventofcode.year2016.day21.ScrambledLettersAndHash_Part1;
import fi.tuomax.adventofcode.year2016.day21.ScrambledLettersAndHash_Part2;
import fi.tuomax.adventofcode.year2016.day22.GridComputing_Part1;
import fi.tuomax.adventofcode.year2016.day22.GridComputing_Part2;
import fi.tuomax.adventofcode.year2016.day23.SafeCracking_Part1;
import fi.tuomax.adventofcode.year2016.day23.SafeCracking_Part2;
import fi.tuomax.adventofcode.year2016.day24.AirDuctSpelunking_Part1;
import fi.tuomax.adventofcode.year2016.day24.AirDuctSpelunking_Part2;
import fi.tuomax.adventofcode.year2016.day25.ClockSignal_Part1;
import fi.tuomax.adventofcode.year2022.day01.CalorieCounting_Part1;
import fi.tuomax.adventofcode.year2022.day01.CalorieCounting_Part2;
import fi.tuomax.adventofcode.year2022.day02.RockPaperScissors_Part1;
import fi.tuomax.adventofcode.year2022.day02.RockPaperScissors_Part2;
import fi.tuomax.adventofcode.year2022.day03.RucksackReorganization_Solver_Part1;
import fi.tuomax.adventofcode.year2022.day03.RucksackReorganization_Solver_Part2;
import fi.tuomax.adventofcode.year2022.day04.CampCleanup_Part1;
import fi.tuomax.adventofcode.year2022.day04.CampCleanup_Part2;
import fi.tuomax.adventofcode.year2022.day05.SupplyStacks_Part1;
import fi.tuomax.adventofcode.year2022.day05.SupplyStacks_Part2;
import fi.tuomax.adventofcode.year2022.day06.TuningTrouble_Part1;
import fi.tuomax.adventofcode.year2022.day06.TuningTrouble_Part2;
import fi.tuomax.adventofcode.year2022.day07.NoSpaceLeftOnDevice_Part1;
import fi.tuomax.adventofcode.year2022.day07.NoSpaceLeftOnDevice_Part2;
import fi.tuomax.adventofcode.year2022.day08.TreetopTreeHouse_Part1;
import fi.tuomax.adventofcode.year2022.day08.TreetopTreeHouse_Part2;
import fi.tuomax.adventofcode.year2022.day09.RopeBridge_Part1;
import fi.tuomax.adventofcode.year2022.day09.RopeBridge_Part2;
import fi.tuomax.adventofcode.year2022.day10.CathoderayTube_Part1;
import fi.tuomax.adventofcode.year2022.day10.CathoderayTube_Part2;
import fi.tuomax.adventofcode.year2022.day11.MonkeyInTheMiddle_Part1;
import fi.tuomax.adventofcode.year2022.day11.MonkeyInTheMiddle_Part2;
import fi.tuomax.adventofcode.year2022.day12.HillClimbingAlgorithm_Part1;
import fi.tuomax.adventofcode.year2022.day12.HillClimbingAlgorithm_Part2;
import fi.tuomax.adventofcode.year2022.day14.RegolithReservoir_Part1;
import fi.tuomax.adventofcode.year2022.day14.RegolithReservoir_Part2;
import fi.tuomax.adventofcode.year2022.day15.BeaconExclusionZone_Part1;
import fi.tuomax.adventofcode.year2022.day15.BeaconExclusionZone_Part2;
import fi.tuomax.adventofcode.year2024.day01.HistorianHysteria_Part1;
import fi.tuomax.adventofcode.year2024.day01.HistorianHysteria_Part2;
import fi.tuomax.adventofcode.year2024.day02.RednosedReports_Part1;
import fi.tuomax.adventofcode.year2024.day02.RednosedReports_Part2;
import fi.tuomax.adventofcode.year2024.day03.MullItOver_Part1;
import fi.tuomax.adventofcode.year2024.day03.MullItOver_Part2;
import fi.tuomax.adventofcode.year2024.day04.CeresSearch_Part1;
import fi.tuomax.adventofcode.year2024.day04.CeresSearch_Part2;
import fi.tuomax.adventofcode.year2024.day05.PrintQueue_Part1;
import fi.tuomax.adventofcode.year2024.day05.PrintQueue_Part2;
import fi.tuomax.adventofcode.year2024.day06.GuardGallivant_Part1;
import fi.tuomax.adventofcode.year2022.day13.DistressSignal_Part1;
import fi.tuomax.adventofcode.year2022.day13.DistressSignal_Part2;
import fi.tuomax.adventofcode.year2016.day19.AnElephantNamedJoseph_Part1;
import fi.tuomax.adventofcode.year2016.day19.AnElephantNamedJoseph_Part2;
import fi.tuomax.adventofcode.year2016.day14.OnetimePad_Part1;
import fi.tuomax.adventofcode.year2016.day14.OnetimePad_Part2;

public class AdventOfCode 
{

    private All solvers = new All();

    public void run(Settings settings)
    {
        printWelcome();
        addSolvers2015();
        addSolvers2016();
        addSolvers2022();
        addSolvers2024();
        Runner runner = manufactureRunner(settings);
        Metadata metadata = settings.metadata() != null ? settings.metadata() : Year.latestAddition;
        Results results = runner.run(metadata, solvers);
        Printer printer = manufacturePrinter();
        printer.print(settings, results);
    }
    private void addSolvers2024() 
    {
        solvers.addSolver(new HistorianHysteria_Part1());
        solvers.addSolver(new HistorianHysteria_Part2());
        solvers.addSolver(new RednosedReports_Part1());
        solvers.addSolver(new RednosedReports_Part2());
        solvers.addSolver(new MullItOver_Part1());
        solvers.addSolver(new MullItOver_Part2());
        solvers.addSolver(new CeresSearch_Part1());
        solvers.addSolver(new CeresSearch_Part2());
        solvers.addSolver(new PrintQueue_Part1());
        solvers.addSolver(new PrintQueue_Part2());
        solvers.addSolver(new GuardGallivant_Part1());
    }

    private void addSolvers2022() {
        /* day 1 */
        solvers.addSolver(new CalorieCounting_Part1());
        solvers.addSolver(new CalorieCounting_Part2());
        /* day 2 */
        solvers.addSolver(new RockPaperScissors_Part1());
        solvers.addSolver(new RockPaperScissors_Part2());
        /* day 3 */
        solvers.addSolver(new RucksackReorganization_Solver_Part1());
        solvers.addSolver(new RucksackReorganization_Solver_Part2());
        /* day 4 */
        solvers.addSolver(new CampCleanup_Part1());
        solvers.addSolver(new CampCleanup_Part2());
        /* day 5 */
        solvers.addSolver(new SupplyStacks_Part1());
        solvers.addSolver(new SupplyStacks_Part2());
        /* day 6 */
        solvers.addSolver(new TuningTrouble_Part1());
        solvers.addSolver(new TuningTrouble_Part2());
        /* day 7 */
        solvers.addSolver(new NoSpaceLeftOnDevice_Part1());
        solvers.addSolver(new NoSpaceLeftOnDevice_Part2());
        /* day 8 */
        solvers.addSolver(new TreetopTreeHouse_Part1());
        solvers.addSolver(new TreetopTreeHouse_Part2());
        /* day 9 */
        solvers.addSolver(new RopeBridge_Part1());
        solvers.addSolver(new RopeBridge_Part2());
        /* day 10 */
        solvers.addSolver(new CathoderayTube_Part1());
        solvers.addSolver(new CathoderayTube_Part2());
        /* day 11 */
        solvers.addSolver(new MonkeyInTheMiddle_Part1());
        solvers.addSolver(new MonkeyInTheMiddle_Part2());
        /* day 12 */
        solvers.addSolver(new HillClimbingAlgorithm_Part1());
        solvers.addSolver(new HillClimbingAlgorithm_Part2());
        /* day 13 */
        solvers.addSolver(new DistressSignal_Part1());
        solvers.addSolver(new DistressSignal_Part2());
        /* day 14 */
        solvers.addSolver(new RegolithReservoir_Part1());
        solvers.addSolver(new RegolithReservoir_Part2());
        /* day 15 */
        solvers.addSolver(new BeaconExclusionZone_Part1());
        solvers.addSolver(new BeaconExclusionZone_Part2());
    }

    private void addSolvers2016() 
    {
        /* day 1 */
        solvers.addSolver(new NoTimeForATaxicab_Part1());
        solvers.addSolver(new NoTimeForATaxicab_Part2());
        /* day 2 */
        solvers.addSolver(new BathroomSecurity_Part1());
        solvers.addSolver(new BathroomSecurity_Part2());
        /* day 3 */
        solvers.addSolver(new SquaresWithThreeSides_Part1());
        solvers.addSolver(new SquaresWithThreeSides_Part2());
        /* day 4 */
        solvers.addSolver(new SecurityThroughObscurity_Part1());
        solvers.addSolver(new SecurityThroughObscurity_Part2());
        /* day 5 */
        solvers.addSolver(new HowAboutANiceGameOfChess_Part1());
        solvers.addSolver(new HowAboutANiceGameOfChess_Part2());
        /* day 6 */
        solvers.addSolver(new SignalsAndNoise_Part1());
        solvers.addSolver(new SignalsAndNoise_Part2());
        /* day 7 */
        solvers.addSolver(new InternetProtocolVersion7_Part1());
        solvers.addSolver(new InternetProtocolVersion7_Part2());
        /* day 8 */
        solvers.addSolver(new TwoFactorAuthentication_Part1());
        solvers.addSolver(new TwoFactorAuthentication_Part2());
        /* day 9 */
        solvers.addSolver(new ExplosivesInCyberspace_Part1());
        solvers.addSolver(new ExplosivesInCyberspace_Part2());
        /* day 10 */
        solvers.addSolver(new BalanceBots_Part1());
        solvers.addSolver(new BalanceBots_Part2());
        /* day 11 */
        solvers.addSolver(new RadioisotopeThermoelectricGenerators_Part1());
        solvers.addSolver(new RadioisotopeThermoelectricGenerators_Part2());
        /* day 12 */
        solvers.addSolver(new LeonardosMonorail_Part1());
        solvers.addSolver(new LeonardosMonorail_Part2());
        /* day 13 */
        solvers.addSolver(new AMazeOfTwistyLittleCubicles_Part1());
        solvers.addSolver(new AMazeOfTwistyLittleCubicles_Part2());
        /* day 14 */
        solvers.addSolver(new OnetimePad_Part1());
        solvers.addSolver(new OnetimePad_Part2());
        /* day 15 */
        solvers.addSolver(new TimingIsEverything_Part1());
        solvers.addSolver(new TimingIsEverything_Part2());
        /* day 16 */
        solvers.addSolver(new DragonChecksum_Part1());
        solvers.addSolver(new DragonChecksum_Part2());
        /* day 17 */
        solvers.addSolver(new TwoStepsForward_Part1());
        solvers.addSolver(new TwoStepsForward_Part2());
        /* day 18 */
        solvers.addSolver(new LikeARogue_Part1());
        solvers.addSolver(new LikeARogue_Part2());
        /* day 19 */
        solvers.addSolver(new AnElephantNamedJoseph_Part1());
        solvers.addSolver(new AnElephantNamedJoseph_Part2());
        /* day 20 */
        solvers.addSolver(new FirewallRules_Part1());
        solvers.addSolver(new FirewallRules_Part2());
        /* day 21 */
        solvers.addSolver(new ScrambledLettersAndHash_Part1());
        solvers.addSolver(new ScrambledLettersAndHash_Part2());
        /* day 22 */
        solvers.addSolver(new GridComputing_Part1());
        solvers.addSolver(new GridComputing_Part2());
        /* day 23 */
        solvers.addSolver(new SafeCracking_Part1());
        solvers.addSolver(new SafeCracking_Part2());
        /* day 24 */
        solvers.addSolver(new AirDuctSpelunking_Part1());
        solvers.addSolver(new AirDuctSpelunking_Part2());
        /* day 25 */
        solvers.addSolver(new ClockSignal_Part1());
    }

    private Printer manufacturePrinter() {
        return new Printer();
    }

    private Runner manufactureRunner(Settings settings) {
        if (settings.runMode() == RunMode.LATEST)
            return new LatestRunner();
        else if (settings.runMode() == RunMode.YEAR)
            return new YearRunner();
        else if (settings.runMode() == RunMode.DAY)
            return new DaySpeedRunner();
        return null;
    }

    private void addSolvers2015() {
        /* day 1 */
        solvers.addSolver(new NotQuiteLisp_Part1());
        solvers.addSolver(new NotQuiteLisp_Part2());
        /* day 2 */
        solvers.addSolver(new IWasToldThereWouldBeNoMath_Part1());
        solvers.addSolver(new IWasToldThereWouldBeNoMath_Part2());
        /* day 3 */
        solvers.addSolver(new PerfectlySphericalHousesInAVacuum_Part1());
        solvers.addSolver(new PerfectlySphericalHousesInAVacuum_Part2());
        /* day 4 */
        solvers.addSolver(new TheIdealStockingStuffer_Part1());
        solvers.addSolver(new TheIdealStockingStuffer_Part2());
        /* day 5 */
        solvers.addSolver(new DoesntHeHaveInternElvesForThis_Part1());
        solvers.addSolver(new DoesntHeHaveInternElvesForThis_Part2());
        /* day 6 */
        solvers.addSolver(new ProbablyAFireHazard_LightRanges_Part1());
        solvers.addSolver(new ProbablyAFireHazard_LightRanges_Part2());
        solvers.addSolver(new ProbablyAFireHazard_SingleLights_Part1());
        solvers.addSolver(new ProbablyAFireHazard_SingleLights_Part2());
        /* day 7 */
        solvers.addSolver(new SomeAssemblyRequired_Part1());
        solvers.addSolver(new SomeAssemblyRequired_Part2());
        /* day 8 */
        solvers.addSolver(new Matchsticks_Part1());
        solvers.addSolver(new Matchsticks_Part2());
        /* day 9 */
        solvers.addSolver(new AllInASingleNight_Part1());
        solvers.addSolver(new AllInASingleNight_Part2());
        /* day 10 */
        solvers.addSolver(new ElvesLookElvesSay_Part1());
        solvers.addSolver(new ElvesLookElvesSay_Part2());
        /* day 11 */
        solvers.addSolver(new CorporatePolicy_Part1());
        solvers.addSolver(new CorporatePolicy_Part2());
        /* day 12 */
        solvers.addSolver(new JSAbacusFrameworkIo_Part1());
        solvers.addSolver(new JSAbacusFrameworkIo_Part2());
        /* day 13 */
        solvers.addSolver(new KnightsOfTheDinnerTable_Part1());
        solvers.addSolver(new KnightsOfTheDinnerTable_Part2());
        /* day 14 */
        solvers.addSolver(new ReindeerOlympics_Part1());
        solvers.addSolver(new ReindeerOlympics_Part2());
        /* day 15 */
        solvers.addSolver(new ScienceForHungryPeople_Part1());
        solvers.addSolver(new ScienceForHungryPeople_Part2());
        /* day 16 */
        solvers.addSolver(new AuntSue_Part1());
        solvers.addSolver(new AuntSue_Part2());
        /* day 17 */
        solvers.addSolver(new NoSuchThingAsTooMuch_Part1());
        solvers.addSolver(new NoSuchThingAsTooMuch_Part2());
        /* day 18 */
        solvers.addSolver(new LikeAGifForYourYard_Part1());
        solvers.addSolver(new LikeAGifForYourYard_Part2());
        /* day 19 */
        solvers.addSolver(new MedicineForRudolph_Part1());
        solvers.addSolver(new MedicineForRudolph_Part2());
        /* day 20 */
        solvers.addSolver(new InfiniteElvesAndInfiniteHouses_Part1());
        solvers.addSolver(new InfiniteElvesAndInfiniteHouses_Part2());
        /* day 21 */
        solvers.addSolver(new RpgSimulator20xx_Part1());
        solvers.addSolver(new RpgSimulator20xx_Part2());
        /* day 22 */
        solvers.addSolver(new WizardSimulator20XX_Part1());
        solvers.addSolver(new WizardSimulator20XX_Part2());
        /* day 23 */
        solvers.addSolver(new OpeningTheTuringLock_Part1());
        solvers.addSolver(new OpeningTheTuringLock_Part2());
        /* day 24 */
        solvers.addSolver(new ItHangsInTheBalance_Part1());
        solvers.addSolver(new ItHangsInTheBalance_Part2());
        /* day 25 */
        solvers.addSolver(new LetItSnow());
    }

    private void printWelcome() {
        System.out.print("\n".repeat(2));
        System.out.println(Ansi.ansi().fgBright(Ansi.Color.WHITE).a("Tuomax's Advent of Code Framework v. 16.1").reset());
        System.out.print("\n".repeat(2));
    }

    
}