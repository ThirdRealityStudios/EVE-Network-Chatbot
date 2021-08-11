import network.Node;

import java.io.Serializable;
import java.util.ArrayList;

public class Bot implements Serializable
{
    private static final long serialVersionUID = 3L;

    // By default "EVE".
    private String name = "EVE";

    // Minimum rate for the match of EVEs dictionary and a suitable answer (regarding the entry).
    private float matchQuote = 0.85f;

    // Amount of maximum answers delivered by a request / entry (randomly).
    private int maxAnswers = 5;

    // This is the level which EVE uses to "forget" or delete unnecessary information
    // if the priority of that information goes below that value.
    // The value should always be a little negative as EVE also has a failure rate.
    // Might also be good to receive some more random answers..
    private int minimumImportance = -5;

    private ArrayList<Node> dictionary;

    // Connects the Nodes with each other in the conversation.
    public void process(ArrayList<Node> conversation)
    {
        if(conversation.size() > 1)
        {
            Node last = conversation.get(conversation.size() - 2);
            Node current = conversation.get(conversation.size() - 1);

            if(!last.equals(current))
            {
                //last.getConnections().
            }
        }
    }

    public void setMinimumImportance(int importanceLevel)
    {
        this.minimumImportance = importanceLevel;
    }

    public int getMinimumImportance()
    {
        return minimumImportance;
    }

    public void setMinimumMatchQuote(float quote)
    {
        this.matchQuote = quote;
    }

    public float getMinimumMatchQuote()
    {
        return matchQuote;
    }

    public void setMaxAnswers(int max)
    {
        this.maxAnswers = max;
    }

    public float getMaxAnswers()
    {
        return maxAnswers;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public float getMatchQuote()
    {
        return matchQuote;
    }
}
