package ind.milo.demo.algorithm.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0002AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode p = head;
        ListNode p1 = l1;
        ListNode p2 = l2;

        // 进位第一次为0， 第二次根据上一次的值来变，所以要定义在循环外
        // 循环内定义的变量是每次循环开始时都要进行初始化，只能在当次循环中使用，不会传值到下一次循环中
        int carry = 0;
        // 统一操作
        while (p1 !=null || p2 != null || carry != 0) {
            int num1 = p1==null?0:p1.val;
            int num2 = p2==null?0:p2.val;
            // 初始值为0，
            int sumNum = num1 + num2 + carry;
            carry = sumNum / 10;

            ListNode tmpNode = new ListNode();
            tmpNode.val = sumNum % 10;

            // 尾插法
            p.next = tmpNode;
            p = p.next;

            p1 = p1 == null?null:p1.next;
            p2 = p2 == null?null:p2.next;
        }

        return head.next;
    }

    static class ListNode {
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
}
