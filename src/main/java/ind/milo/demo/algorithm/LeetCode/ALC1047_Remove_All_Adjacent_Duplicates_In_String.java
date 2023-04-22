package ind.milo.demo.algorithm.LeetCode;



import ind.milo.demo.algorithm.Tag;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ALC1047_Remove_All_Adjacent_Duplicates_In_String {
    public static void main(String[] args) {
        String s = "abbbaca";
        System.out.println(removeDuplicatesError(s));
    }

    // 使用栈时，应该先考虑入栈条件和出栈条件，如果入栈条件太复杂，可以
    // 遍历整个字符串，当栈为空时，或者栈顶元素和待入栈元素不同时，入栈。否则出栈
    public static String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char currChr = s.charAt(i);
            if (deque.isEmpty() || deque.peek() != currChr) {
                deque.push(currChr);
            } else  {
                deque.pop();
            }
        }


        // 神仙代码：eque.size() 会随着队列中元素的减少而改变
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int j = 0; j < deque.size(); j++) {
//            stringBuilder.append(deque.removeFirst());
//        }
        // 可以抽离变量，但是最好还是使用 deque.isEmpty()来做循环条件
//        StringBuilder stringBuilder = new StringBuilder();
//        int size = deque.size();
//        for (int j = 0; j < size; j++) {
//            stringBuilder.append(deque.removeFirst());
//        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()){
            stringBuilder.append(deque.removeLast());
        }
        return stringBuilder.toString();
    }

    public static String removeDuplicatesAgain(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()) {
            char currChr = s.charAt(i);

            // 入栈
            while (i < s.length() && (deque.isEmpty() || deque.peek() != currChr)) {
                deque.push(currChr);
                i++;
            }

            // 此刻i 已经和栈顶元素相同，找到下一个与栈顶元素不同的元素

            boolean isSame = false;
            while (!deque.isEmpty() && i < s.length() && s.charAt(i) == deque.peek() ) {
                isSame = true;
                i++;
            }

            if (isSame) {
                deque.pop();
            } else {
                if (!deque.isEmpty() && deque.peek() != s.charAt(i)) {
                    deque.push(s.charAt(i));
                    i++;
                } else if (deque.isEmpty()) {
                    deque.push(s.charAt(i));
                    i++;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.removeLast());
        }

        return stringBuilder.toString();
    }


    // 使用双端队列
    // 将字符串中的每个元素依次进栈，如果进栈元素和栈顶元素，将进栈元素后一个，
    // 直到找到一个和栈顶元素不同的元素进栈，并且移除栈顶元素
    public static String removeDuplicatesError(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()) {
            if (i == 0) {
                deque.push(s.charAt(0));
                i++;
                continue;
            }

            boolean isSame = false;
            while (!deque.isEmpty() && i < s.length() && s.charAt(i) == deque.peek() ) {
                isSame = true;
                i++;
            }

            if (isSame) {
                deque.pop();
            } else {
                if (!deque.isEmpty() && deque.peek() != s.charAt(i)) {
                    deque.push(s.charAt(i));
                    i++;
                } else if (deque.isEmpty()) {
                    deque.push(s.charAt(i));
                    i++;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.removeLast());
        }

        return stringBuilder.toString();
    }

    Tag[] tags = {Tag.STACK};
}
