package fi.tuomax.adventofcode.year2024.day02;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class RednosedReports_Parser
extends Parser
{

    private List<List<Integer>> reports = new ArrayList<>();

    public List<List<Integer>> getReports() {
        return reports;
    }

    public RednosedReports_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        for (String line : input) {
            List<Integer> report = new ArrayList<>();
            for (String part : line.split(" "))
                report.add(Integer.valueOf(part));
            reports.add(report);
        }
    }

}
