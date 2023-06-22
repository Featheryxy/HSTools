package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 *
 *
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2a'a'a'a'a'a'a'a'a'a'a'a'a'a输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * 提示:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class LC0040_Combination_SumII {
	public static void main(String[] args) {
		int[] candidates = {2, 5, 2, 1, 2};
		int target = 5;
//		int[] candidates = {10,1,2,7,6,1,5};
//		int target = 8;
		LC0040_Combination_SumII solution = new LC0040_Combination_SumII();
		System.out.println(solution.combinationSum2(candidates, target));
	}

	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		int begin = 0;
		List<Integer> path = new ArrayList<>();
		int pathSum = 0;
		boolean[] used = new boolean[candidates.length];
//		Arrays.fill(used, false);
		Arrays.sort(candidates);
		dfs(candidates, target, begin, path, pathSum, used);
		return res;
	}

	private void dfs(int[] candidates, int target, int begin, List<Integer> path, int pathSum, boolean[] used) {
		if (pathSum == target) {
			// 会超时
//			if (!res.contains(path)) {
//				res.add(new ArrayList<>(path));
//			}

			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = begin; i < candidates.length; i++) {
			int currCandidate = candidates[i];
			if (pathSum + currCandidate > target) {
				break;
			}

			// 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
//			if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
//				continue;
//			}


			// 如果从 begin 开始的数有连续出现的重复数字，跳过该数字continue，因为这会产生重复解
			//因为数不可以重复选择，所以在进入下一层递归时，i要加1，从i之后的数中选择接下来的数
			if(i > begin && candidates[i] == candidates[i - 1])
				continue;



//			used[i] = true;
			path.add(currCandidate);
			dfs(candidates, target, i+1, path, pathSum + currCandidate, used);
			// 状态回退，i.e.:二叉树回到上一层的状态
			path.remove(path.size() - 1);
//			used[i] = false;
		}
	}

	Tag[] tags = {Tag.BACKTRACKING};
}
