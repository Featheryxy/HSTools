package ind.milo.demo.algorithm.SwordOffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 剑指 Offer II 025. 链表中的两数相加
 * 给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 */
public class OfferII025 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        addTwoNumbers(l1, l2);
    }

    // 遍历链表，用栈来保存链表中的数字
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 使用ArrayDeque代替Stack, 速度更快
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

//        Stack<Integer> stack1 = new Stack<>();
//        Stack<Integer> stack2 = new Stack<>();
        ListNode head = new ListNode();

//        ListNode loopnode1 = l1;
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

//        ListNode loopnode2 = l2;
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }


        // 空节点，用来记录头节点的下一个节点
        ListNode p = null;
        // 进位第一次为0， 第二次根据上一次的值来变，所以要定义在循环外
        // 循环内定义的变量是每次循环开始时都要进行初始化，只能在当次循环中使用，不会传值到下一次循环中
        int carry = 0;

        // 统一操作
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            // 初始值为0，
            int sumNum = num1 + num2 + carry;
            carry = sumNum / 10;

            ListNode tmpNode = new ListNode();
            tmpNode.val = sumNum % 10;

            // 头插法
            p = head.next;
            head.next = tmpNode;
            tmpNode.next = p;
        }

//        appendNode(stack1, head);
//        appendNode(stack2, head);
//
//        if (carry == 1) {
//            ListNode tmpNode = new ListNode(1);
//            ListNode tmp = head.next;
//            head.next = tmpNode;
//            tmpNode.next = tmp;
//        }

        return head.next;
    }

    private static void appendNode(Stack<Integer> stack1, ListNode head) {
        if (!stack1.isEmpty()) {
            ListNode tmpNode = new ListNode(stack1.pop());
            ListNode p = head.next;
            head.next = tmpNode;
            tmpNode.next = p;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}