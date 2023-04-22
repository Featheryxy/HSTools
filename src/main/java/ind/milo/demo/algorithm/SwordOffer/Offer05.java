package ind.milo.demo.algorithm.SwordOffer;



/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * '
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer05 {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace2(s));
    }

    public static String replaceSpace1(String s) {


        String replace = s.replace(" ", "%20");
        return replace;
    }

    // 效率更高一点
    public static String replaceSpace2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
