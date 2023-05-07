package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0404_Sum_of_Left_Leaves {
    static Tag[] tags = {Tag.BINARY_TREE};

    public static void main(String[] args) {
        TreeNode root = TreeNode.getSymmetricTree();
        int i = sumOfLeftLeaves(root);
        System.out.println(i);
    }

    private static int leftLeavesSum;

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null ) {
            return 0;
        }
        // method 1
//        dfs(root, false);
//        return leftLeavesSum;
        // method 2
        int dfs = dfs(root, false, 0);
        return dfs;
    }

    // method 2：ans 记录每个左叶子结点值的和
    private static int dfs(TreeNode node, boolean isLeftNode, int ans) {
        // 只有叶子结点，并且是左节点
        if (node.left == null && node.right == null && isLeftNode) {
            ans += node.val;
            return ans;
        }

        if (node.left != null) {
            ans = dfs(node.left, true, ans);
        }

        if (node.right != null) {
            ans = dfs(node.right, false, ans);
        }

        return ans;
    }


    // method1
    // 使用成员变量 leftLeavesSum记录左叶子结点总和
    // 使用标识符 isLeftNode 标记是是否是左结点
    private static void dfs(TreeNode node, boolean isLeftNode) {
        // 只有叶子结点，并且是左节点
        if (node.left == null && node.right == null && isLeftNode) {
            leftLeavesSum += node.val;
        }

        if (node.left != null) {
            dfs(node.left, true);
        }

        if (node.right != null) {
            dfs(node.right, false);
        }
    }
}
