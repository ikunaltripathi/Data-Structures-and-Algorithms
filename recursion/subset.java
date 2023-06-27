package recursion;

import java.util.ArrayList;

public class subset {
    public static void main(String[] args) {
        String str = "abc";
//      subsequence("", str);
//      System.out.println(subsequence2("", str));
        subsequence3("", str);
    }

    static void subsequence(String P, String U) {
        if (U.isEmpty())
        {
            System.out.print(P + " ");
            return;
        }
       subsequence(P + U.charAt(0), U.substring(1));
       subsequence(P, U.substring(1));
    }
    static ArrayList<String> subsequence2(String P, String U) {
        if (U.isEmpty())
        {
        ArrayList<String> al = new ArrayList<>();
            al.add(P);
            return al;
        }
        ArrayList<String> t = subsequence2(P + U.charAt(0), U.substring(1));
        ArrayList<String> x = subsequence2(P, U.substring(1));
        t.addAll(x);
        return t;
    }
    static void subsequence3(String P, String U) {
        if (U.isEmpty())
        {
            System.out.print(P + " ");
            return;
        }
        subsequence3(P + U.charAt(0), U.substring(1));
         subsequence3(P, U.substring(1));
        subsequence3(P + ((int)U.charAt(0)), U.substring(1));
    }
}
