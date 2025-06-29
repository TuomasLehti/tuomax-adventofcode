package fi.tuomax.adventofcode.year2017.day20;

import java.util.HashSet;
import java.util.Set;

public class QuadraticEquation 
{

    private float a;

    protected float getA() 
    {
        return a;
    }

    private float b;

    protected float getB() 
    {
        return b;
    }

    private float c;

    protected float getC() 
    {
        return c;
    }

    private Set<Float> solutions = new HashSet<>();

    public Set<Float> getSolutions() 
    {
        return solutions;
    }

    public QuadraticEquation(float a, float b, float c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        solve();
    }

    /**
     * Generates a quadratic equation from three coordinates: 
     * (0, yCoords[0])
     * (1, yCoords[1])
     * (2, yCoords[2])
     * @param yCoords
     *      The y coordinates.
     * @return
     *      The equation.
     */
    public static QuadraticEquation fromThreePoints(Long[] yCoords)
    {
        float a = (yCoords[2] + yCoords[0] - 2 * yCoords[1]) / 2f;
        float b = (4 * yCoords[1] - 3 * yCoords[0] - yCoords[2]) / 2f;
        float c = (float) yCoords[0];
        return new QuadraticEquation(a, b, c);
    }

    private void solve()
    {
        /* The solution(s) of an equation is/are it's crossing point(s) with the x-axis. */
        if (isHorizontalLine())
            return;
        if (isStraightLine()) {
            /* The equation simplifies to bx + c = 0 */
            solutions.add(-c / b);
            return;
        }
        /* It is a quadratic equation. */
        Float discriminant = b * b - 4 * a * c;
        if (discriminant < 0) return;
        solutions.add((-b + (float) Math.sqrt(discriminant)) / (2 * a));
        solutions.add((-b - (float) Math.sqrt(discriminant)) / (2 * a));
    }

    public Boolean isStraightLine()
    {
        return (Math.abs(a) < 0.0001);
    }

    public Boolean isHorizontalLine()
    {
        return (Math.abs(a) < 0.0001) && (Math.abs(b) < 0.0001);
    }

    public float getY(float atX)
    {
        return a * atX * atX + b * atX + c;
    }

    public int numOfRealSolutions()
    {
        Float discriminant = b * b - 4 * a * c;
        if (Math.abs(discriminant) < 0.001f) return 1;
        else if (discriminant > 0) return 2;
        else return 0;
    }

    public Boolean intersects(QuadraticEquation other)
    {
        QuadraticEquation sum = new QuadraticEquation(
            getA() - other.getA(), 
            getB() - other.getB(), 
            getC() - other.getC()
        );
        return sum.numOfRealSolutions() > 0;
    }

    public boolean equals(Object o)
    {
        if (o == null || (!(o instanceof QuadraticEquation))) return false;
        if (o == this) return true;
        QuadraticEquation other = (QuadraticEquation) o;
        return 
            Math.abs(this.a - other.a) < 0.0001 &&
            Math.abs(this.b - other.b) < 0.0001 &&
            Math.abs(this.c - other.c) < 0.0001;
    }
    
}
