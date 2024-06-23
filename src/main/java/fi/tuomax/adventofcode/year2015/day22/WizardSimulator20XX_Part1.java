package fi.tuomax.adventofcode.year2015.day22;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.NoopParser;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class WizardSimulator20XX_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 22, 1,
            "Wizard Simulator 20XX", ""
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
        Game game = new Game(1);
        game.turn();
        setAnswer(Game.minMana);
    }
    
}
