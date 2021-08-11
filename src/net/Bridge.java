package net;

public class Bridge implements Comparable
{
    // Every bridge has its value.
    // It raises or falls depending on its correctness or importance.
    // Mostly, the user has an effect on the value.
    private int value = 0;

    // The Node this Bridge points to.
    private Node destination;

    public Bridge(Node destination)
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
        return ((Bridge) o).value - value;
    }
}
