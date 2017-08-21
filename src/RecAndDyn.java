import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by viran on 20-08-2017.
 */
public class RecAndDyn {
    public int countways(int n) {
        int[] m = new int[n + 1];
        Arrays.fill(m, -1);
        //return toptobottom(n,m);
        return bottomtotop(n);
    }

    private int toptobottom(int n, int[] m) {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else if (m[n] != -1)
            return m[n];
        else {
            m[n] = toptobottom(n - 1, m) +
                    toptobottom(n - 2, m) +
                    toptobottom(n - 3, m);
            return m[n];
        }

    }


    public int bottomtotop(int n) {
        int[] m = new int[n + 1];
        m[1] = 1;
        m[2] = 2;
        m[3] = 4;
        for (int i = 4; i <= n; i++) {
            m[i] = m[i - 1] + m[i - 2] + m[i - 3];
        }
        return m[n];
    }

    public int uniquePaths(int m, int n) {
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = -1;
            }
        }
        return rec(m - 1, n - 1, mat);
    }

    public int rec(int m, int n, int[][] mat) {
        if (m < 0 || n < 0)
            return 0;
        else if (m == 0 && n == 0)
            return 1;
        else if (mat[m][n] != -1) {
            return mat[m][n];
        } else {
            mat[m][n] = rec(m - 1, n, mat) + rec(m, n - 1, mat);
            return mat[m][n];
        }
    }

    public int magicFast(int[] a) {
        //for repetetitive
        return magicbinary(a, 0, a.length - 1);
    }

    private int magicbinary(int[] a, int s, int e) {
        if (e < s) return -1;
        int m = (s + e) / 2;
        int val = a[m];
        if (m == val) return m;
        int left = Math.min(m - 1, a[m]);
        int l = magicbinary(a, s, left);
        if (l >= 0)
            return l;
        int right = Math.max(m + 1, a[m]);
        int r = magicbinary(a, right, e);
        return r;
    }

    ArrayList<ArrayList<Integer>> allsubsets;
    // myway
    public  ArrayList<ArrayList<Integer>> getSubsetss(ArrayList<Integer> set, int index) {
        if(index==set.size()){
            return allsubsets;
        }
        if(index==-1){
            allsubsets = new ArrayList<>();
            ArrayList<Integer> a = new ArrayList<>();
            allsubsets.add(a);
            return getSubsets(set,index+1);
        }else{
            ArrayList<ArrayList<Integer>> next = new ArrayList<>();
            int val = set.get(index);
            for (ArrayList<Integer> list:allsubsets) {
                ArrayList<Integer> l = new ArrayList<>();
                l.addAll(list);
                l.add(val);
                next.add(l);
            }
            allsubsets.addAll(next);
            return allsubsets;
        }
    }



    //CTCI way
    public  ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if (set.size() == index) { // Base case - add empty set
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset); //
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }

    // with duplicates not allowed
    public List<String> palindrome(String s){

        allCombination(s,"");
        return l;
    }
    List<String> l = new ArrayList<>();
    private void allCombination(String s, String soFar) {
        if(s.length()==0) {l.add(soFar);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String news = s.substring(0, i) + s.substring(i + 1);;
            allCombination(news,soFar+s.charAt(i));
        }
    }

    // with duplicates allowed
    public List<String> palindromedup(String s){
        HashMap<Character,Integer> h = generateMap(s);
        allCombinationdup(s.length(),"",h);
        return ld;
    }

    private HashMap<Character,Integer> generateMap(String s) {
        HashMap<Character,Integer> h = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            h.put(s.charAt(i),h.getOrDefault(s.charAt(i),0)+1);
        }
        return h;
    }

    List<String> ld = new ArrayList<>();
    //IMP
    private void allCombinationdup(int left, String soFar, HashMap<Character,Integer> m) {
        if(left==0) {
            ld.add(soFar);
            return;
        }
        for (Character c : m.keySet()) {
            int  count = m.get(c);
            if(count>0){
                m.put(c,count-1);
                allCombinationdup(left-1,soFar+c,m);
                // deep
                m.put(c,count);
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> s = new ArrayList<>();
        rec(n,n,"",s,n);
        return s;
    }

    public void rec(int l, int r,String str, List<String> list, int s)
    {

        if(l==0&&r==0)
            list.add(str);
        if(l>0)
            rec(l-1,r,str+"(",list,s);
        if(r>l)
            rec(l,r-1,str+")",list,s);
    }
}
