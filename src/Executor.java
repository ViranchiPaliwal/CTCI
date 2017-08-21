import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by viran on 16-07-2017.
 */
public class Executor {

    // Array and String
    public static void main(String[] args) {
        System.out.println();
        ArrayAndString obj = new ArrayAndString();
        boolean ans = obj.checkInclusion("abb", "eidbbaaodjfyjfjoo");
        System.out.println(ans);
        obj.URLify("Hey Its Really Nice to meet u            ",29);
        obj.stringCompression("aabcccccaaa");


        // LinkedList
        LinkList ll = new LinkList();
//        ListNode a = new ListNode(1);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(3);
//
//        ListNode e = new ListNode(5);
//        ListNode h = new ListNode(7);
//        ListNode i = new ListNode(7);
//
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        e.next = h;
//        h.next = i;
//        i.next=null;

        //ll.removeDups(a);

        //ll.kthelement(a,3);

        //ll.deleteMiddleNode(a);

        StackAndQueues sq = new StackAndQueues();
        sq.sortStack();

        TreeAndGraph tng = new TreeAndGraph();
        int[] ar = {2,8,15,19,27,29};
        tng.minimalTree(ar);
        tng.reverseBits(1);
        TreeNode a = new TreeNode(12);
        TreeNode b = new TreeNode(18);
        TreeNode c = new TreeNode(24);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(10);
        TreeNode f = new TreeNode(17);


        TreeNode g = new TreeNode(26);
        TreeNode h = new TreeNode(17);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
//        e.left = g;
//        g.left = h;

//        tng.listOfDepths(a);
        System.out.println( tng.checkBalanced(a));
        System.out.println("Validate BST " + tng.validateBST(a));
        tng.successor(a,b);

        RecAndDyn recndyn = new RecAndDyn();
        System.out.println(recndyn.countways(40));
        System.out.println(recndyn.bottomtotop(40));
        System.out.println(recndyn.uniquePaths(3,3));
        int[] ard={-10,-5,2,2,2,3,4,7,9,12,13};
        System.out.println(recndyn.magicFast(ard));
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }ArrayList<ArrayList<Integer>> subsets = recndyn.getSubsets(list, 0);
        ArrayList<ArrayList<Integer>> allsubsets = recndyn.getSubsetss(list, -1);

        System.out.println(subsets.toString());
        System.out.println(allsubsets.toString());
        //System.out.println(recndyn.palindrome("abcde").size());
        System.out.println(recndyn.palindromedup("aabbbacc").size());

    }

}

