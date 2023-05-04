package ind.milo.demo.algorithm.digui;

/**
 *  0     n = 0
 *  1     n = 1
 *  (n-2) * (n-1) n >1
 *
 *  0, 1, 1, 2, 3
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(dfs(i)+" ");
        }
        dfs(n);
    }

    private static int dfs(int n) {
        if (n <= 1) {
            return n;
        }

        int tmp = dfs(n - 1) + dfs(n - 2);
        return tmp;
    }
}
