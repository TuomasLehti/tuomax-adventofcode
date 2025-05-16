package fi.tuomax.adventofcode.year2017.day17;

public class Spinlock 
{

    private int value;

    public int getValue() 
    {
        return value;
    }

    private Spinlock next;

    public Spinlock getNext() 
    {
        return next;
    }

    private boolean head;

    public Spinlock()
    {
        value = 0;
        head = true;
        next = this;
    }

    private Spinlock(int value, Spinlock next)
    {
        this.value = value;
        this.next = next;
        this.head = false;
    }

    public Spinlock add(int steps, int value)
    {
        Spinlock spinlock = this;
        for (int step = 0; step < steps; step++) {
            spinlock = spinlock.getNext();
        }
        Spinlock newSpinlock = new Spinlock(value, spinlock.next);
        spinlock.next = newSpinlock;
        return spinlock.next;
    }

    public void print(StringBuilder sb, int currentPosition)
    {
        if (value == currentPosition) {
            sb.append(" (" + value + ")");
        } else {
            sb.append(" " + value);
        }
        if (!next.head) {
            next.print(sb, currentPosition);
        }
    }
    
}
