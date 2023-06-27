package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class minSub {
    public static void main(String[] args) {
        System.out.println(minWindow("bbaac", "aba"));
    }

        public static String minWindow(String s, String t) {
            Map<Character,Integer> hm = new HashMap<>();
            int count, i = 0, j = 0, minLen = Integer.MAX_VALUE;
            String ans = "";
            for (char c : t.toCharArray()) hm.put(c, hm.getOrDefault(c, 0)+1);
            count = hm.size();
            char ch = s.charAt(j);
            while (!hm.containsKey(ch) && j+1<s.length()) {
                j++;
                i++;
                ch = s.charAt(j);
            }
            while (j < s.length()) {
                ch = s.charAt(j);
                if (hm.containsKey(ch)) {
                    hm.put(ch, hm.get(ch)-1);
                    if (hm.get(ch) == 0) count--;
                }
                if (count == 0) {
                    if (minLen >= j-i+1) {
                        ans = s.substring(i, j+1);
                        minLen = j-i+1;
                    }
                    ch = s.charAt(i);
                    if (hm.containsKey(ch)){
                        hm.put(ch, hm.get(ch)+1);
                        if (hm.get(ch) == 1) count++;
                    }
                    if (i+1 < s.length()) ch = s.charAt(++i);
                    while (!hm.containsKey(ch) && i+1 < s.length()) {
                        i++;
                        ch = s.charAt(i);
                    }
                }
                j++;
            }
            while (count == 0 && i<s.length()) {
                ch = s.charAt(i);
                ans = s.substring(i, j);
                if (hm.containsKey(ch)) {
                    hm.put(ch, hm.get(ch) + 1);
                    if (hm.get(ch) == 1) count++;
                }
                i++;
            }
            return ans;
        }
}
