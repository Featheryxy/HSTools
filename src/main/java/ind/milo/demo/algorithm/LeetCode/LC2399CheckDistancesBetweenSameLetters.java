package ind.milo.demo.algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个下标从 0 开始的字符串 s ，该字符串仅由小写英文字母组成，s 中的每个字母都 恰好 出现 两次 。另给你一个下标从 0 开始、长度为 26 的的整数数组 distance 。
 *
 * 字母表中的每个字母按从 0 到 25 依次编号（即，'a' -> 0, 'b' -> 1, 'c' -> 2, ... , 'z' -> 25）。
 *
 * 在一个 匀整 字符串中，第 i 个字母的两次出现之间的字母数量是 distance[i] 。如果第 i 个字母没有在 s 中出现，那么 distance[i] 可以 忽略 。
 *
 * 如果 s 是一个 匀整 字符串，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abaccb", distance = [1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * 输出：true
 * 解释：
 * - 'a' 在下标 0 和下标 2 处出现，所以满足 distance[0] = 1 。
 * - 'b' 在下标 1 和下标 5 处出现，所以满足 distance[1] = 3 。
 * - 'c' 在下标 3 和下标 4 处出现，所以满足 distance[2] = 0 。
 * 注意 distance[3] = 5 ，但是由于 'd' 没有在 s 中出现，可以忽略。
 * 因为 s 是一个匀整字符串，返回 true 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-distances-between-same-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC2399CheckDistancesBetweenSameLetters {
    public static void main(String[] args) {
//        String s = "abaccb";
//        int[] distance = new int[]{1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String s = "aa";
        int[] distance = new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};


        System.out.println(checkDistances(s, distance));

    }

    public static boolean checkDistances(String s, int[] distance) {
        int [] hasCounted = new int[26];
        int len = s.length();
        for (int i=0; i<len; i++) {
            char currChar = s.charAt(i);
            int chrIndex = currChar-97;
            int flag = hasCounted[chrIndex];
            
            // 第一次出现
            if (flag == 0){
                hasCounted[chrIndex] ++;
            } else {
                hasCounted[chrIndex] --;
            }
//            int i1 = flag == 0 ? hasCounted[chrIndex]++ : hasCounted[chrIndex]--;
            // 第一次出现，一定有下一个字母
            if (flag == 0 ) {
                // 当前字母的索引 + distance[当前字母] +1    ！= 下一次字母的出现的地址
                int nextCharIndex = i+distance[currChar-97]+1;
                if (nextCharIndex>len-1) {
                    return false;
                }
                if (currChar != s.charAt(nextCharIndex)){
                    return false;
                }
            }

        }

        return true;
    }

    public static boolean checkDistancesWrong(String s, int[] distance) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i=0; i<len; i++) {
            char currChar = s.charAt(i);
            // 如果currChar 不在Map中则直接记录index， 否则记录i-index
            int index = map.getOrDefault(currChar, i);
            int dis = index==i?index:i-map.get(currChar);
            map.put(currChar, dis);
        }
        Set<Character> characters = map.keySet();
        for (char chr: characters) {
            int dis = distance[(int) (chr - 97)];
            if (dis == map.get(chr)+1) return false;
        }
        return true;
    }
}
