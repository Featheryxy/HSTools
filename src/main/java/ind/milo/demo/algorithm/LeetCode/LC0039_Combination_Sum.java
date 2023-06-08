package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;
import org.junit.jupiter.api.Tags;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 *
 *
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 *
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 *
 * 输入: candidates = [2], target = 1
 * 输出: []
 *
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 *
 */
public class LC0039_Combination_Sum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = new LC0039_Combination_Sum().combinationSum(candidates, target);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        // 排序为后续减枝做准备
        Arrays.sort(candidates);
        dfs(0, candidates, target, new ArrayList<>(), res, 0);

        return res;
    }


    /**
     *
     * @param begin 搜索起点
     * @param candidates 搜索数组
     * @param target 搜索目标
     * @param path 搜索路径
     * @param res 结果集收集
     * @param pathSum 记录搜索路径上值的和
     */
    private void dfs(int begin, int[] candidates, int target, List<Integer> path, List<List<Integer>> res, int pathSum) {
//        int pathSum = path.stream().mapToInt(Integer::intValue).sum();
        if (pathSum == target) {
            // error, path为引用变量，结果为[]
            // res.add(new ArrayList<>(path));
            res.add(new ArrayList<>(path));
            return;
        }

        if (pathSum > target) {
            return;
        }

        // 每次搜索的起点都要在当前搜索起点的下一个位置
        for (int i = begin; i < candidates.length; i++) {
            // 二叉树中跟遍历递增，不遍历大于目标值的节点
            if (pathSum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
//            System.out.println(path);
            // pathSum+candidates[i] 一定要写在方法参数列表中，其结果只在下一层使用
            dfs(i, candidates, target, path, res, pathSum+candidates[i]);
            path.remove(path.size() - 1);
        }
    }

    Tag[] tags = {Tag.BACKTRACKING};
}
