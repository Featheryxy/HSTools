package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */
public class LC0145BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(postorderTraversal(root));
    }
    // method1: 递归实现
    public static List<Integer> postorderTraversal(TreeNode root) {
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
        dfs(node.right, path);
        // 收集当前节点的值
        path.add(node.val);
        return path;
    }

    Tag[] tags = {Tag.BINARY_TREE};
}
