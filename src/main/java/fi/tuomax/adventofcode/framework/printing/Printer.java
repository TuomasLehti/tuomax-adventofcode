package fi.tuomax.adventofcode.framework.printing;

import java.util.List;

import org.fusesource.jansi.Ansi;

import fi.tuomax.adventofcode.framework.solving.Solver;

public class Printer 
{

    public void print(List<List<Solver>> runned)
    {
        System.out.print("\n".repeat(2));

        System.out.println(Ansi.ansi().fgBright(Ansi.Color.GREEN).a(String.format(
                "Advent of Code %d", 
                runned.get(0).get(0).getMetadata().year()
        )).reset().toString());

        for (List<Solver> row : runned) {
            System.out.print(Ansi.ansi().fg(Ansi.Color.GREEN).a(String.format(
                "%-40s", 
                row.get(0).getMetadata().name()
            )).reset().toString());
    
            System.out.print(" | ");
            System.out.print(String.format("%-15s", row.get(0).getAnswer()));
            System.out.print(" (");
            System.out.print(String.format("%14s", row.get(0).getStopwatch().toString()));
            System.out.print(") | ");
            System.out.print(String.format("%-15s", row.get(1).getAnswer()));
            System.out.print(" (");
            System.out.print(String.format("%14s", row.get(1).getStopwatch().toString()));
            System.out.println(")");
        }
        System.out.print("\n".repeat(2));
    }
    
}
