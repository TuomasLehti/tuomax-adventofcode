package fi.tuomax.adventofcode.year2015.day12;

import java.util.List;

import org.json.JSONObject;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class JsonParser 
extends Parser
{

    private JSONObject json;

    public JSONObject getJson() 
    {
        return json;
    }

    public JsonParser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        /* If the input is a JSON array, convert it to a JSON object. */
        String jsonStr = !input.get(0).startsWith("{") 
            ? "{\"aoc\":" + input.get(0) + "}" 
            : input.get(0);
        json = new JSONObject(jsonStr);
    }
    
}
