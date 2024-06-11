package fi.tuomax.adventofcode.year2015.day07;

import java.util.HashMap;

/**
 * A base class for all the different gates of Aoc 2015 day 7. A gate has one
 * or two inputs, which may contain a number or an output of another gate.
 * <p>
 * A map of gates is passed around. The key of the map is the name of the gate,
 * and the value is the gate itself.
 */
public abstract class Gate 
{

    /**
     * The name of the first input.
     */
    private String firstInput = "";

    /**
     * Returns the name of the first input.
     * @return
     *      The name of the first input.
     */
    public String getFirstInput() 
    {
        return firstInput;
    }

    /**
     * Sets the name of the first input.
     * @param firstInput
     *      The name of the first input.
     */
    protected void setFirstInput(String firstInput) 
    {
        this.firstInput = firstInput;
    }

    /**
     * Returns the value of the first input. If the input is a number, returns
     * it, otherwise queries the gate connected to the first input for a value.
     * @param gates
     *      A map of all the gates in the system.
     * @return
     *      The value of the first input.
     */
    protected Integer getFirstInputSignal(HashMap<String, Gate> gates) 
    {
        return isNumber(getFirstInput())
            ? Integer.valueOf(getFirstInput())
            : gates.get(getFirstInput()).getOutputSignal(gates);
    }

    /**
     * The name of the second input.
     */
    private String secondInput = "";

    /**
     * Returns the name of the second input. If there is no second input in
     * this gate, returns an empty string.
     * @return
     *      The name of the second input or an empty string.
     */
    public String getSecondInput() 
    {
        return secondInput;
    }

    /**
     * Sets the name of the second input.
     * @param firstInput
     *      The name of the second input.
     */
    protected void setSecondInput(String secondInput) 
    {
        this.secondInput = secondInput;
    }

    /**
     * Returns the value of the second input. If the input is a number, returns
     * it, otherwise queries the gate connected to the second input for a value.
     * <p>
     * This method will not be called, if there is no second input.
     * @param gates
     *      A map of all the gates in the system.
     * @return
     *      The value of the second input.
     */
    protected Integer getSecondInputSignal(HashMap<String, Gate> gates) 
    {
        return isNumber(getSecondInput())
            ? Integer.valueOf(getSecondInput())
            : gates.get(getSecondInput()).getOutputSignal(gates);
    }

    /**
     * The memoization of the signal that this gate outputs.<p>
     * 
     * If the signal has not yet been calculated, the value is the minimum 
     * value of a Java Integer, which is 4 bits signed. This should be so
     * low that it doesn't get in the way of the unsigned-signed problem of
     * 2-byte words. @see #outputSignal outputSignal
     */
    private Integer outputSignal = Integer.MIN_VALUE;

    /**
     * Returns the output signal for this gate.
     * @param gates
     *      All the gates in the system. Keys are the names of the gates and
     *      values are the gates themselves.
     * @return
     *      The output signal for this gate.
     */
    public Integer getOutputSignal(HashMap<String, Gate> gates) 
    {
        if (outputSignal == Integer.MIN_VALUE)
            setOutputSignal(calculateSignal(gates));
        return outputSignal;
    }

    /**
     * Sets the output signal that this gate outputs.<p>
     * 
     * The puzzle states that all signals are between 0 and 65535, ie. they are
     * 2-byte unsigned words. In Java Integer is signed, so some bitwise 
     * operations may result a negative number. This method corrects this
     * situation and adjusts the signal so that it is always positive and fits
     * into an unsigned word.
     * 
     * @param outputSignal
     *      The output signal that this gate outputs.
     */
    protected void setOutputSignal(Integer outputSignal) 
    {
        this.outputSignal = 
            outputSignal < 0 ? outputSignal + 65536 : outputSignal;
    }

    /**
     * Resets the gate.
     */
    public void reset()
    {
        /* Setoutputsignal would map the value to 0-64k. */
        outputSignal = Integer.MIN_VALUE;
    }

    /**
     * Tells if a string can be converted to a number.
     * @param s
     *      The string.
     * @return
     *      True if the string can be converted to a number.
     */
    protected Boolean isNumber(String s) 
    {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Calculates the output signal for a gate.
     * @param gates
     *      All the gates in the system. Keys are the names of the gates and
     *      values are the gates themselves.
     * @return
     *      The output signal for this gate.
     */
    protected abstract Integer calculateSignal(HashMap<String, Gate> gates);

}
