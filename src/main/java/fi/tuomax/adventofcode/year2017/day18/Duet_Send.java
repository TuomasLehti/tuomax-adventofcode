package fi.tuomax.adventofcode.year2017.day18;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

public class Duet_Send
extends Instruction
{

    /**
     * Message queues. The index to the list is the index of the cpu which
     * has sent the messages.
     */
    public static List<Deque<Long>> ques = new ArrayList<>();

    static
    {
        ques.add(new ArrayDeque<>());
        ques.add(new ArrayDeque<>());
    }

    public static Integer[] sent = new Integer[]{0,0};
    
    private Argument sound;

    public Duet_Send(Cpu cpu, Argument sound) 
    {
        super(cpu);
        this.sound = sound;
    }

    @Override
    public void run() 
    {
        Integer queIdx = (int) (cpu.getRegister("cpu") % Integer.MAX_VALUE);
        Deque<Long> que = ques.get(queIdx);
        que.addLast(sound.getValue());
        sent[queIdx]++;
    }

}
