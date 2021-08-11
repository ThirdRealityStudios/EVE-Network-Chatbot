package data.chat;

import net.Node;

import java.util.ArrayList;

public class Processor
{
    // Converts all words to Nodes.
    public ArrayList<Node<String>> read(Entry entry)
    {
        ArrayList<Node<String>> nodes = new ArrayList<Node<String>>();

        String[] words = entry.getMessage().split(" ");

        for(String word : words)
        {
            nodes.add(new Node<String>(word));
        }

        return nodes;
    }
}
