package ind.milo.demo.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class LC0144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(preorderTraversal(root));
    }
    // method1: 递归实现
    public static List<Integer> preorderTraversal(TreeNode root) {
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

        // 收集当前节点的值
        path.add(node.val);
        dfs(node.left, path);
        dfs(node.right, path);
        return path;
    }

    // 使用栈来实现,
    // 出栈顺序 根，左节点，右节点。
    // 进栈顺序 根， 右节点，左节点
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmpNode = stack.pop();
            ret.add(tmpNode.val);

            if (tmpNode.right != null) {
                stack.push(tmpNode.right);
            }

            if (tmpNode.left != null) {
                stack.push(tmpNode.left);
            }
        }
        return ret;
    }
}
class TreeNode {
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
}