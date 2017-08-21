import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by viran on 20-07-2017.
 */
public class TreeAndGraph {

    public boolean routeBetweenNode(Graph root,Vertex start,Vertex end)
    {
        if(start==end) return true;
        Queue<Vertex> q = new LinkedList<>();
        start.visted=true;
        while(!q.isEmpty())
        {
            Vertex v = q.poll();
            for(Edge e : v.edges)
            {
                if(!e.toVertex.visted) {
                    if (e.toVertex == end)
                        return true;
                }
                else {
                    e.toVertex.visted = true;
                    q.add(e.toVertex);
                }
            }
        }
        return false;
    }

    public TreeNode minimalTree(int[] ar)
    {
        int l = ar.length;
        TreeNode root = buildBST(ar,0,l-1);

        return root;
    }

    public TreeNode buildBST(int[] ar, int l, int h) {
        if(l>h) {
            return null;
        }
        int mid = (l+h)/2;
        TreeNode root = new TreeNode(ar[mid]);
        root.left = buildBST(ar,l,mid-1);
        root.right =buildBST(ar,mid+1,h);
        return root;
    }

    public LinkedList<LinkedList<TreeNode>> listOfDepths(TreeNode root) {
//        if (root == null) return null;
//        Queue<TreeNode> q = new LinkedList<>();
//        LinkedList<LinkedList<TreeNode>> lol = new LinkedList<LinkedList<TreeNode>>();
//        LinkedList<TreeNode> l=new LinkedList<>();
//        q.add(root);
//        l.add(root);
//        lol.add(l);
//        int count;
//        while (!q.isEmpty()) {
//
//            l = new LinkedList<>();
//            count = q.size();
//            while (count > 0) {
//                TreeNode node = q.poll();
//                if(node.left!=null){
//                    l.add(node.left);
//                    q.add(node.left);
//                }
//                if(node.right!=null) {
//                    l.add(node.right);
//                    q.add(node.right);
//                }
//                count--;
//            }
//        if(l.size()>0)
//            lol.add(l);
//        }
//            return lol;
        LinkedList<LinkedList<TreeNode>> lol = new LinkedList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> l=new LinkedList<>();
        l.add(root);

        while (l.size()>0) {
            lol.add(l);
            LinkedList<TreeNode> temp = l;
            l = new LinkedList<>();
            for(TreeNode node : temp) {
                if (node.left != null) {
                    l.add(node.left);
                }
                if (node.right != null) {
                    l.add(node.right);
                }
            }
        }
        return lol;
    }

    public boolean checkBalanced(TreeNode root)
    {
        return calculateHeight(root)==-1 ?  false:true;
    }

    public int rangeBitwiseAnd(int m, int n) {
        if(m==0) return 0;
        int i = (int)(Math.log10(m) / Math.log10(2));
        int j = (int)(Math.log10(n) / Math.log10(2));
        if(j-i>=1)
            return 0;
        else
        return (int)(Math.pow(2,j));
    }

    public int reverseBits(int n) {
         int result = 0;
        int count=0, val = 0;

        while(count!=32)
        {
            val=(n&1);
            result =((result<<1)|val);
            n=n>>1;
            count++;
        }
        return 0;
//        String saa = "geloo mum";
//        StringBuilder s = new StringBuilder(saa).reverse();
//        s.append(new StringBuilder(saa).reverse());
//        s=s.reverse();
//        s.toString().trim()
    }
    int last = Integer.MIN_VALUE;
    public boolean validateBST(TreeNode root)
    {
        //wrong approach
//        if(root==null) return true;
//        boolean l =true;
//        boolean r = true;
//        if(root.left!=null){
//            l=root.val>=root.left.val;
//        }
//        if(root.right!=null){
//            r=root.val<=root.right.val;
//        }
//
//        return validateBST(root.left)&&validateBST(root.right)&&l&&r;

        //using preorder traversal approach
        if(root==null)
            return true;

        if(!validateBST(root.left)){
            return false;
        }


        if(last!=Integer.MIN_VALUE&&root.val<=last)
            return false;

        last= root.val;

        if(!validateBST(root.right)){
            return false;
        }
        return true;
    }

    boolean flag = false;
    public TreeNode successor(TreeNode root, TreeNode element)
    {
        if(root==null) return null;

        if(flag)
            return root;

        successor(root.left,element);
        if(element == root){
            flag=true;
        }

        successor(root.right,element);

        return null;

    }



    private int calculateHeight(TreeNode root) {
    if(root==null) return 0;

    int l = calculateHeight(root.left);
    if(l==-1) return -1;
    int r = calculateHeight(root.right);
    if(r==-1) return -1;

    if(Math.abs(l-r)>1)
        return -1;

    return Math.max(l,r)+1;
    }

//    public TreeNode minimalTree(int[] ar)
//    {
//        int l = ar.length;
//        TreeNode root = null;
//        buildBST(ar,0,l-1,root);
//        return root;
//    }
//
//    private void buildBST(int[] ar, int l, int h, TreeNode root) {
//        if(l==h) {
//            root = null;
//            return;
//        }
//        int mid = (l+h)/2;
//        root = new TreeNode(ar[mid]);
//        buildBST(ar,l,mid,root.left);
//        buildBST(ar,mid+1,h,root.right);
//
//    }
}
