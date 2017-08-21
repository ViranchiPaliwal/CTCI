import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by viran on 16-07-2017.
 */
public class ArrayAndString {

    public boolean CheckPermutation(String str1, String str2) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            // default implemnetation
            if (map1.containsKey(str1.charAt(i))) {
                int val = map1.get(str1.charAt(i));
                val++;
                map1.put(str1.charAt(i), val);
            }
            else
            {
                map1.put(str1.charAt(i),1);
            }
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            // default implemnetation
            if (map2.containsKey(str2.charAt(i))) {
                int val = map2.get(str2.charAt(i));
                val++;
                map2.put(str2.charAt(i), val);
            }
            else
            {
                map2.put(str2.charAt(i),1);
            }
        }

        return map1.entrySet().containsAll(map2.entrySet());
    }
    public boolean checkInclusion(String str2, String str1) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            // default implemnetation
            if (map1.containsKey(str1.charAt(i))) {
                int val = map1.get(str1.charAt(i));
                val++;
                map1.put(str1.charAt(i), val);
            }
            else
            {
                map1.put(str1.charAt(i),1);
            }
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            // default implemnetation
            if (map2.containsKey(str2.charAt(i))) {
                int val = map2.get(str2.charAt(i));
                val++;
                map2.put(str2.charAt(i), val);
            }
            else
            {
                map2.put(str2.charAt(i),1);
            }

        }

        Iterator it = map2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(!map1.containsKey(pair.getKey())||map1.get(pair.getKey())<(int)pair.getValue())
                return false;

            // avoids a ConcurrentModificationException
        }
        return true;
    }

    // better approach in book
    public String URLify(String s, int l)
    {
        int index =0;
        char[] arr = s.toCharArray();
        while(index<l)
        {
            if(arr[index]==' ')
            {
                int i = l-1;
                while(i>index)
                {
                    arr[i+2]=arr[i];
                    i--;
                }
                arr[index]='%';
                arr[index+1]='2';
                arr[index+2]='0';
                index=index+3;
                l=l+2;
            }
            else
                index++;
        }
        return arr.toString();
    }

    public String stringCompression(String s)
    {
        StringBuilder sb = new StringBuilder();
        int i = 0,count=0;
       while(i<s.length())
       {
           sb.append(s.charAt(i));
           i++;
           count = 1;
           if(s.charAt(i)==s.charAt(i-1))
            {
                char c = s.charAt(i);
                while(i<s.length()&&s.charAt(i)==c)
                {
                    count++;
                    i++;
                }
            }
           sb.append(String.valueOf(count));
       }
        return sb.toString();
    }
}


// Java 8

// fastest way to implement
//import java.util.HashMap;
//import java.util.Map;
//
//    class MutableInt {
//        int value = 1; // note that we start at 1 since we're counting
//        public void increment () { ++value;      }
//        public int  get ()       { return value; }
//    }
//
//    Map<String, MutableInt> freq = new HashMap<String, MutableInt>();
//    MutableInt count = freq.get(word);
//if (count == null) {
//        freq.put(word, new MutableInt());
//    }
//else {
//        count.increment();
//    }
//}
