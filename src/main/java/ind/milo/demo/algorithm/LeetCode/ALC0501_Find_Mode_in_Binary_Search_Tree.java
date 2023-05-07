package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * <p>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * <p>
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ALC0501_Find_Mode_in_Binary_Search_Tree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.buildByArr(new int[]{1, 1, 3});
        int[] mode = findMode(root);
        System.out.println(Arrays.toString(mode));
    }

    private static TreeNode preNode = null;
    private static int maxRate = 0; // 最大频率
    private static int curRate = 0; // 当前结点值出现的次数
    private static List<Integer> mode = new ArrayList<>();

    // method1:  BST，中根遍历有序, 双指针，一边遍历一边统计
    // 初始时：当前结点出现次数 currRate = 1， currRate > maxRate, 加入答案总
    // 循环时：
    //       1. 当 preNode != null && node.val == preNode.val 时
    public static int[] findMode(TreeNode root) {
        inOrderDfs(root);
        int[] modeArr = new int[mode.size()];
        int i = 0;
        for (Integer tmp : mode) {
            modeArr[i++] = tmp;
        }
        return modeArr;
    }

    private static void inOrderDfs(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderDfs(node.left);
        // 先统计当前结点出现的次数
        if (preNode != null && node.val == preNode.val) {
            curRate++;
        } else {
            curRate = 1;
        }

        // 收集结果
        if (curRate > maxRate) {
            maxRate = curRate;
            mode.clear();
            mode.add(node.val);
        } else if (curRate == maxRate) {
            mode.add(node.val);
        }

        preNode = node;
        inOrderDfs(node.right);
    }


    static Tag[] tags = {Tag.BINARY_TREE, Tag.TWO_POINTERS};
}
