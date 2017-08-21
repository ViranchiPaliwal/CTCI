import java.util.Stack;

/**
 * Created by viran on 19-07-2017.
 */
public class SortedStack {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public SortedStack()
    {
        s1  = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x)
    {
        if(s1.isEmpty()) {
            s1.push(x);
            return;
        }
        if(x<s1.peek())
            s1.push(x);
        else
        {
            while(!s1.isEmpty()&&x>s1.peek())
            {
                s2.push(s1.pop());
            }
            s1.push(x);
            while(!s2.isEmpty())
            {
                s1.push(s2.pop());
            }
        }
    }
    public int pop()
    {
       return s1.pop();
    }

    public int peek()
    {
        return s1.peek();
    }

    public boolean isEmpty()
    {
        return s1.isEmpty();
    }

}
