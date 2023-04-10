package ind.milo.demo.basic;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (stack.size() != 0) {
            System.out.println(stack.pop());
        }
    }
}
