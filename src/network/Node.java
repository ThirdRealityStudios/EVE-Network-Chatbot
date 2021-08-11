package network;

import java.util.ArrayList;

public class Node<T>
{
    private T data;

    private ArrayList<Connection> connections;

    public Node(T data)
    {
        this.data = data;

        connections = new ArrayList<Connection>();
    }

    public T getData()
    {
        return data;
    }

    public ArrayList<Connection> getConnections()
    {
        return connections;
    }
}
