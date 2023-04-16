package ind.milo.demo.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

// 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
// 二叉树递归时，一个节点会被访问三次，分别时第一次进入节点A是，遍历节点A的左子树后，遍历节点A的右子树后
public class LC0094BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(inorderTraversal(root));
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        return dfs(root, ret);
    }


    public static List<Integer> dfs(TreeNode node, List<Integer> path) {


        // 叶子节点的下一个左（右）节点为空时返回
        if (node == null) {
            return null;
        }

        dfs(node.left, path);
        path.add(node.val);
        dfs(node.right, path);
        return path;
    }
}
