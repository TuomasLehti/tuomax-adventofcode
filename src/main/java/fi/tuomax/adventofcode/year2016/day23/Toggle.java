package fi.tuomax.adventofcode.year2016.day23;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.Copy;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Increment;
import fi.tuomax.adventofcode.commons.cpu.Instruction;
import fi.tuomax.adventofcode.year2016.day12.JumpIfNotZero;

public class Toggle 
extends Instruction
{

    private Argument offset;

    public Argument getOffset() 
    {
        return offset;
    }

    public Toggle(Cpu cpu, Argument offset)
    {
        super(cpu);
        this.offset = offset;
    }

    @Override
    public void run() 
    {
        Integer targetAddr = cpu.getProgramCounter() + (int) (offset.getValue() % Integer.MAX_VALUE);
        Instruction targetInst = null;
        try {
            targetInst = cpu.getInstruction(targetAddr);
        } catch (IndexOutOfBoundsException e) {
            return;
        }

        if (targetInst instanceof Increment) {
            Increment incInst = (Increment) targetInst;
            if (incInst.getAmount().getValue().equals(1L))
                cpu.setInstruction(targetAddr, 
                    new Increment(cpu,
                        incInst.getAccumulator(),
                        new Argument(cpu, "-1")
                    )
                );
            else
                cpu.setInstruction(targetAddr, 
                    new Increment(cpu,
                        incInst.getAccumulator(),
                        new Argument(cpu, "1")
                    )
                );
        } else if (targetInst instanceof Toggle) {
            cpu.setInstruction(targetAddr, 
                new Increment(cpu,
                    ((Toggle) targetInst).getOffset(),
                    new Argument(cpu, "1")
                )
            );
        } else if (targetInst instanceof Copy) {
            // cpy src dest -> jnz cond ofs
            cpu.setInstruction(targetAddr, 
                new JumpIfNotZero(cpu, 
                    ((Copy) targetInst).getSource(),
                    ((Copy) targetInst).getDestination()
                )
            );
        } else if (targetInst instanceof JumpIfNotZero) {
            // jnz cond ofs -> cpy src dest
            cpu.setInstruction(targetAddr, 
                new Copy(cpu, 
                    ((JumpIfNotZero) targetInst).getCondition(),
                    ((JumpIfNotZero) targetInst).getOffset()
                )
            );
        }
    }

}
