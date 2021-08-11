package net;

import java.util.ArrayList;

public class Node<T>
{
    private T data;

    private ArrayList<Bridge> bridges;

    public Node(T data)
    {
        this.data = data;

        bridges = new ArrayList<Bridge>();
    }

    public T getData()
    {
        return data;
    }

    public ArrayList<Bridge> getBridges()
    {
        return bridges;
    }

    // Tests whether a Bridge is contained already (regardless of its 'value').
    // true: the checked destinations are both the same.
    public boolean contains(Bridge bridge)
    {
        for(Bridge compared : bridges)
        {
            if(bridge.getDestination().equals(compared.getDestination()))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object o)
    {
        return ((Node<T>) o).getData().equals(getData());
    }
}
