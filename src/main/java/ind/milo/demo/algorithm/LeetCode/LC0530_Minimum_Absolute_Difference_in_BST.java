package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

 差值是一个正数，其数值等于两值之差的绝对值。
 输入：root = [4,2,6,1,3]
 输出：1
 https://leetcode.cn/problems/minimum-absolute-difference-in-bst/

 */
public class LC0530_Minimum_Absolute_Difference_in_BST {
    static Tag[] tags = {Tag.BINARY_TREE, Tag.TWO_POINTERS};

    private static int res = Integer.MAX_VALUE;
    private static TreeNode preNode = null;

    public static void main(String[] args) {
//        int arr[] = {4, 2, 6, 1, 3};
        int arr[] = {1};
        TreeNode root = TreeNode.buildByArr(arr);
        int difference = getMinimumDifferenceOffice(root);
        System.out.println(difference);
    }

    // method2: 中跟遍历，双指针法，一个指针指向前一个结点
    // ps: 题目提示， 结点数一定会超过2个结点
    public static int getMinimumDifferenceOffice(TreeNode root) {
        dfsOffice(root);
        return res;
    }

    private static void dfsOffice(TreeNode node) {
        if (node == null) {
            return;
        }

        dfsOffice(node.left);
        // 第一次时为空
        if (preNode != null) {
            // pre指向上一个结点，node为当前结点，BST，当前节点 > 上一个结点
            res = Math.min(node.val - preNode.val, res);
        }
        // 运算过后将指针指向当前结点
        preNode = node;
        dfsOffice(node.right);

    }

    // method1: 中跟遍历，保存到数组，占用了额外的空间
    // 1. BST，中根遍历有序，将节点中的值都记录到一个List中
    // 2. 遍历List，记录相邻两个元素的差值，每次保存最小值
    public static int getMinimumDifferenceInefficient(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int minDif = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);
            minDif = Math.min(diff, minDif);
        }
        return minDif;
    }

    private static void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }




}
