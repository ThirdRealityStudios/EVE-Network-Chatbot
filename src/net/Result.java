package net;

import java.util.ArrayList;

// Represents a combination of Nodes with an order.
public class Result
{
    // Contains the result of the Navigator which has found a possible solution (combination of Nodes).
    private int[] result;

    // The value of this result. The higher, the better.
    private int value;

    public Result(ArrayList<Integer> result)
    {
        this.result = new int[result.size()];

        for(int i = 0; i < result.size(); i++)
        {
            this.result[i] = result.get(i);
        }
    }

    public int[] getResult()
    {
        return result;
    }

    public void increaseValue()
    {
        value++;
    }

    public void decreaseValue()
    {
        value--;
    }

    public int getValue()
    {
        return value;
    }
}
