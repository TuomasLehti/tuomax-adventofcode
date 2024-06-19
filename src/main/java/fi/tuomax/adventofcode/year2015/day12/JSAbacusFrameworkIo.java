package fi.tuomax.adventofcode.year2015.day12;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solving logic for Advent of Code 2015, day 12.
 * JSAbacusFramework.io.
 * @see 
 *      <a href="https://adventofcode.com/2015/day/12">
 *      Puzzle on the Advent of Code website.</a>
 */
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

    /**
     * Counter methods go through the child objects one at a time. Object's and
     * array's childs are fetched through different methods, why there are two
     * methods here as well. The actual counting of a child object is carried 
     * out in ```count```-method.
     */
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

    /** 
     * If there is a need to not count a certain JSON object and it's childs, 
     * this method does the trick and aborts counting for a given object.
     */
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
