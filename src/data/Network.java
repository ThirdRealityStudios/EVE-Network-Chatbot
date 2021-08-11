package data;

import net.Bridge;
import net.Node;

import java.util.ArrayList;
import java.util.Iterator;

public class Network<T>
{
    private ArrayList<Node<T>> nodes;

    public Network()
    {
        nodes = new ArrayList<Node<T>>();
    }

    // Links all Nodes with themselves, meaning in all possible directions.
    private void link(ArrayList<Node<T>> nodes)
    {
        for(Node<T> first : nodes)
        {
            for(Node<T> second : nodes)
            {
                if(!first.equals(second))
                {
                    Bridge bridge = new Bridge(second);

                    // Make sure, the same Bridge (with the same destination) does not exist yet.
                    if(!first.contains(bridge))
                    {
                        first.getBridges().add(bridge);
                    }
                }
            }
        }
    }

    // Adds the given Nodes to the Network.
    // Will not add duplicates (same destination).
    // Merges duplicates with the Bridges they contain.
    private void add(ArrayList<Node<T>> nodes)
    {
        for(Node<T> node : nodes)
        {
            int index = this.nodes.indexOf(node);

            // Make sure no duplicates are being added to the Network.
            if(index < 0)
            {
                this.nodes.add(node);
            }
            else // If there is a Node yet, just merge it, meaning the Bridges.
            {
                Node contained = this.nodes.get(index);

                for(Bridge bridge : node.getBridges())
                {
                    if(!contained.contains(bridge))
                    {
                        contained.getBridges().add(bridge);
                    }
                }
            }
        }
    }

    // Will feed the Network with more Nodes.
    // Duplicates are considered and merging is applied if needed.
    // All Nodes (of the list given) will be linked with each other.
    public void feed(ArrayList<Node<T>> nodes)
    {
        link(nodes);

        add(nodes);
    }

    public ArrayList<Node<T>> getNodes()
    {
        return nodes;
    }

    // Prints all Nodes with their connections (destinations).
    public void print()
    {
        for(int a = 0; a < nodes.size(); a++)
        {
            Node<T> node = nodes.get(a);

            System.out.println((a+1) + ". " + node.getData() + ":");

            for(int b = 0; b < node.getBridges().size(); b++)
            {
                Bridge bridge = node.getBridges().get(b);

                System.out.println(" >" + (b+1) + " " + bridge.getDestination().getData());
            }
        }
    }
}
