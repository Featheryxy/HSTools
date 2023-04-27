package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 */
public class ALC0101_Symmetric_Tree {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        dfs(root);
        return false;
    }

    private static void dfs(TreeNode node) {
        if (node == null) {
            return ;
        }

//        return node.left.val == node.right.val;


    }

    Tag[] tags = {Tag.BINARY_TREE};
}
