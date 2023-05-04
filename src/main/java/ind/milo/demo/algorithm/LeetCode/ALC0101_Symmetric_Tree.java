package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 */
public class ALC0101_Symmetric_Tree {
    public static void main(String[] args) {
        TreeNode symmetricTree = TreeNode.getSymmetricTree();
        isSymmetric(symmetricTree);
    }

    public static boolean isSymmetric(TreeNode root) {

        return dfs(root.left, root.right);
    }

    private static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }

        if (left != null && right == null) {
            return false;
        }

        if (left == null && right == null) {
            return true;
        }

        if (left.val != right.val) {
            return false;
        }

        // 如果 左右子结点相同，则应该继续向下一层搜索
//        if (left.val == right.val) {
//            return true;
//        }

        boolean outside = dfs(left.left, right.right);
        boolean inside = dfs(left.right, right.left);
        return outside && inside;
    }

    Tag[] tags = {Tag.BINARY_TREE};
}
