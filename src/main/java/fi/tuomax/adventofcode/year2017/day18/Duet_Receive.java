package fi.tuomax.adventofcode.year2017.day18;

import java.util.Deque;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

public class Duet_Receive
extends Instruction
{

    private Argument regName;

    public static Boolean[] waitings = new Boolean[]{false, false};

    public Duet_Receive(Cpu cpu, Argument regName) 
    {
        super(cpu);
        this.regName = regName;
    }

    @Override
    public void run() 
    {
        Integer queIdx = (int) (cpu.getRegister("cpu") % Integer.MAX_VALUE);
        queIdx = (queIdx + 1) % 2;
        Deque<Long> que = Duet_Send.ques.get(queIdx);

        if (que.isEmpty()) {
            cpu.stop();
            cpu.jump(0);
            waitings[queIdx] = true;
        } else {
            cpu.setRegister(regName.getRegister(), que.pollFirst());
            waitings[queIdx] = false;
        }
    }

}
