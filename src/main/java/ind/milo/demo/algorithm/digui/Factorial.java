package ind.milo.demo.algorithm.digui;

/**
 * 计算阶乘：f(n) = n!
 *  1         n = 0
 *  n*(n-1)!  n > 0
 */
public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(dfs(n));
    }

    private static int dfs(int n) {
        System.out.println("dfs: "+n);
        if (n == 0) {
            return 1;
        }

        return n * dfs(n - 1);
    }
}
