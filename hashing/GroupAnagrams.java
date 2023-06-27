package hashing;
import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String str = "ear";
        char[] arr = new char[26];
        for (char c : str.toCharArray()) arr[c-'a']++;
        System.out.println(String.valueOf(arr));
//        String[] strs = {"afaf", "fafa"};
//        System.out.println(groupAnagrams(strs));
    }
//    public static List<List<String>> groupAnagrams(String[] strs) {
//        if (strs == null || strs.length == 0) return new ArrayList<>();
//        Map<String,List<String>> hm = new HashMap<>();
//        for (String s : strs) {
//            char[] arr = new char[26];
//            for (char c : s.toCharArray()) arr[c-'a']++;
//            String key = String.valueOf(arr);
//            System.out.println(key);
//            if (!hm.containsKey(key)) hm.put(key, new ArrayList<String>());
//            hm.get(key).add(s);
//        }
//        return new ArrayList<>(hm.values());
//    }
}
