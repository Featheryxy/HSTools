package ind.milo.demo.algorithm.LeetCode;

/**
 * @Date 2023/4/27 19:53
 * @Created by Milo
 */
public class LC0226_Invert_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        invertTree(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return root;
    }

    private static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        dfs(node.right);
        swapVal(node);
    }

    private static void swapVal(TreeNode node) {
        TreeNode tmpNode = node.left;
        node.left = node.right;
        node.right = tmpNode;
    }


}
