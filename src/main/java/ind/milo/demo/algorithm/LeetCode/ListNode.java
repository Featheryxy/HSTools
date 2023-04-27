package ind.milo.demo.algorithm.LeetCode;

/**
 * @Date 2023/4/27 10:55
 * @Created by Milo
 */
public class ListNode {
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

    static  void print(ListNode head){
        System.out.println();
        while (head != null) {
            System.out.print(head.val+",");
            head = head.next;
        }
    }
}
