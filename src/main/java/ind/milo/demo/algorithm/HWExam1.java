package ind.milo.demo.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Date 2023/4/5 10:14
 * @Created by Milo
 */
public class HWExam1 {
    public static void main(String[] args) {
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
