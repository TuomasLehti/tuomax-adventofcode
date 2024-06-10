package fi.tuomax.adventofcode.year2015.day06.singlelights;

import fi.tuomax.adventofcode.framework.solving.Solver;
import fi.tuomax.adventofcode.year2015.day06.Grid;
import fi.tuomax.adventofcode.year2015.day06.Instruction;
import fi.tuomax.adventofcode.year2015.day06.Light;
import fi.tuomax.adventofcode.year2015.day06.ProbablyAFireHazard_Parser;

/** 
 * <p>Solving logic for Advent of Code 2015, part 6:
 * Probably a Fire Hazard</p>
 * 
 * <p>This is the brute force solution. It goes through the lights one by one
 * turning them, which can be quite as slow, if the size of the grid of lights
 * grows large. In this instance we have a grid of million lights, which, I
 * guess, isn't that much for a modern computer, since this algorithm doesn't
 * appear to be that slow after all.</p>
 * 
 * @see 
 *      <a href="https://adventofcode.com/2015/day/6">
 *      Puzzle on the Advent of Code website.</a>
 */
public abstract class PropablyAFireHazard_SingleLights
extends Solver
{

    private final Integer WIDTH = 1000;

    private final Integer HEIGHT = 1000;

    private Grid<Light> lights = new Grid<>(WIDTH, HEIGHT);

    @Override
    protected void solve() 
    {
        initializeLights();
        runCommands();
        countBrightness();
    }

    private void initializeLights() 
    {
        for (int r = 0; r < HEIGHT; r++) {
            for (int c = 0; c < WIDTH; c++) {
                lights.set(c, r, getLightInstance());
            }
        }
    }

    private void runCommands() 
    {
        for (Instruction instruction : (ProbablyAFireHazard_Parser) parser) {
            Integer firstRow = instruction.topLeft().yAsInt();
            Integer lastRow = instruction.bottomRight().yAsInt();
            Integer firstCol = instruction.topLeft().xAsInt();
            Integer lastCol = instruction.bottomRight().xAsInt();
            for (int r = firstRow; r <= lastRow; r++) {
                for (int c = firstCol; c <= lastCol; c++) {
                    lights.get(c, r).executeCommand(instruction.command());
                }
            }
        }
    }

    private void countBrightness() 
    {
        Long result = 0l;
        for (int r = 0; r < HEIGHT; r++) {
            for (int c = 0; c < WIDTH; c++) {
                result += lights.get(c, r).getBrightness();
            }
        }
        setAnswer(result);
    }

    protected abstract Light getLightInstance();
    
}
