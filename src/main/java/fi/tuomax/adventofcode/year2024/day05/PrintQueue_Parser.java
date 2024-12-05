package fi.tuomax.adventofcode.year2024.day05;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class PrintQueue_Parser
extends Parser
{

    private List<Rule> rules = new ArrayList<>();

    public List<Rule> getRules() {
        return rules;
    }

    private List<List<Integer>> updates = new ArrayList<>();

    public List<List<Integer>> getUpdates() {
        return updates;
    }

    public PrintQueue_Parser(List<String> input)
    {
        super(input);
    }


    @Override
    public void parse()
    {
        final int RULE_STATE = 0;
        final int UPDATE_STATE = 1;
        int parseState = RULE_STATE;

        for (String line : input) {
            if (line.isEmpty()) {
                parseState = UPDATE_STATE;
                continue;
            } 
            if (parseState == RULE_STATE)
                rules.add(new Rule(line));
            else
                updates.add(updateFromAocInput(line));
        }
    }

    private List<Integer> updateFromAocInput(String line)
    {
        List<Integer> update = new ArrayList<>();
        for (String value : line.split(","))
            update.add(Integer.valueOf(value));
        return update;
    }

}
