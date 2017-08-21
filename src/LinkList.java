import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by viran on 17-07-2017.
 */
public class LinkList {

    public ListNode removeDups(ListNode head)
    {
        // first approach
//        if(head==null ) return head;
//        ListNode node = head;
//        ListNode prev = null;
//        Set<Integer> set = new HashSet<>();
//
//        while(node!=null)
//        {
//            if(set.contains(node.val))
//            {
//                prev.next=node.next;
//            }
//            else
//            {
//                set.add(node.val);
//                prev=node;
//            }
//            node=node.next;
//        }
//
//        return head;

        // second approach
        if(head==null ) return head;
        ListNode p1 = head;
        ListNode p2 = null;
        ListNode prev = null;

        //Set<Integer> set = new HashSet<>();

        while(p1!=null)
        {
            prev = p1;
            p2 = p1.next;

            while(p2!=null)
            {
                if(p1.val==p2.val)
                {
                    prev.next=p2.next;
                }
                else
                {
                    prev = p2;
                }
                p2=p2.next;
            }
            p1=p1.next;
        }

        return head;
    }

    public ListNode kthelement(ListNode head, int k)
    {
        if(head==null) return head;
        ListNode kth = head;
        ListNode node = head;
        int count = 1;
        while(node!=null)
        {
            if(count>k)
                kth = kth.next;
            node=node.next;
            count++;
        }
        return kth;
    }

    public void deleteMiddleNode(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast.next!=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;



    }
}
