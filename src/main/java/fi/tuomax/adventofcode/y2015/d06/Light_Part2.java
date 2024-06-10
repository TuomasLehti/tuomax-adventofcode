package fi.tuomax.adventofcode.y2015.d06;

public class Light_Part2
extends Light
{

    private Integer brightness = 0;

    @Override
    public void executeCommand(Command command) 
    {
        switch (command) {
            case OFF:
                if (brightness > 0) brightness--;
                break;
            case ON:
                brightness++;
                break;
            case TOGGLE:
                brightness += 2;
                break;
        }
    }

    @Override
    public Integer getBrightness() {
        return brightness;
    }
    
}
