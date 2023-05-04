package ind.milo.demo.algorithm.LeetCode;

/**
 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

  

 示例 1：


 输入：p = [1,2,3], q = [1,2,3]
 输出：true

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/same-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0100_Same_Tree {
    public static void main(String[] args) {
        int[] p = {1, 2, 3}, q = {1,2,4};
        TreeNode treeNodeP = TreeNode.buildByArr(p);
        TreeNode treeNodeQ = TreeNode.buildByArr(q);
        System.out.println(isSameTree(treeNodeP, treeNodeQ));
    }

    // method1: 前根遍历，中跟遍历时值都相同
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean preOrderSame = postOrderDfs(p, q);
//        boolean inOrdersame = preOrderDfs(p, q);
//        return preOrderSame && inOrdersame;
        return preOrderSame;

    }

    private static boolean postOrderDfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

//        if (p != null && q == null) {
//            return false;
//        }

//        if (p == null && q != null) {
//            return false;
//        }


        if (p.val != q.val) {
            return false;
        }

        boolean left = postOrderDfs(p.left, q.left);
        boolean right = postOrderDfs(p.right, q.right);
        return left && right;
    }

//    private static boolean inOrderDfs(TreeNode p, TreeNode q) {
//        if (p == null && q == null) {
//            return true;
//        }
//
//        if (p != null && q == null) {
//            return false;
//        }
//
//        if (p == null && q != null) {
//            return false;
//        }
//
//        if (p.val != q.val) {
//            return false;
//        }
//
//        boolean left = preOrderDfs(p.left, q.left);
//        boolean right = preOrderDfs(p.right, q.right);
//        return left && right;
//    }
}
