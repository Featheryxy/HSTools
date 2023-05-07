package ind.milo.demo.algorithm.digui;

public class GaoSiQiuHe {
    public static void main(String[] args) {
        System.out.println(dfs(5));
    }

    private static int dfs(int i) {
        if (i == 1) {
            return 1;
        }
        int tmp = dfs(i - 1);
        return i + tmp;
    }
}
