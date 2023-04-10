package ind.milo.demo.algorithm.LeetCode;

/**
 * @Date 2023/4/10 19:21
 * @Created by Milo
 */
public class LC0707DesignLinkedList {
    public static void main(String[] args) {

    }
}

class MyLinkedList {
    Node head;
    // index 为索引下标
    // size记录节点总数(不包含头节点)，size-1 为最后一个节点的索引
    //
    int size;

    // 头节点为空的单链表
    public MyLinkedList() {
        size = 0;
        head = new Node(0);
    }

    public int get(int index) {
        if (index < 0 || index >size-1) {
            return -1;
        }

        Node currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        return currNode.val;
    }

    public void addAtHead(int val) {

    }

    public void addAtTail(int val) {

    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size-1) {
            return;
        }

        Node currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        Node nextNode = currNode;

    }

    public void deleteAtIndex(int index) {

    }

    class Node {
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }
}
