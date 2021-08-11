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
}
