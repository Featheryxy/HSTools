package ind.milo;

import java.util.Stack;

/**
 给定一个经过编码的字符串，返回它解码后的字符串。
 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

 示例 1：
 输入：s = "3[a]2[bc]"
 输出："aaabcbc"

 示例 2：
 输入：s = "3[a2[c]]"
 输出："accaccacc"

 示例 3：
 输入：s = "2[abc]3[cd]ef"
 输出："abcabccdcdcdef"

 示例 4：
 输入：s = "abc3[cd]xyz"
 输出："abccdcdcdxyz"
 */
public class HWOD {
    private static int numIndex = 0;

    public static void main(String[] args) {
        String s = "abc3[cd]xyz";
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();

        for (numIndex = 0; numIndex < chars.length; ) {
            Character tmpChr = chars[numIndex];
            // 1 是不是数字，把数字连起来入栈
            // 2 判断 字符串，左括号 都入栈
            // 3 遇到右括号，弹出，一直到上一个左括号，弹出来数字，
            // 4. 循环拼接

            if (Character.isDigit(tmpChr)) {
                String num = getNum(s);
                stack.push(num);
            } else if (Character.isLetter(tmpChr) || tmpChr == '[') {
                stack.push(tmpChr+"");
                numIndex++;
            } else if (tmpChr == ']') {
                String letterStr = "";
                while (!stack.isEmpty() && !stack.peek().equals("[") ) {
                    letterStr = stack.pop() + letterStr;
                }

                stack.pop();
                String numStr = stack.pop();
                StringBuilder tmpStr = new StringBuilder();
                for (int i = 0; i < Integer.parseInt(numStr); i++) {
                    tmpStr.append(letterStr);
                }

                stack.push(tmpStr.toString());
                numIndex++;
            }
        }


//        StringBuilder res = new StringBuilder();
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        System.out.println(res);
    }

    private static String getNum(String s) {
        String numStr = "";
        for (; numIndex < s.length(); numIndex++) {
            Character c = s.charAt(numIndex);
            if (!Character.isDigit(c)) {
                break;
            }
            numStr += c;
        }
        return numStr;
    }


}
