import java.util.*;

public class PostFixEvaluator {
    private String[] test = {
        "4 5 +",
        "3 4 2 * +",
        "2 6 * 2 5 * +",
        "7 4 + 8 - 3 *",
        "2 3 + 4 5 * - 2 1 / +"
    };

    public PostFixEvaluator() {
        for (String exp : test) {
            System.out.println(exp + " = " + evaluate(exp));
        }
    }

    /* evaluates the postfix expression exp
     * @param exp the postfix expression to be evaluated
     * @return the total of exp
     *    Precondition: exp is a well-formed postfix expression
     */
    public int evaluate(String exp) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = exp.split(" ");

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop(); 
                int a = stack.pop();
                int result = performOperation(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    /* Helper method to perform the arithmetic operation */
    private int performOperation(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b; // Integer division
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    /* returns true if str is one of the operators */
    public boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    public static void main(String[] args) {
        PostFixEvaluator app = new PostFixEvaluator();
    }
}
