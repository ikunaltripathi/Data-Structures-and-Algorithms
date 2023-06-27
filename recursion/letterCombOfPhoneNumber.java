package recursion;

import java.util.ArrayList;
import java.util.List;

public class letterCombOfPhoneNumber {
    public static void main(String[] args) {
        String Str = "2";
        System.out.println(letterCombinations(Str));
    }
    static List<String> res = new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        if (digits.length() == 1) {
            int n = Integer.parseInt(String.valueOf(digits.charAt(0)));
            String str = map(n);
            for (int i = 0; i<str.length(); i++) res.add(String.valueOf(str.charAt(i)));
            return res;
        }
        listComb("", digits);
        return res;
    }
    public static void listComb(String P, String Org) {
        if (Org.isEmpty()) {
            res.add(P);
            return;
        }
        int n = Integer.parseInt(String.valueOf(Org.charAt(0)));
        String str = map(n);
        for (int i = 0; i < str.length(); i++) {
            listComb(P+str.charAt(i), Org.substring(1));
        }
    }

    private static String map(int n) {
        switch (n) {
            case 2: return "abc";
            case 3: return "def";
            case 4: return "ghi";
            case 5: return "jkl";
            case 6: return "mno";
            case 7: return "pqrs";
            case 8: return "tuv";
            case 9: return "wxyz";
            default : return "";
        }
    }

}
