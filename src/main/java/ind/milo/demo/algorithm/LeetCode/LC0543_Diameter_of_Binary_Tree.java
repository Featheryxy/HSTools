package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;

/**
 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

 示例 :
 给定二叉树

 1
 / \
 2   3
 / \
 4   5
 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/diameter-of-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0543_Diameter_of_Binary_Tree {
    Tag[] tags = {Tag.BINARY_TREE};

    private static int maxLength = 0;

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildByArr(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        int maxPath = diameterOfBinaryTree(root);
        System.out.println(maxPath);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
         dfs(root);
        return maxLength;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        // 记录每个结点的最长路径
        maxLength = Math.max(left + right, maxLength);
        return 1 + Math.max(left, right);
    }


    // 最长路径一定包含根结点, 该假设错误
    //              1
    //           2      3
    //                3    3
    //               3        3
    //              3           3
    // 则最长路径 = 左子树高度 + 右子树高度
    public static int diameterOfBinaryTreeErr(TreeNode root) {
        int left = dfsErr(root.left);
        int right = dfsErr(root.right);
        return left+right;
    }

    public static int dfsErr(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = dfsErr(root.left);
        int rightHeight = dfsErr(root.right);
        return 1+Math.max(leftHeight, rightHeight);
    }
}
