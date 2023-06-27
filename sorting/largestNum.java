package sorting;
import java.util.*;

public class largestNum {
    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(arr));
    }
        public static List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> al = new ArrayList<>();
            int t = 0;
            int[] alpha = new int[26];
            for (int i = 0; i < strs.length; i++) {
                String d = strs[i];
                if (d.equals("1")) continue;
                String curr = strs[i];
                al.add(new ArrayList<>());
                al.get(t).add(curr);
                for (int j = 0; j < curr.length(); j++) {
                    char c = curr.charAt(j);
                    alpha[c - 97]++;
                }
                int[] clone = alpha.clone();

                for (int k = i + 1; k < strs.length; k++) {
                    String temp = strs[k];
                    if (temp.equals("1")) continue;
                    for (int j = 0; j < temp.length(); j++) {
                        char x = temp.charAt(j);
                        alpha[x - 97]--;
                    }
                    boolean flag = true;
                    for (int j = 0; j < alpha.length; j++) {
                        if (alpha[j] != 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag == true) {
                        al.get(t).add(temp);
                        strs[k] = "1";
                    }
                    alpha = clone.clone();
                }
                alpha = new int[26];
                t++;
            }
            return al;
        }
}
