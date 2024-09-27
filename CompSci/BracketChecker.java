import java.util.*;

public class BracketChecker {

    private String[] test = {"(4+5)",
                             "(3 * (5 + 2))",
                             "(6 * 3) + (7 * 5))",
                             "((10/2 + 4) * (6 + 8) + (2 + 9))",
                             "25 / 5)",
                             "((6+8) * (5+2) *(9+9)"};

    public BracketChecker() {
        for (String exp : test) {
            if (check(exp)) {
                System.out.println("passed");
            } else {
                System.out.println("failed");
            }
        }
    }

    public boolean check(String exp) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false; // Unmatched closing bracket
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty(); // Return true if all brackets are matched
    }

    public static void main(String[] args) {
        BracketChecker app = new BracketChecker();
    }
}
