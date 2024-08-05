package fi.tuomax.adventofcode.year2016.day13;

import java.util.HashSet;
import java.util.Set;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.DfsState;
import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.commons.Direction.DirectionMode;
import fi.tuomax.adventofcode.commons.Direction.TurnDirection;

public class CubicleDfsState 
extends DfsState
{

    public static Coordinates target = null;

    private Coordinates current = new Coordinates(1L, 1L);

    public Coordinates getCurrent() 
    {
        return current;
    }

    public CubicleDfsState()
    {
        Direction.directionMode = DirectionMode.FOUR_DIRS;
    }

    public CubicleDfsState(CubicleDfsState from)
    {
        this.current = new Coordinates(from.current.x(), from.current.y());
        this.setStep(from.getStep() + 1);
    }

    @Override
    public Set<DfsState> nextStates() 
    {
        Set<DfsState> nextStates = new HashSet<>();

        Direction dir = Direction.getInstance(Direction.NORTH);

        for (int i = 0; i < 4; i++) {
            current = current.translate(dir.asCoordinates());
            if (!MazeGenerator.isWall(current)) {
                nextStates.add(manufactureState());
            }
            dir.turn(TurnDirection.RIGHT);
            dir.turn(TurnDirection.RIGHT);
            current = current.translate(dir.asCoordinates());
            dir.turn(TurnDirection.LEFT);
        }
        return nextStates;
    }

    @Override
    public Boolean isTargetState() 
    {
        return current.equals(target);
    }

    protected DfsState manufactureState()
    {
        return new CubicleDfsState(this);
    }

    @Override
    public String toString()
    {
        return getStep().toString() + current.toString();
    }

    public void print(int xSize, int ySize)
    {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (MazeGenerator.isWall(x, y)) sb.append("#");
//                else if (visited.contains(new Coordinates((long)x, (long)y))) sb.append("O");
                else sb.append(".");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof CubicleDfsState)) return false;
        CubicleDfsState other = (CubicleDfsState) o;
        return this.current.equals(other.current);
    }
    
}
