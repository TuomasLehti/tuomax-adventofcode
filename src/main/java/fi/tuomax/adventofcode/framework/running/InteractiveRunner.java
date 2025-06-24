package fi.tuomax.adventofcode.framework.running;

import java.util.List;
import java.util.Scanner;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;
import fi.tuomax.adventofcode.framework.storing.All;

public class InteractiveRunner 
extends LatestRunner
{

    @Override
    protected List<List<Solver>> collectSolvers(Metadata metadata, All solvers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select year: ");
        int year = scanner.nextInt();
        System.out.println("Select day: ");
        int day = scanner.nextInt();
        scanner.close();
        Metadata meta = new Metadata(year, day, null, null, "");
        return super.collectSolvers(meta, solvers);
    }
    

}
