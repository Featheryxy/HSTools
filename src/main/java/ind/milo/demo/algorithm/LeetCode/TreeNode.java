package ind.milo.demo.algorithm.LeetCode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Date 2023/4/27 19:51
 * @Created by Milo
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode getSymmetricTree(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        return root;
    }


    // 用队列保存树的结点， 先将根结点入队
    // 1. 出队条件：队首结点的左右子树不为空
    // 2. 入队条件：每一个新结点（左右子树为空）
    // 遍历完数组后，队列中保存的是叶子结点以及左节点不为空的结点
    public static TreeNode buildByArr(int [] arr){
        int len = arr.length;
        if (len == 0) {
            return new TreeNode();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.add(root);

        for (int i = 1; i < len; i++) {
            TreeNode treeNode = new TreeNode(arr[i]);
            queue.add(treeNode);
            TreeNode queueHead = queue.element();
            // 1. 如果队首的结点左右子树都不为空，出队
            // 2. 新加结点自动赋值给下一个队首的左子树
            if (queueHead.left != null && queueHead.right != null) {
                queue.remove();
                TreeNode element = queue.element();
                element.left = treeNode;
            } else {
                if (queueHead.left == null) {
                    queueHead.left = treeNode;
                } else {
                    queueHead.right = treeNode;
                }
            }
        }

        return root;
    }

    public static void toStringInOrder(TreeNode root) {
        List<Integer> integers = LC0094_Binary_Tree_Inorder_Traversal.inorderTraversal(root);
        System.out.println(integers);
    }

    public static void main(String[] args) {
        TreeNode treeNode = buildByArr(new int[]{1, 2, 3, 4});
        toStringInOrder(treeNode);
    }
}
