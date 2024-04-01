package Part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackM {

    

    public String reverse(String str){
        if(str == null){
            throw new IllegalArgumentException();
        }
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray())
            stack.push(c);

        StringBuilder reversed = new StringBuilder();
        while(!stack.empty()){
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }

    private final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightBrackets
            = Arrays.asList(')', '>', ']', '}');

    public boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);

            if (isRightBracket(ch)) {
                if (stack.empty()) return false;

                var top = stack.pop();
                if (!bracketsMatch(top, ch)) return false;
            }
        }

        return stack.empty();
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}

