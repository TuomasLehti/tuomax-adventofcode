package fi.tuomax.adventofcode.year2016.day19;

/**
 * A linked list of elves was the chosen approach for Advent of Code 2016, 
 * day 19.
 */
public class Elf 
{

    public static Elf head = null;

    public int num;

    public Elf left = null;

    public Elf right = null;

    public Elf(Integer numOfElves, Elf left)
    {
        this.num = numOfElves;
        this.left = left;
        if (this.left != null)
            left.right = this;
    }

    /**
     * Creates a circle of elves.
     */
    public static void create(Integer numOfElves)
    {
        if (numOfElves == 0) return;

        /* The numOfElves keeps getting, which is why the construction of the 
         * circle is started from the tail of the linked list. */
        Elf tail = new Elf(numOfElves, null);
        Elf.head = tail;
        for (int i = numOfElves - 1; i > 0; i--) 
            Elf.head = new Elf(i, Elf.head);
        tail.left = Elf.head;
        Elf.head.right = tail;
    }

    public Boolean steal(Elf from)
    {
        if (from == this)
            return false;
        from.remove();
        return true;
    }

    public void remove()
    {
        right.left = this.left;
        left.right = this.right;
    }

}
