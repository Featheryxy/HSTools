package ind.milo.demo.algorithm.LeetCode;


import ind.milo.demo.algorithm.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0110_Balanced_Binary_Tree {
    Tag[] tags = {Tag.BINARY_TREE};
    private boolean ans = true;

    public static void main(String[] args) {
        // [1,2,2,3,3,null,null,4,4]
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(null);
        list.add(null);
        list.add(4);
        list.add(4);

        TreeNode root = TreeNode.buildByList(list);
        LC0110_Balanced_Binary_Tree solution = new LC0110_Balanced_Binary_Tree();
        System.out.println(solution.isBalanced(root));

    }

    public  boolean isBalanced(TreeNode root) {
         dfs(root) ;
        return ans;
    }

    // 自低向上查找，借助了成员变量保存结果
    private  int dfs(TreeNode node) {
        if (node == null ) {
            return 0;
        }

        int left = 1+dfs(node.left);
        int right = 1+dfs(node.right);
        if (Math.abs(left - right) > 1) {
            ans = false;
            return -1;
        }
        return Math.max(left, right);
    }
}
