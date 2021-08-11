package network;

public class Connection implements Comparable
{
    // Every connection has its value.
    // It raise or fall depending on its correctness or importance.
    // Mostly, the user has an effect on the value.
    private int value = 0;

    // The Node this Connection points to.
    private Node destination;

    public Connection(Node destination)
    {
        this.destination = destination;
    }

    public void increaseValue()
    {
        if(value < Integer.MAX_VALUE)
        {
            value++;
        }
    }

    public void decreaseValue()
    {
        if(value > Integer.MIN_VALUE)
        {
            value--;
        }
    }

    public int getValue()
    {
        return value;
    }

    public Node getDestination()
    {
        return destination;
    }

    @Override
    public int compareTo(Object o)
    {
        return ((Connection) o).value - value;
    }
}
