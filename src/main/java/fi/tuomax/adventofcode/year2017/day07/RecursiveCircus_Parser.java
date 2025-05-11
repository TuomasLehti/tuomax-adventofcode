package fi.tuomax.adventofcode.year2017.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class RecursiveCircus_Parser
extends Parser
{

    private CircusProgram programTree = null;

    public CircusProgram getProgramTree() 
    {
        return programTree;
    }

    public RecursiveCircus_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        List<List<String>> partss = new ArrayList<>();
        for (String s : input) {
            partss.add(Arrays.asList(s.split(" \\(|\\) -> |\\)|, ")));
        }
        Map<String, CircusProgram> programs = new HashMap<>();
        for (List<String> parts : partss) {
            programs.put(
                parts.get(0),
                new CircusProgram(parts.get(0), Integer.valueOf(parts.get(1)))
            );
        }
        for (List<String> parts : partss) {
            if (parts.size() > 2) {
                CircusProgram program = programs.get(parts.get(0));
                for (int idx = 2; idx < parts.size(); idx++) {
                    program.addChild(programs.get(parts.get(idx)));
                }
            }
        }
        for (String programname : programs.keySet()) {
            if (programs.get(programname).getParent() == null) {
                programTree = programs.get(programname);
            }
        }
        System.out.println();
    }

}
