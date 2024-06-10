package fi.tuomax.adventofcode.year2015.day06.lightranges;

import fi.tuomax.adventofcode.year2015.day06.Command;
import fi.tuomax.adventofcode.year2015.day06.Coordinates;
import fi.tuomax.adventofcode.year2015.day06.Instruction;
import fi.tuomax.adventofcode.year2015.day06.Light;

public class LightRange 
{
    private Coordinates topLeft;

    private Long area;

    private Light light;

    public LightRange(Range horizontal, Range vertical, Light light)
    {
        topLeft = new Coordinates(horizontal.getStart(), vertical.getStart());
        area = horizontal.getLength() * vertical.getLength();
        this.light = light;
    }

    public void executeInstruction(Instruction instruction)
    {
        if (concernsThis(instruction))
            executeCommand(instruction.command());
    }

    private boolean concernsThis(Instruction instruction)
    {
        return
            topLeft.x() >= instruction.topLeft().x() &&
            topLeft.x() <= instruction.bottomRight().x() &&
            topLeft.y() >= instruction.topLeft().y() &&
            topLeft.y() <= instruction.bottomRight().y();
    }

    private void executeCommand(Command command)
    {
        light.executeCommand(command);
    }

    public Long getBrightness()
    {
        return light.getBrightness() * area;
    }

}
