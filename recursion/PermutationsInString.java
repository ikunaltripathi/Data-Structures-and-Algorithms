package recursion;

import java.util.*;
import java.util.ArrayList;

public class PermutationsInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("prosperity", "properties"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        List<String> al = generate_perm("", s1);
        for (String s : al) {
            int j = s1.length()-1;
            int i = 0;
            while (j<s2.length()) {
                String temp = s2.substring(i,j+1);
                if (temp.equals(s)) return true;
                i++;
                j++;
            }
        }
        return false;
    }

    public static List<String> generate_perm(String p, String u) {
        List<String> al = new ArrayList<>();
        if (u.length() == 0) {
            al.add(p);
            return al;
        }
        char ch = u.charAt(0);
        for (int i = 0; i<p.length()+1; i++) {
            al.addAll(generate_perm(p.substring(0,i)+ch+p.substring(i,p.length()), u.substring(1)));
        }
        return al;
    }
}
