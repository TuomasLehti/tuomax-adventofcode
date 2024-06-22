package fi.tuomax.adventofcode.year2015.day19;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class MedicineForRudolph_Part2 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(        
            2015, 19, 2, 
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
        String t = ((MedicineForRudolph_Parser) parser).getMolecule();
        int rn = 0;
        int ar = 0;
        int y  = 0;
        int e  = 0;

        for (int i = 0; i < t.length() - 1; i++) {
            String ss = t.substring(i);
            if (ss.startsWith("Rn")) rn++;
            else if (ss.startsWith("Ar")) ar++;
            else if (ss.startsWith("Y")) y++;
            if (Character.isUpperCase(ss.charAt(0))) e++;
        }

        int a = e - rn - ar - y - y - 1;
        setAnswer(String.valueOf(a));
    }
    
}
