package fi.tuomax.adventofcode.y2015.d06;

public class Light_Part1 
extends Light
{

    private Boolean lit = false;

    @Override
    public void executeCommand(Command command) 
    {
        switch (command) {
            case OFF:
                lit = false;
                break;
            case ON:
                lit = true;
                break;
            case TOGGLE:
                lit = !lit;
                break;
        }
    }

    @Override
    public Integer getBrightness() {
        return lit ? 1 : 0;
    }
    
}
