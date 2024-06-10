package fi.tuomax.adventofcode.framework.printing;

import org.fusesource.jansi.Ansi;

public class Printer 
{

    public void print(Results results)
    {
        System.out.print("\n".repeat(2));

        System.out.println(Ansi.ansi().fgBright(Ansi.Color.GREEN).a(
                results.mainHeading()
        ).reset().toString());

        for (ResultRow row : results.rows()) {
            System.out.print(Ansi.ansi().fg(Ansi.Color.GREEN).a(String.format(
                "%-40s", 
                row.name()
            )).reset().toString());
    
            System.out.print(" | ");
            System.out.print(String.format("%-15s", row.cols().get(0).answer()));
            System.out.print(" (");
            System.out.print(String.format("%14s", row.cols().get(0).time()));
            System.out.print(") | ");
            System.out.print(String.format("%-15s", row.cols().get(1).answer()));
            System.out.print(" (");
            System.out.print(String.format("%14s", row.cols().get(1).time()));
            System.out.println(")");
        }
        System.out.print("\n".repeat(2));
    }
    
}
