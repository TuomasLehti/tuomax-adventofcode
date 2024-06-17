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
            if (json.get(key) instanceof Integer) {
                answer += json.getInt(key);
/*/            } else if ((json.get(key) instanceof String) && json.getString(key).equals("red")) {
                return 0;*/
            } else if (json.get(key) instanceof JSONObject) {
                answer += countObject(json.getJSONObject(key));
            } else if (json.get(key) instanceof JSONArray) {
                answer += countArray(json.getJSONArray(key));
            }
        }
        return answer;
    }

    public abstract Boolean abort(Object o);

    private Integer countArray(JSONArray json) {
        Integer answer = 0;
        for (int index = 0; index < json.length(); index++) {
            if (json.get(index) instanceof Integer) {
                answer += json.getInt(index);
            } else if (json.get(index) instanceof JSONObject) {
                answer += countObject(json.getJSONObject(index));
            } else if (json.get(index) instanceof JSONArray) {
                answer += countArray(json.getJSONArray(index));
            }
        }
        return answer;
    }
    
}
