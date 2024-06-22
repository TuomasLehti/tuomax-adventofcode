package fi.tuomax.adventofcode.year2015.day19;

import java.util.List;
import java.util.Set;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class MedicineForRudolph_Part1 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(        
            2015, 19, 1, 
            "Medicine for Rudolph", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new MedicineForRudolph_Parser(input);
    }

    @Override
    protected void solve() 
    {
        Molecule molecule = new Molecule(
            ((MedicineForRudolph_Parser) parser).getMolecule()
        );
        Set<String> molecules = molecule.generate();
        setAnswer(molecules.size());
    }
    
}
