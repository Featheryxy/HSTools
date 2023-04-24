package ind.milo.demo.algorithm.HWOD;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 1. R
 * 2. BR
 * 3. RBBR
 * 4. BRRBRBBR
 * 5. RBBRBRRBBRRBRBBR
 * ...
 * 即将上一个字符进行反转+上一个字符
 * 求第n个字符的第k个字符是多少
 */
public class HWString {
    public static void main(String[] args) {
        // 使用一个数组记录N个字符串，
        int N = 5;
        String[] ans = new String[N];


        for (int i = 0; i < N; i++) {
            if (i == 0) {
                String tmpStr = "R";
                ans[i] = tmpStr;
                continue;
            }
            String tmpStr = ans[i - 1];
            String currStr = workAgain(tmpStr) + tmpStr;
            ans[i] = currStr;
        }

        System.out.println(Arrays.toString(ans));

    }

    private static String workAgain(String tmpStr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <tmpStr.length(); i++) {
            stringBuilder.append((char) ('R' + 'B' - tmpStr.charAt(i)));
        }

        return stringBuilder.toString();

    }

    private static void method1() {
        Scanner in = new Scanner(System.in);
        int exampleNums = in.nextInt();
        int N = 10;
        String[] ans = new String[N];
        String tmpStr = "R";
        ans[0] = tmpStr;
        for (int i=1; i < N; ++i) {
            tmpStr = work(tmpStr)+tmpStr;
        }


        while (exampleNums-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            if (ans[n-1].charAt(k) == 'R') {
                System.out.println("red");
            } else {
                System.out.println("blue");
            }
        }
    }


    private static String work(String str) {
        StringBuilder sb = new StringBuilder(str);
        for(int i=0; i<sb.length(); i++) {
            sb.setCharAt(i, (char)('R'+'B'-sb.charAt(i)));
        }
        return sb.toString();

    }

    private static String getNthString(int n, int k) {
        if (n==1) return "R";
        String last = getNthString(n-1, k>>1);
        char[] chars = new char[last.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = last.charAt(i) == 'R'?'B':'R';
        }

        if ((k&1) == 0){
            return new String(chars) + last;
        } else {
            return last+new String(chars);
        }
    }
}
