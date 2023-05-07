package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0111_Minimum_Depth_of_Binary_Tree {
    static Tag[] tags = {Tag.BINARY_TREE};

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildByArr(new int[]{1,2,3,4,5});// ans = 2
        LC0111_Minimum_Depth_of_Binary_Tree solution = new LC0111_Minimum_Depth_of_Binary_Tree();
        System.out.println(solution.minDepth(root));
    }
    private int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 叶子结点：子节点的节点， i.e.:其左右子节点都为空
        if (root.left == null && root.right == null) {
            return 1;
        }


        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

        if (root.left != null) {
            left = minDepth(root.left);
        }

        if (root.right != null) {
            right = minDepth(root.right);
        }

        return 1+Math.min(left, right);
    }

    private void dfs(TreeNode node, int i) {
        if (node == null) {
            return;
        }
    }

    private void dfsErr(TreeNode node, int deep) {
        // 如果【1，2】，会输出1， 但是正确答案应该是2
        if (node == null) {
            minDepth = Math.min(deep, minDepth);
            return;
        }

        dfs(node.left, deep + 1);
        dfs(node.right, deep + 1);
    }
}
