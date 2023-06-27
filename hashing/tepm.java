package hashing;
import java.util.*;
public class tepm {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> hs = new HashSet<>();
        int maxLen = 0;
        int prev = 0;
        for (int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (hs.contains(ch)) {
                while (prev<s.length() && s.charAt(prev) != s.charAt(i)){
                    hs.remove(s.charAt(prev));
                    prev++;
                }
                hs.remove(prev);
                prev++;
                hs.add(ch);
            }
            else hs.add(ch);
            maxLen = Math.max(maxLen, i-prev+1);
        }
        return maxLen;
    }
}
