package stacksandqueues;

import java.util.Stack;

public class InfixEval {
    public static void main(String[] args) {
        String s = "3*(7-2/2)";
        System.out.println(eval(s));
    }

    public static int  eval (String s) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                operands.push(ch-'0');
            }
            else if (ch == '(') {
                operators.push(ch);
            }
            else if (ch == ')') {
                while (operators.peek() != '(') {
                    char operation = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    operands.push(operation(v1, v2, operation));
                }
                operators.pop();
            }
            else {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch) && operators.peek() != '(') {
                    char operation = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    operands.push(operation(v1, v2, operation));
                }
                operators.push(ch);
            }

        }
        while (!operators.isEmpty()) {
            char operation = operators.pop();
            int v2 = operands.pop();
            int v1 = operands.pop();
            operands.push(operation(v1, v2, operation));
        }
        return operands.peek();
    }

    public static int operation(int value1, int value2, char operator) {
        if (operator == '+') return value1 + value2;
        else if (operator == '-') return value1 - value2;
        else if (operator == '*') return value1 * value2;
        else return value1/value2;

    }
    public static int precedence(char operator) {
        if (operator == '+' || operator == '-') return 1;
        else return 2;
    }
}
