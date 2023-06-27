package stacksandqueues;
import java.util.*;

public class InfixtoPost {
    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }
//    abcd^e-fgh*+^*+i-
    public static String infixToPostfix(String exp) {
        // Your code here
        char ch;
        Stack<Character> operators = new Stack<>();
        Stack<String> operands = new Stack<>();
        for (int i = 0; i<exp.length(); i++) {
            ch = exp.charAt(i);
            if (ch == '+' || ch == '/' || ch == '*' || ch == '-'|| ch == '^'){
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch) && operators.peek() != '(') {
                    ch = operators.pop();
                    // char operator = operators.pop();
                    String v2 = operands.pop();
                    String v1 = operands.pop();
                    operands.push(v1+v2+ch);
                    // operands.push(operation(v1,v2,operator));
                }
                operators.push(exp.charAt(i));
            }
            else if (ch == '(') operators.push(ch);
            else if (ch == ')'){
                while (operators.peek() != '(') {
                    ch = operators.pop();
                    String v2 = operands.pop();
                    String v1 = operands.pop();
                    operands.push(operation(v1,v2,ch));
                }
                operators.pop();
            }
            else if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch<= 'z' || ch >= '0' && ch <= '9'){
                operands.push(ch + "");
            }
        }
        while (!operators.isEmpty()) {
            ch = operators.pop();
            String v2 = operands.pop();
            String v1 = operands.pop();
            operands.push(operation(v1,v2,ch));
        }
        return operands.pop();
    }
    public static String operation(String v1, String v2, char op) {
        return v1 + v2 + op;
    }

    public static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        else if (op == '^') return 3;
        return 2;
    }
}
