package ind.milo.demo.collection;

import java.util.ArrayDeque;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        System.out.println(deque);
        deque.addFirst(0);
        System.out.println(deque);
        System.out.println(deque.getFirst());
    }
}
