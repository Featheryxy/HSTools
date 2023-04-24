package ind.milo.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2023/4/24 16:49
 * @Created by Milo
 */
public class HWODRanSe {
    public static void main(String[] args) {
        int m = 4; // 节点数量
        int n = 3; // 边数量
        List<int[]> edges = new ArrayList<>();
        int[] int1 = {0, 1};
        int[] int2 = {1, 2};
        int[] int3 = {2, 3};
        edges.add(int1);
        edges.add(int2);
        edges.add(int3);


        // output = 8;
        int count = 0;
        // 由于一个节点只能染红色或黑色，只有两个选择
        // 所以m个节点一共会有2^m次个染色方案
        for (int i = 0; i < (1 << m); i++) {
            // 默认相邻节点都不同色
            boolean flag = true;
            // 遍历所有边，如果该边连接的两个节点颜色相同（都为1），不统计
            for (int[] edge : edges) {
                // 任意相邻节点不能都为红色，如果相同，则该染色方案不符合
                if ((((i >> edge[0]) & 1) == 1 )&& (((i >> edge[1]) & 1) == 1)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        System.out.println(count);
    }
}
