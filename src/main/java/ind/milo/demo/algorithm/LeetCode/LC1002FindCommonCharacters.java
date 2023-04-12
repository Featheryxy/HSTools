package ind.milo.demo.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。
  

 示例 1：

 输入：words = ["bella","label","roller"]
 输出：["e","l","l"]
 示例 2：

 输入：words = ["cool","lock","cook"]
 输出：["c","o"]

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/find-common-characters
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC1002FindCommonCharacters {
    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        System.out.println(commonChars(words));
    }


    // 使用int [26] res 数组统计每个words中每个字符出现的次数
    // 假设有 words[abc, abd]
    // abc [1, 1, 1, 0, 0,...,0]
    // abd [1, 1, 0, 0, 0,]
    // 每列取最小值，得到统计数组res
    // res [1, 1, 0, 0, 0,...,0], 所以答案微 [a, b]
    public static List<String> commonChars(String[] words) {
        int len = words.length;
        if (len == 0) {
            return new ArrayList<>();
        }
        int[] countArr = new int[26];
        //
        String firsWord = words[0];
        for (int i = 0; i < firsWord.length(); i++) {
            countArr[firsWord.charAt(i)-'a']++;
        }

        for (int i = 1; i < len; i++) {
            int tmpArr[] = new int[26];
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                tmpArr[word.charAt(j)-'a']++;
            }
            for (int j = 0; j < tmpArr.length; j++) {
                countArr[j] = Math.min(countArr[j], tmpArr[j]);
            }
        }

        ArrayList<String> ans = new ArrayList<>();
        for (int j = 0; j < countArr.length; j++) {
            int count = countArr[j];
            if (count > 0) {
                for (int i = 0; i < count; i++) {
                    // 编译后会变成 StringBuilder
//                    ans.add((char)('a'+j)+"");
                    // 效率更高
                    ans.add(String.valueOf((char) ('a'+j)));
                }
            }
        }
        return ans;
    }
}
