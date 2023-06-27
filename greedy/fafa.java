package greedy;

public class fafa {
    public static void main(String[] args) {
        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        System.out.println(checkValidString(s));
    }

    public static boolean checkValidString(String s) {
        int left = 0, right = 0, star = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') left++;
            else if (ch == ')') right++;
            else star++;
            if (right > left) {
                star--;
                left++;
            }
            if (star < 0) return false;
        }
        if (left == right) return true;
        if (left - right == star) return true;
        return false;
    }
}
