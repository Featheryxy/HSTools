package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0020_Valid_Parentheses {
    public static void main(String[] args) {
        String s = "([])";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char tmpChar = s.charAt(i);
            // 出栈
            if (!stack.isEmpty() && stack.peek() == map.get(tmpChar)) {
                stack.pop();
            } else {
                // 进栈
                stack.push(tmpChar);
            }
        }

        return stack.isEmpty();
    }

    // 1. 使用哈希表记录
    // 2. 先将第一个元素进栈, 接下来每次进栈时，都对比进栈元素和栈顶元素是否匹配，匹配则将栈顶元素弹出，否则进栈
    // 3. 如果最后栈中无元素，则证明括号匹配成功
    public static boolean isValid2(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char tmpChar = s.charAt(i);
            // 可以将第一次循环的内容写在最后，并且在接下来的操作中加上条件
            if (i == 0) {
                stack.push(tmpChar);
                continue;
            }

            // if tmpChar='[',  map.get(tmpChar) == null ,
            // if stack is empty, then stack.peek is also null
            // then we get stack.peek() == map.get(tmpChar) == null
            // then stack.pop() will throw NoSuchElementException
            // so we must add !stack.isEmpty()
            if (!stack.isEmpty() && stack.peek() == map.get(tmpChar)) {
                stack.pop();
            } else {
                stack.push(tmpChar);
            }
        }
        return stack.isEmpty();
    }
    Tag[] tags = {Tag.HASH_TABLE, Tag.STACK};
}
