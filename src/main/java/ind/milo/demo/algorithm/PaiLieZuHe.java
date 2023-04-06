package ind.milo.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

class PaiLieZuHe {
    public static void main(String[] args) {
        PaiLieZuHe paiLieZuHe = new PaiLieZuHe();
        List<String> strings = paiLieZuHe.letterCombinations("23");
        System.out.println(strings);
    }

    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private final List<String> ans = new ArrayList<>();
    private char[] digits, path;

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) return new ArrayList<>();
        this.digits = digits.toCharArray();
        path = new char[n];
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == digits.length) {
            ans.add(new String(path));
            return;
        }
        char[] chars = MAPPING[digits[i] - '0'].toCharArray();
        for (char c : chars) {
            path[i] = c;
            dfs(i + 1);
        }
    }


}


