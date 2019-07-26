import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder1(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            if (pushA[i] == popA[popIndex])
                popIndex++;
            else
                stack.push(pushA[i]);
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != popA[popIndex++])
                return false;
        }
        return true;
    }

    public boolean IsPopOrder2(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}