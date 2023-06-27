package strings;

public class BasicCalcII {
    public static void main(String[] args) {
        System.out.println(calculate("12-3*4"));
    }
    // UNDO APPROACH
    public static int calculate (String s) {
        char operation = '+';
        int prev = 0, curr=0, res = 0, i =0;
        while (i<s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                while (i<s.length() && Character.isDigit(s.charAt(i))) {
                    curr = (curr*10) + s.charAt(i)-'0';
                    i++;
                }
                i--;
                if (operation == '+') {
                    res += curr;
                    prev = curr;
                }
                else if (operation  == '-') {
                    res -= curr;
                    prev = -curr;
                }
                else if (operation == '*') {
                    res -= prev;
                    res += curr*prev;
                    prev *= curr;
                }
                else {
                    res -= prev;
                    res += prev/curr;
                    prev /= curr;
                }
                curr = 0;
            }
            else if (ch != ' ') {
                operation = s.charAt(i);
            }
            i++;
        }
        return res;
    }

    // LEETCODE -> Taking one char at a time approach
//    public static int calculate(String s) {
//        if (s == null || s.isEmpty()) return 0;
//        int length = s.length();
//        int currentNumber = 0, lastNumber = 0, result = 0;
//        char operation = '+';
//        for (int i = 0; i < length; i++) {
//            char currentChar = s.charAt(i);
//            if (Character.isDigit(currentChar)) {
//                currentNumber = (currentNumber * 10) + (currentChar - '0');
//            }
//            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
//                if (operation == '+' || operation == '-') {
//                    result += lastNumber;
//                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
//                } else if (operation == '*') {
//                    lastNumber = lastNumber * currentNumber;
//                } else if (operation == '/') {
//                    lastNumber = lastNumber / currentNumber;
//                }
//                operation = currentChar;
//                currentNumber = 0;
//            }
//        }
//        result += lastNumber;
//        return result;
//    }
}
