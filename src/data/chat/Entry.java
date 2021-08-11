package data.chat;

import java.io.Serializable;

public class Entry implements Serializable
{
    private String sender, message;

    public Entry(String sender, String message)
    {
        this.sender = sender;
        this.message = message;
    }

    public String getSender()
    {
        return sender;
    }

    public String getMessage()
    {
        return message;
    }
}
