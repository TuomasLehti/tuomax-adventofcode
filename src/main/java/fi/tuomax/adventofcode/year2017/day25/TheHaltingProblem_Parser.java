package fi.tuomax.adventofcode.year2017.day25;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fi.tuomax.adventofcode.commons.Direction.TurnDirection;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class TheHaltingProblem_Parser
extends Parser
{

    private String startState = "A";
    
    public String getStartState() 
    {
        return startState;
    }

    private Integer numOfSteps = 0;

    public Integer getNumOfSteps() 
    {
        return numOfSteps;
    }

    private Map<TuringState, TuringInst> states = new HashMap<>();

    public Map<TuringState, TuringInst> getStates() 
    {
        return states;
    }

    public TheHaltingProblem_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        while (!input.isEmpty()) 
            if (input.get(0).startsWith("Begin"))
                parseBegin();
            else if (input.get(0).startsWith("Perform"))
                parseNumOfSteps();
            else if (input.get(0).startsWith("In "))
                parseState();
            else
                input.remove(0);
    }

    private void parseState() 
    {
        String state = getLastWord(input.get(0));
        states.put(
            new TuringState(
                state,
                getLastWord(input.get(1)).equals("1")
            ), 
            new TuringInst(
                getLastWord(input.get(2)).equals("1"),
                getLastWord(input.get(3)).equals("left") ? TurnDirection.LEFT : TurnDirection.RIGHT,
                getLastWord(input.get(4))
            )
        );
        states.put(
            new TuringState(
                state,
                getLastWord(input.get(5)).equals("1")
            ), 
            new TuringInst(
                getLastWord(input.get(6)).equals("1"),
                getLastWord(input.get(7)).equals("left") ? TurnDirection.LEFT : TurnDirection.RIGHT,
                getLastWord(input.get(8))
               
            )
        );
        for (int i = 0; i < 10; i++)
            if (!input.isEmpty())
                input.remove(0);
    }

    private void parseNumOfSteps() 
    {
        String line = input.get(0);
        String[] parts = line.split(" |\\.|:");
        numOfSteps = Integer.valueOf(parts[5]);
        input.remove(0);
        input.remove(0);
    }

    private void parseBegin() 
    {
        startState = getLastWord(input.get(0));
        input.remove(0);
    }

    private String getLastWord(String line)
    {
        String[] parts = line.split(" |\\.|:");
        return parts[parts.length - 1];
    }

}
