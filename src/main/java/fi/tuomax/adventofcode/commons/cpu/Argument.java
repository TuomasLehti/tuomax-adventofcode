package fi.tuomax.adventofcode.commons.cpu;

/**
 * An argument is either a name of a register or a number.
 */
public class Argument 
{

    private Cpu cpu = null;

    private Boolean isRegister;

    /**
     * Tells if this argument refers to a register.
     * @return
     *      True if the argument refers to a register.
     */
    public Boolean isRegister() 
    {
        return isRegister;
    }

    private String register;

    /**
     * Returns the name of the register which this argument refers to.
     * @return
     *      The name of the register.
     */
    public String getRegister() 
    {
        return register;
    }

    private Integer value;

    public Argument(Cpu cpu, String input)
    {
        this.cpu = cpu;
        try {
            value = Integer.valueOf(input);
            isRegister = false;
        } catch (NumberFormatException e) {
            register = input;
            isRegister = true;
        }
    }

    /**
     * Returns the value this instruction refers to. In the case of an 
     * immediate value returns the value in question. In the case of a register
     * returns the value in the register in question.
     * @return
     *      The value this instruction refers to.
     */
    public Long getValue() 
    {
        return isRegister ? cpu.getRegister(register) : value;
    }

    /**
     * Returns the value this instruction refers to as a string. In the case of 
     * an immediate value returns the value in question. In the case of a 
     * register returns the value in the register in question.
     * @return
     *      The value this instruction refers to as a string.
     */

    public String toString()
    {
        return isRegister ? register : String.valueOf(value);
    }
    
}
