package fi.tuomax.adventofcode.year2017.day24;

public class Component 
{
    
    private Integer leftPort;
    
    private Integer rightPort;

    private Boolean leftConnected = false;

    private Boolean rightConnected = false;

    private Component(Integer leftPort, Integer rightPort)
    {
        this.leftPort = leftPort;
        this.rightPort = rightPort;
    }

    public static Component fromAocInput(String input)
    {
        String[] parts = input.split("/");
        return new Component(
            Integer.valueOf(parts[0]),
            Integer.valueOf(parts[1])
        );
    }

    public static Component getStarterInstance()
    {
        Component starter = new Component(0, 0);
        starter.leftConnected = true;
        return starter;
    }

    public Integer getLength()
    {
        return leftPort + rightPort;
    }

    /* Assumes other is not connected. 
     * Assumes this is connected from one end. */
    public Boolean isConnectableTo(Component other)
    {
        Integer freePort = leftConnected ? rightPort : leftPort;
        return freePort.equals(other.leftPort) || freePort.equals(other.rightPort);
    }

    /* Assumes other is not connected.
     * Assumes this is connected from one end. */
    public void connectTo(Component other)
    {
        Integer freePort = leftConnected ? rightPort : leftPort;
        if (freePort.equals(other.leftPort))
            other.leftConnected = true;
        else
            other.rightConnected = true;
        rightConnected = true;
        leftConnected = true;
    }

    public void disconnectFrom(Component other)
    {
        Integer connectedPort = other.leftConnected ? other.leftPort : other.rightPort;
        if (connectedPort.equals(leftPort)) 
            leftConnected = false;
        else
            rightConnected = false;
        other.rightConnected = false;
        other.leftConnected = false;
    }

    @Override
    public int hashCode()
    {
        return leftPort * rightPort;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Component)) return false;
        Component other = (Component) o;
        return 
            this.rightPort.equals(other.rightPort) &&
            this.leftPort.equals(other.leftPort);
    }

    @Override
    public String toString()
    {
        return leftPort + "/" + rightPort;
    }
    
}
