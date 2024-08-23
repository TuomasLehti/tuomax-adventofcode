package fi.tuomax.adventofcode.year2016.day11;

import java.util.List;

import fi.tuomax.adventofcode.commons.Bfs;
import fi.tuomax.adventofcode.commons.BfsState;
import fi.tuomax.adventofcode.framework.parsing.NoopParser;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class RadioisotopeThermoelectricGenerators_Part2 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 11, 2,
            "Radioisotope Thermoelectric Generators", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new NoopParser(input);
    }

    @Override
    protected void solve() 
    {
        Bfs dfs = new Bfs();
        BfsState ans = dfs.search(new RtfDfsState(new int[]{11, 11, 11, 32, 32, 32, 32}));
        if (ans != null)
            setAnswer(ans.getStep());
        else
            setAnswer(-1);
    }
    
}
