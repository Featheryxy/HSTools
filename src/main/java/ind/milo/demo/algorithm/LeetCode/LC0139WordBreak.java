package ind.milo.demo.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC0139WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        List<String> usefulDict = new ArrayList<>();
        for (String tmpStr : wordDict) {
            if (s.contains(tmpStr)) {
                s = s.replace(tmpStr, "");
            }
        }
        return s.equals("");

    }
}
