package ind.milo.demo.algorithm.LeetCode_643;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0014LongestCommonPrefix {
    public static void main(String[] args) {
        String [] strArr = new String[] {"flower","flow","flight"};
        String s = new LC0014LongestCommonPrefix().longestCommonPrefix(strArr);
        System.out.println(s);
    }

    /**
     *  公共前缀，所有的字符都有相同的前缀
     *  所以 公共前缀的长度一定小等于最短字符的长度
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        for (int i=1; i<strs.length; i++) {
            String tmpStr = strs[i];
            int minLength = Math.min(tmpStr.length(), ans.length());
            int j=0;
            for (; j<minLength; j++) {
                if (ans.charAt(j) != tmpStr.charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
        }
        return ans;
    };
}
