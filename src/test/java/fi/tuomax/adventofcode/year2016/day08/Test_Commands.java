package fi.tuomax.adventofcode.year2016.day08;

import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class Test_Commands 
extends PuzzleTester
{

    @Test
    public void test()
    {
        readJson(new Metadata(2016, 8, null, null, null), "tests.json");
        JSONArray suite = json.getJSONArray("part1");
        Grid<Boolean> grid = new Grid<>(json.getInt("width"), json.getInt("height"));
        for (int row = 0; row < grid.height(); row++)
            for (int col = 0; col < grid.width(); col++)
                grid.set(col, row, false);
        for (Object o : suite) {
            JSONObject testcase = (JSONObject) o;
            String cmdStr = testcase.getString("command");
            String answer = testcase.getString("answer");
            Command command = Command.fromInput(cmdStr);
            command.actOn(grid);
            StringBuilder gridStr = new StringBuilder();
            for (int row = 0; row < grid.height(); row++)
                for (int col = 0; col < grid.width(); col++)
                    gridStr.append(grid.get(col, row) ? "#" : ".");
            assertEquals(cmdStr, answer, gridStr.toString());
        }
    }
    
}