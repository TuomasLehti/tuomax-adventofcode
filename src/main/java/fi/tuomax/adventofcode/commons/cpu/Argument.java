package fi.tuomax.adventofcode.commons.cpu;

/**
 * An argument is either a name of a register or a number.
 */
public class Argument 
{

    private Cpu cpu = null;

    private Boolean isRegister;

    public Boolean isRegister() 
    {
        return isRegister;
    }

    private String register;

    public String getRegister() 
    {
        return register;
    }

    private Integer value;

    public Argument(String input, Cpu cpu)
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

    public Integer getValue() 
    {
        return isRegister ? cpu.getRegister(register) : value;
    }

    public String toString()
    {
        return isRegister ? register : String.valueOf(value);
    }
    
}
