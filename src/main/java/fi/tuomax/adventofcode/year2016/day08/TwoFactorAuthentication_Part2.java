package fi.tuomax.adventofcode.year2016.day08;

import fi.tuomax.adventofcode.framework.solving.Metadata;

public class TwoFactorAuthentication_Part2
extends TwoFactorAuthentication_Part1
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 8, 2, 
            "Two-Factor Authentication", ""  
        );
    }

    @Override
    protected void solve() 
    {
        super.solve();
        for (int row = 0; row < grid.height(); row++) {
            for (int col = 0; col < grid.width(); col++)
                System.out.print(grid.get(col, row) ? "#" : ".");
            System.out.println();
        }
    }
    
}
