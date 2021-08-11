import net.Bridge;
import net.Node;
import net.Navigator;
import net.Result;

public class Main
{
    public static void main(String[] args)
    {
        //Chat chat = new Chat();

        //chat.chat();

        Navigator nP = new Navigator();

        Node start = new Node<String>("Hallo");

        Node middle0 = new Node<String>("Wie geht es dir?");
        Node middle1 = new Node<String>("Hi");

        Node next0 = new Node<String>("Gut");

        Bridge bridgeMiddle0 = new Bridge(middle0);
        bridgeMiddle0.increaseValue();

        Bridge bridgeMiddle1 = new Bridge(middle1);
        bridgeMiddle1.decreaseValue();

        Bridge bridgeNext0 = new Bridge(next0);
        bridgeNext0.increaseValue();

        middle0.getBridges().add(bridgeNext0);

        next0.getBridges().add(bridgeMiddle0);

        start.getBridges().add(bridgeMiddle0);
        start.getBridges().add(bridgeMiddle1);

        nP.nodes.add(start);
        nP.nodes.add(middle0);
        nP.nodes.add(middle1);
        nP.nodes.add(next0);

        nP.open(start);

        Result result = nP.traceAll();

        for(Integer i : result.getResult())
        {
            System.out.println("> " + nP.nodes.get(i).getData());
        }
    }
}
