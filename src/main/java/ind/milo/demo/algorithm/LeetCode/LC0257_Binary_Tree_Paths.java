package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *  
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0257_Binary_Tree_Paths {
    static Tag[] tags = {Tag.BINARY_TREE};

    public static void main(String[] args) {
        TreeNode root = TreeNode.getSymmetricTree();
//        TreeNode root = TreeNode.buildByArr(new int[]{1});
        List<String> strings = binaryTreePaths(root);
        System.out.println(strings);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> treePath = new ArrayList<>();
        if (root == null) {
            return treePath;
        }
//        dfs(root, "", true, treePath);
        dfs(root, "",  treePath);
        return treePath;
    }

    // 每次进入结点时在currPath中保存当前结点，在递归函数中使用currPath+"->"
    private static void dfs(TreeNode node, String currPath, List<String> treePath) {
        currPath += node.val;
        if (node.left == null && node.right == null) {
            treePath.add(currPath);
            return;
        }

        if (node.left != null) {
            dfs(node.left, currPath+"->", treePath);
        }

        if (node.right != null) {
            dfs(node.right, currPath+"->",  treePath);
        }

    }

    // 参数isFirst，太丑陋了
    private static void dfs(TreeNode node, String currPath, boolean isFirst, List<String> treePath) {
        if (node.left == null && node.right == null) {
            currPath = isFirst ? String.valueOf(node.val) : currPath + "->" + node.val;
            treePath.add(currPath);
            return;
        }

        currPath = isFirst ? String.valueOf(node.val) : currPath + "->" + node.val;

        if (node.left != null) {
            dfs(node.left, currPath, false, treePath);
        }

        if (node.right != null) {
            dfs(node.right, currPath, false, treePath);
        }

    }
}
