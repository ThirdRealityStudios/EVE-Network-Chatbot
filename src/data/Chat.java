package data;

import data.chat.Conversation;
import data.chat.Entry;

public class Chat
{
    private Conversation conversation;

    public Chat()
    {
        conversation = new Conversation();
    }

    public void feed(String sender, String text)
    {
        Entry entry = new Entry(sender, text);

        conversation.getEntries().add(entry);
    }

    public Entry getLatestEntry()
    {
        return conversation.getEntries().get(conversation.getEntries().size() - 1);
    }
}
