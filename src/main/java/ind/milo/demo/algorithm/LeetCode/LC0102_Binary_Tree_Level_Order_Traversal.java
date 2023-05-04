package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;

import java.util.*;

// 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
public class LC0102_Binary_Tree_Level_Order_Traversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);

        while (!deque.isEmpty()) {
            // 记录每层的节点
            List<Integer> tmpList = new ArrayList<>();
            // 记录每层节点的个数
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.removeLast();
                tmpList.add(treeNode.val);
                if (treeNode.left != null) {
                    deque.push(treeNode.left);
                }

                if (treeNode.right != null) {
                    deque.push(treeNode.right);
                }
            }
            ret.add(tmpList);
        }

        return ret;
    }


    //    public static List<List<Integer>> dfs(TreeNode node, List<Integer> path, int depths) {
//        depths++;
//        // 叶子节点的下一个左（右）节点为空时返回
//        if (node == null) {
//            return null;
//        }
//
//        path.add(node.val);
//        dfs(node.left, path, depths);
//        dfs(node.right, path, depths);
//        return path;
//    }
    Tag[] tags = {Tag.BINARY_TREE};
}
