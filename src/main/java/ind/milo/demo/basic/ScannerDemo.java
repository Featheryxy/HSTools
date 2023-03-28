package ind.milo.demo.basic;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Date 2023/3/27 13:39
 * @Created by Milo
 */
public class ScannerDemo {
    public static void main(String[] args) {
        char a = 'a';
        System.out.println((byte)(a));

        byte a1 = 65;
        System.out.println((char) (97));

        System.out.println(Character.isDigit('1'));
        Character.isLetter('a');
        System.out.println("a".matches("[A-Za-z]"));
    }

    private static void test6() {
        float curNum = (float) 1.9;
        int ret = (int)(curNum + 0.5);
        System.out.println(ret);
    }

    private static void test5() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            while (str.length() > 8) {
                System.out.println(str.substring(0, 8));
                str = str.substring(8);
            }

            if (str.length() != 0) {
                System.out.println(String.format("%-8s", str).replace(" ", "0"));
                return;
            }
//            int loopNums = str.length() / 8 + 1;
//            for (int i = 0; i < loopNums; i++) {
//                String temStr = str.substring(8 * i, 8 * i+8);
//                if (temStr.length() != 8) {
//                    System.out.println(String.format("%-8s", temStr).replace(" ", "0"));
//                } else {
//                    System.out.println(temStr);
//                }
//
//            }
        }
    }

    public void  test4() {
        int i = 7;

        System.out.println(String.format("%04d", i));
        System.out.println(String.format("%-4s",i));
        System.out.println(String.format("%-4s",i).replace(" ", "0"));
    }

    private static void test3() {
    /*
    描述
明明生成了
�
N个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。

数据范围：
1
≤
�
≤
1000

1≤n≤1000  ，输入的数字大小满足
1
≤
�
�
�
≤
500

1≤val≤500
输入描述：
第一行先输入随机整数的个数 N 。 接下来的 N 行每行输入一个整数，代表明明生成的随机数。 具体格式可以参考下面的"示例"。
输出描述：
输出多行，表示输入数据处理后的结果
     */
        Scanner in = new Scanner(System.in);
        TreeSet treeSet = new TreeSet<>();
        while (in.hasNextInt()) {
            int nums = in.nextInt();
            for (int i=0; i<nums; i++) {
                treeSet.add(in.nextInt());
            }
            treeSet.stream().sorted().forEach(System.out::println);
        }
    }

    private static void test2() {
        // 输入描述：
        //
        //第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
        //
        //输出描述：
        //
        //输出输入字符串中含有该字符的个数。（不区分大小写字母）
        System.out.println("Please input words: ");
        Scanner in = new Scanner(System.in);
        String firstStr = in.nextLine().toLowerCase(Locale.ROOT);
        char chr = in.nextLine().charAt(0);

        int count = 0;
        for (int i = 0; i < firstStr.length(); i++) {
            if (firstStr.charAt(i) == chr) {
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void test(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }

    public void test1(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please input words: ");
        while (in.hasNext()) {
            String str = in.nextLine();
            int idx = str.lastIndexOf(" ");
            System.out.println(str.length()-idx-1);
        }
    }
}
