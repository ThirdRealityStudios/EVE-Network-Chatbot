package network;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class NodeProvider
{
    public ArrayList<Node> nodes;

    private int start = -1;

    private int maxConnections = 6;

    public NodeProvider()
    {
        nodes = new ArrayList<Node>();
    }

    public void open(Node start)
    {
        this.start = lookup(start);
    }

    // Looks up the address of the Node in the list.
    // Returns -1 if there is none.
    private int lookup(Node node)
    {
        return nodes.indexOf(node);
    }

    // Looks up the best connection for a Node to another Node (by judging the 'value' of it).
    // Returns null if there is no connection.
    private Connection lookup(ArrayList<Connection> connections)
    {
        Iterator<Connection> iterator = connections.iterator();

        Connection best = null;

        for(int i = 0; i < maxConnections && iterator.hasNext(); i++)
        {
            Connection current = iterator.next();

            if(best == null || !best.equals(current) && current.getValue() >= best.getValue())
            {
                best = current;
            }
        }

        return best;
    }

    // Traces a possible way to other Nodes.
    // The address (index of every single Node) is returned.
    public ArrayList<Integer> traceAll()
    {
        ArrayList<Integer> track = new ArrayList<Integer>();

        track.add(start);

        // Load the first Node given by the 'start' index.
        Node current = nodes.get(start);

        // Best Connection found.
        Connection best = null;

        // Make sure with the for-loop that there is no dead-circle possible if a Connection points at itself.
        for(int i = 0; i < maxConnections; i++)
        {
            // Find the best way (Connection) to continue the 'track'.
            best = lookup(current.getConnections());

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

            // Extend the track.
            track.add(nodeIndex);
        }

        return track;
    }
}
