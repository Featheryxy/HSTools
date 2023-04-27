package ind.milo.demo.algorithm.LeetCode;

/**
 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 输入：head = [1,2,3,4,5], n = 2
 输出：[1,2,3,5]
 示例 2：

 输入：head = [1], n = 1
 输出：[]
 示例 3：

 输入：head = [1,2], n = 1
 输出：[1]

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0019_Remove_Nth_Node_From_End_of_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmpNode = head;
        tmpNode.next = new ListNode(2);
        tmpNode = tmpNode.next;
        tmpNode.next = new ListNode(3);

        tmpNode = tmpNode.next;
        tmpNode.next = new ListNode(4);
        tmpNode = tmpNode.next;
        tmpNode.next = new ListNode(5);

        ListNode.print(head);

        ListNode listNode = removeNthFromEnd(head, 2);

        ListNode.print(listNode);
    }
    // preHead --> 1 --> 2 --> 3--> 4--> 5, n=2
    //             p           q
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode();
        preHead.next = head;

        ListNode fastHead = preHead;
        ListNode slowHead = preHead;
        while (n-- > 0) {
            fastHead = fastHead.next;
        }

        while (fastHead.next != null) {
            fastHead = fastHead.next;
            slowHead = slowHead.next;
        }
        slowHead.next = slowHead.next.next;
        return preHead.next;
    }
}
