package fi.tuomax.adventofcode.year2022.day13;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;

/**
 * <p>Solves Advent of Code 2022, day 13, part 2:
 * Distress Signal.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/13">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class DistressSignal_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 13, 2,
            "Distress Signal", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new DistressSignal_Parser(input);
    }

    @Override
    protected void solve()
    {
        List<JSONArray> packets = ((DistressSignal_Parser) parser).getPackets();

        final String DIVIDER_PACKETS_JSON_NAME = "divider_packets";
        JSONArray firstDivider = new JSONArray(
            getParamStr(DIVIDER_PACKETS_JSON_NAME).split("\n")[0]); 
        JSONArray secondDivider = new JSONArray(
            getParamStr(DIVIDER_PACKETS_JSON_NAME).split("\n")[1]); 
        packets.add(firstDivider);
        packets.add(secondDivider);

        Collections.sort(packets, new Comparator<JSONArray>() {
            @Override
            public int compare(JSONArray o1, JSONArray o2) {
                switch (PacketComparer.inOrder(o1, o2)) {
                    case FALSE:         return 1;
                    case TRUE:          return -1;
                    default:            return 0;
                }
            }
        });

        setAnswer(
            (packets.indexOf(firstDivider) + 1) * 
            (packets.indexOf(secondDivider) + 1)
        );
    }

}
