package ind.milo.demo.algorithm.LeetCode;

import java.util.Arrays;
import java.util.Random;

/**
 * @Date 2023/4/15 16:03
 * @Created by Milo
 */
public class LC2075DecodetheSlantedCiphertext {
    public static void main(String[] args) {
        String str = "cipher";
        int rows = 3;
        System.out.println(encode(str, rows));
        Random random = new Random();
        System.out.println(random.nextInt(10));
    }

    // 遍历整个字符串，寻找每个字符在矩阵arr[][]的位置
    public static String encode(String str, int rows) {
        char arr [][]  = new char[rows][rows*2];
        int rowNo = 0;
        int colNo = 0;

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            rowNo = i % rows;
            int num = i/rows;
            colNo = num + rowNo;
            arr[rowNo][colNo] = currChar;
        }

        System.out.println(Arrays.toString(arr));

        return str;

    }
}
