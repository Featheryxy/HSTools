package ind.milo.demo.algorithm.digui;

/**
 题目描述：
 一个台阶总共有n级，如果一次可以跳1级，也可以跳2级。求总共有多少总跳法。
 第一行输入T，表示有多少个测试数据。接下来T行，每行输入一个数n，表示台阶的阶数。
 输出时每一行对应一个输出。
 样例输入：
 3
 5
 8
 10
 样例输出：
 8
 34
 89

f(n) =  {
    1, n = 1
    2, n = 2
    f(n-1)+f(n-2) n>2
 }



 */
public class ZouLouTi {
    public static void main(String[] args) {

    }
}
