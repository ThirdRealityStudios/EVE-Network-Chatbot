import network.Connection;
import network.Node;
import network.NodeProvider;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        //Chat chat = new Chat();

        //chat.chat();

        NodeProvider nP = new NodeProvider();

        Node start = new Node<String>("Hallo");

        Node middle0 = new Node<String>("Wie geht es dir?");
        Node middle1 = new Node<String>("Hi");

        Node next0 = new Node<String>("Gut");

        Connection connectionMiddle0 = new Connection(middle0);
        connectionMiddle0.increaseValue();
        connectionMiddle0.decreaseValue();
        connectionMiddle0.decreaseValue();

        Connection connectionMiddle1 = new Connection(middle1);

        Connection connectionNext0 = new Connection(next0);
        connectionNext0.increaseValue();

        middle0.getConnections().add(connectionNext0);

        start.getConnections().add(connectionMiddle0);
        start.getConnections().add(connectionMiddle1);

        nP.nodes.add(start);
        nP.nodes.add(middle0);
        nP.nodes.add(middle1);
        nP.nodes.add(next0);

        nP.open(start);

        ArrayList<Integer> track = nP.traceAll();

        for(Integer i : track)
        {
            System.out.println("> " + nP.nodes.get(i).getData());
        }
    }
}
