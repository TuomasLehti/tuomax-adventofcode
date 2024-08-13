package fi.tuomax.adventofcode.year2016.day19;

public class Elf 
{

    public static Elf head = null;

    public int num;

    public Elf left = null;

    public Elf(Integer numOfElves, Elf left)
    {
        this.num = numOfElves;
        this.left = left;
    }

    public static void create(Integer numOfElves)
    {
        if (numOfElves == 0) return;
        Elf tail = new Elf(numOfElves, null);
        Elf.head = tail;
        for (int i = numOfElves - 1; i > 0; i--) 
            Elf.head = new Elf(i, Elf.head);
        tail.left = Elf.head;
    }

    public Boolean steal(Elf from)
    {
        if (from == this)
            return false;
        from.remove(this);
        return true;
    }

    public void remove(Elf right)
    {
        right.left = this.left;
    }

}
