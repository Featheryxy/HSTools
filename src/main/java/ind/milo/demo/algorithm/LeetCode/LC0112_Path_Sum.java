package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;

/**
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 */
public class LC0112_Path_Sum {
    static Tag[] tags = {Tag.BINARY_TREE};

    public static void main(String[] args) {
        TreeNode root = TreeNode.getSymmetricTree();
        boolean b = hasPathSum(root, 6);
        System.out.println(b);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,0, targetSum);
    }

    // 初始时判断根节点是否为空，为空，直接返回false
    // 遍历时加上了 root.left != null 和 root.right != null, 所以他只遍历非空节点
    // tmpSum 记录搜索路径上值的和， i.e.:用以记录从根节点到当前节点上路径上值的和
    private static boolean dfs(TreeNode root,int tmpSum, int targetSum) {
        // 如果根节点为空，直接返回false
        if (root == null) {
            return false;
        }

        tmpSum = tmpSum + root.val;

        if (root.left == null && root.right == null) {
            return tmpSum == targetSum;
        }

        boolean findInLeft = false;
        if (root.left != null) {
            findInLeft = dfs(root.left, tmpSum, targetSum);
        }


        // 左子树没有找到 并且 当前节点的右节点存在
        boolean findInRight = false;
        if (!findInLeft && root.right != null) {
            findInRight = dfs(root.right, tmpSum, targetSum);
        }

        return findInLeft || findInRight;
    }
}
