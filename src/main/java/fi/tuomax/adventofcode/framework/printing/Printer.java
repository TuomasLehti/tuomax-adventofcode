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

        System.out.print(Ansi.ansi().fg(Ansi.Color.GREEN).a(String.format(
            "%-40s", 
            runned.get(0).get(0).getMetadata().name()
        )).reset().toString());

        System.out.print(" | ");
        System.out.print(String.format("%-15s", runned.get(0).get(0).getAnswer()));
        System.out.print(" (");
        System.out.print(String.format("%14s", runned.get(0).get(0).getStopwatch().toString()));
        System.out.print(") | ");
        System.out.print(" | ");
        System.out.print(String.format("%-15s", runned.get(0).get(1).getAnswer()));
        System.out.print(" (");
        System.out.print(String.format("%14s", runned.get(0).get(1).getStopwatch().toString()));
        System.out.print(")");
        System.out.print("\n".repeat(2));
    }
    
}
