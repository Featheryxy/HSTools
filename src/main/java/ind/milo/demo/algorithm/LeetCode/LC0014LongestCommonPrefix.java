package ind.milo.demo.algorithm.LeetCode;

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
        String s = longestCommonPrefixAgain(strArr);
        System.out.println(s);
    }

    //  公共前缀，所有的字符都有相同的前缀
    //  所以 公共前缀的长度一定小等于最短字符的长度
    //  对比所有字符串的第一个字符是否相等，然后对比第二个字符，以此类推
    public static String longestCommonPrefixAgain(String[] strs) {
        int length = strs.length;
        if (length == 1) {
            return strs[0];
        }
        int minLength = Integer.MAX_VALUE;

        // 获取最短字符的长度
        for (int i = 0; i < length; i++) {
            minLength = Math.min(strs[i].length(), minLength);
        }

        int index = 0;
        boolean isDone = false;
        for (int j = 0; j < minLength && !isDone; j++) {
            // 固定第一个字符串，对比其他字符串，如果index对应的字符与其他字符串的字符不同，结束对比
            for (int i = 1; i < length; i++) {
                if (strs[0].charAt(index) != strs[i].charAt(index)) {
                    isDone = true;
                    break;
                }
            }
            if (!isDone) {
                index++;
            }
        }


        return strs[0].substring(0, index);
    };

    /**
     *  公共前缀，所有的字符都有相同的前缀
     *  所以 公共前缀的长度一定小等于最短字符的长度
     *  第一个和第二个字符进行对比，获取公共前缀，
     *  将第三个和公共前缀进行对比，获取新的公共前缀，以此类推
     */
    public static String longestCommonPrefix(String[] strs) {
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
