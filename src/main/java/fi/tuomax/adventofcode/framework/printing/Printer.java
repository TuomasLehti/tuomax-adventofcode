package fi.tuomax.adventofcode.framework.printing;

import java.util.HashMap;
import java.util.Map;

import org.fusesource.jansi.Ansi;

import fi.tuomax.adventofcode.Settings;

public class Printer 
{

    private Results results;

    private Integer maxParts = 0;

    public void print(Settings settings, Results results)
    {
        this.results = results;
        maxParts = maxParts(results);

        System.out.print("\n".repeat(2));

        printFirstSpacer();
        System.out.print(" | ");
        System.out.print(Ansi.ansi().fgBright(Ansi.Color.GREEN).a(
            String.format("%-" + spaceNeededForHeading() + "s",
                results.mainHeading())
        ).reset().toString());
        System.out.println(" | ");

        printSpacer();

        for (ResultRow row : results.rows()) {
            printName(row);
            for (int idx = 1; idx <= maxParts; idx++) {
                if (row.hasPart(idx)) {
                    printAnswer(row.getCol(idx));
                    printTime(row.getCol(idx));
                } else {
                    Integer numOfSpaces =
                        getSpaceNeededForAnswer(idx) +
                        getSpaceNeededForTime(idx) +
                        3;
                    System.out.print(" | ");
                    System.out.print(" ".repeat(numOfSpaces));
                }
            }
            System.out.println(" | ");
        }
        printSpacer();
        System.out.print("\n".repeat(2));
    }

    private Integer maxParts(Results results)
    {
        Integer maxParts = Integer.MIN_VALUE;
        for (ResultRow row : results.rows()) {
            maxParts = Math.max(maxParts, row.cols().size());
        }
        return maxParts;
    }

    private Integer spaceNeededForHeading()
    {
        Integer spaceNeeded = getSpaceNeededForName();
        for (int idx = 1; idx <= maxParts; idx++) {
            spaceNeeded += 6;
            spaceNeeded += getSpaceNeededForAnswer(idx);
            spaceNeeded += getSpaceNeededForTime(idx);
        }
        return spaceNeeded;
    }

    private void printName(ResultRow row)
    {
        System.out.print(" | ");
        String format = String.format("%%-%ds", getSpaceNeededForName());
        System.out.print(Ansi.ansi().fg(Ansi.Color.GREEN).a(String.format(
            format, 
            row.name()
        )).reset().toString());
    }

    private void printAnswer(ResultCol col)
    {
        System.out.print(" | ");
        String format = String.format(
            "%%-%ds", 
            getSpaceNeededForAnswer(col.solver().getMetadata().part())
        );
        System.out.print(String.format(format, col.answer()));
    }

    private void printTime(ResultCol col)
    {
        System.out.print(" (");
        System.out.print(formatTime(col.time()));
        System.out.print(")");
    }

    private void printSpacer()
    {
        final String CROSSING = "-|-";
        System.out.print(CROSSING);
        System.out.print("-".repeat(getSpaceNeededForName()));
        for (int idx = 1; idx <= maxParts; idx++) {
            Integer numOfSpaces =
                getSpaceNeededForAnswer(idx) +
                getSpaceNeededForTime(idx) +
                3;
            System.out.print(CROSSING);
            System.out.print("-".repeat(numOfSpaces));
        }
        System.out.println(CROSSING);
    }

    private void printFirstSpacer()
    {
        final String CROSSING = "-|-";
        System.out.print(CROSSING);
        System.out.print("-".repeat(getSpaceNeededForName()));
        for (int idx = 1; idx <= maxParts; idx++) {
            Integer numOfSpaces =
                getSpaceNeededForAnswer(idx) +
                getSpaceNeededForTime(idx) +
                3;
            System.out.print("---");
            System.out.print("-".repeat(numOfSpaces));
        }
        System.out.println(CROSSING);
    }

    Integer spaceNeededForName = -1;

    private Integer getSpaceNeededForName()
    {
        if (spaceNeededForName == -1) 
            for (ResultRow row : results.rows())
                spaceNeededForName = Math.max(spaceNeededForName, row.name().length());
        return spaceNeededForName;
    }

    Map<Integer, Integer> spaceNeededForAnswer = new HashMap<>();

    private Integer getSpaceNeededForAnswer(Integer part)
    {
        if (!spaceNeededForAnswer.containsKey(part)) {
            Integer spaceNeeded = -1;
            for (ResultRow row : results.rows())
                for (ResultCol col : row.cols())
                    if (col.solver().getMetadata().part().equals(part))
                        spaceNeeded = Math.max(spaceNeeded, col.answer().length());
            spaceNeededForAnswer.put(part, spaceNeeded);
        }
        return spaceNeededForAnswer.get(part);
    }

    Map<Integer, Integer> spaceNeededForTime = new HashMap<>();

    private Integer getSpaceNeededForTime(Integer part)
    {
        if (!spaceNeededForTime.containsKey(part)) {
            Integer spaceNeeded = -1;
            for (ResultRow row : results.rows())
                for (ResultCol col : row.cols())
                    if (col.solver().getMetadata().part().equals(part))
                        spaceNeeded = Math.max(spaceNeeded, formatTime(col.time()).length());
            spaceNeededForTime.put(part, spaceNeeded);
        }
        return spaceNeededForTime.get(part);
    }

    private String formatTime(Long millis)
    {
        return String.format("%.3f secs", millis / 1000.0);
    }
    
}
