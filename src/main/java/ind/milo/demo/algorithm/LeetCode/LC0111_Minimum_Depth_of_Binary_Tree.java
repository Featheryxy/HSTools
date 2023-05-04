package ind.milo.demo.algorithm.LeetCode;

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
    public static void main(String[] args) {
        TreeNode root = TreeNode.getSymmetricTree();
        LC0111_Minimum_Depth_of_Binary_Tree solution = new LC0111_Minimum_Depth_of_Binary_Tree();
        System.out.println(solution.minDepth(root));
    }
    private int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        dfs(root, 0);
        return minDepth;
    }

    private void dfs(TreeNode node, int deep) {
        if (node == null) {
            minDepth = Math.min(deep, minDepth);
            return;
        }

        dfs(node.left, deep + 1);
        dfs(node.right, deep + 1);
    }
}
