/**
 * Created by viran on 19-07-2017.
 */
public class StackAndQueues {

    public void sortStack()
    {
        SortedStack s = new SortedStack();
        s.push(10);
        s.push(5);
        s.push(15);
        s.push(7);
        s.push(13);
        System.out.println(s.peek());
       while(!s.isEmpty()) {
           System.out.println(s.pop());
       }
    }
}
