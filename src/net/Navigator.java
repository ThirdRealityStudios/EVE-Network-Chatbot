package net;

import java.util.ArrayList;
import java.util.Iterator;

public class Navigator<T>
{
    public ArrayList<Node<T>> nodes;

    private int start = -1;

    private int maxConnections = 6;

    public Navigator(ArrayList<Node<T>> nodes)
    {
        nodes = new ArrayList<Node<T>>();
    }

    public void open(Node<T> start)
    {
        this.start = lookup(start);
    }

    // Looks up the address of the Node in the list.
    // Returns -1 if there is none.
    private int lookup(Node<T> node)
    {
        return nodes.indexOf(node);
    }

    // Looks up the best bridge for a Node to another Node (by judging the 'value' of it).
    // Returns null if there is no bridge.
    private Bridge lookup(ArrayList<Bridge> bridges)
    {
        Iterator<Bridge> iterator = bridges.iterator();

        Bridge best = null;

        for(int i = 0; i < maxConnections && iterator.hasNext(); i++)
        {
            Bridge current = iterator.next();

            if(best == null || !best.equals(current) && current.getValue() >= best.getValue())
            {
                best = current;
            }
        }

        return best;
    }

    // Traces a possible connection to other Nodes as a Result.
    // The address (index of every single Node) is returned.
    public Result traceAll()
    {
        ArrayList<Integer> result = new ArrayList<Integer>();

        result.add(start);

        // Load the first Node given by the 'start' index.
        Node<T> current = nodes.get(start);

        // Best Connection found.
        Bridge best = null;

        // Make sure with the for-loop that there is no dead-circle possible if a Connection points at itself.
        for(int i = 0; i < maxConnections; i++)
        {
            // Find the best way (Bridge) to continue the 'track'.
            best = lookup(current.getBridges());

            if(best == null)
            {
                break;
            }

            current = best.getDestination();

            if(current == null)
            {
                break;
            }

            int nodeIndex = nodes.indexOf(current);

            // Extend the result.
            result.add(nodeIndex);
        }

        return new Result(result);
    }
}
