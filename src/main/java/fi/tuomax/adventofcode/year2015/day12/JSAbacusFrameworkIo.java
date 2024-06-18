package fi.tuomax.adventofcode.year2015.day12;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

public abstract class JSAbacusFrameworkIo 
extends Solver
{

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new JsonParser(input);
    }

    @Override
    protected void solve() {
        JSONObject json = ((JsonParser) parser).getJson();
        setAnswer(countObject(json));
    }

    private Integer countObject(JSONObject json)
    {
        Integer answer = 0;
        for (String key : json.keySet()) {
            if (abort(json.get(key)))
                return 0;
            answer += count(json.get(key));
        }
        return answer;
    }

    private Integer countArray(JSONArray json) {
        Integer answer = 0;
        for (int index = 0; index < json.length(); index++) {
            answer += count(json.get(index));
        }
        return answer;
    }

    public abstract Boolean abort(Object o);

    private Integer count(Object o)
    {
        if (o instanceof Integer)
            return (Integer) o;
        if (o instanceof JSONObject)
            return countObject((JSONObject) o);
        if (o instanceof JSONArray)
            return countArray((JSONArray) o);
        return 0;
    }
    
}
