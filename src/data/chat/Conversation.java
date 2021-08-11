package data.chat;

import java.io.Serializable;
import java.util.ArrayList;

public class Conversation implements Serializable
{
    private ArrayList<Entry> entries;

    public Conversation()
    {
        entries = new ArrayList<Entry>();
    }

    public ArrayList<Entry> getEntries()
    {
        return entries;
    }
}
