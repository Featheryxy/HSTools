package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;
import org.junit.jupiter.api.Tags;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class LC0017_Letter_Combinations_of_a_Phone_Number {
    public static void main(String[] args) {
        LC0017_Letter_Combinations_of_a_Phone_Number solution = new LC0017_Letter_Combinations_of_a_Phone_Number();
        String digits = "234";
        solution.letterCombinations(digits);
        System.out.println(solution.res);
    }

    private List<String> res = new ArrayList<>();
    // 使用数组来记录数字与字母的映射
    String[] leeterArr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }

        dfs(digits, "", 0);

        return res;
    }

    /**
     *
     * @param digits 数字
     * @param path 记录遍历的路径
     * @param start 记录遍历的层数，
     */
    private void dfs(String digits, String path, int start) {
        if (path.length() == digits.length()) {
            res.add(path);
            return;
        }

        char num = digits.charAt(start);
        String letter = leeterArr[num - '0'];
        for (int i = 0; i < letter.length(); i++) {
            dfs(digits, path + letter.charAt(i), start+1);
        }

    }

    public Tag[] tags = {Tag.BACKTRACKING, Tag.RECURSION};
}
