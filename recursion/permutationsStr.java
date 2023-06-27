package recursion;

import java.util.ArrayList;

public class permutationsStr {
    public static void main(String[] args) {
        String str = "abc";
//        findPermutation("", str);
        System.out.println(findPermutation2("", str));
//        System.out.println(findPermutationCount("", str));
    }

    private static void findPermutation(String P, String U) {
        if (U.isEmpty()) {
            System.out.print(P + " ");
            return;
        }
        for (int i = 0; i<=P.length(); i++) {
            String F = P.substring(0,i);
            String S = P.substring(i, P.length());
            findPermutation(F+ U.charAt(0) + S, U.substring(1));
        }
    }
    private static ArrayList<String> findPermutation2(String P, String U) {
        if (U.isEmpty()) {
            ArrayList<String> al = new ArrayList<>();
            al.add(P);
            return al;
        }

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i<=P.length(); i++) {
            String F = P.substring(0,i);
            String S = P.substring(i, P.length());
            ans.addAll(findPermutation2(F+ U.charAt(0) + S, U.substring(1)));
        }
        return ans;
    }
    private static int findPermutationCount(String P, String U) {
        if (U.isEmpty()) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i<=P.length(); i++) {
            String F = P.substring(0,i);
            String S = P.substring(i, P.length());
            count += findPermutationCount(F+ U.charAt(0) + S, U.substring(1));
        }
        return count;
    }

}
