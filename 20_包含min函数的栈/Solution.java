import java.util.Stack;

public class Solution {

    Stack<Integer> stackData = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();

    public void push(int node) {
        stackData.push(node);
        if (stackMin.isEmpty())
            stackMin.push(node);
        else {
            // 需要等号，因为弹出时需要计算相等情况(要考虑重复因素)
            if (node <= stackMin.peek())
                stackMin.push(node);
            // else  重复压入，直接弹出
            //     stackmin.push(stackMin.peek());

        }
    }

    public void pop() {
        int top = stackData.pop();
        if (top == stackMin.peek())
            stackMin.pop();
        //stackMin.pop();  直接弹出
    }

    public int top() {
        if (stackData.isEmpty())
            throw new RuntimeException("stack is empty!");
        return stackData.peek();
    }

    public int min() {
        if (stackMin.isEmpty())
            throw new RuntimeException("stack is empty!");
        return stackMin.peek();
    }
}