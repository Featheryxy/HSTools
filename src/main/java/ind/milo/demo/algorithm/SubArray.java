package ind.milo.demo.algorithm;

import java.util.*;

/**
 * 题目一：
 *
 * 给出一个数组 list = [1,2,3,4,5,6]
 *
 * 求此数组的所有子集合
 *
 * 输出：[1]，[1,2]，[1,2,3]…
 *
 *
 * 题目二：
 *
 * 给出一个数组 list = [1,2,3,4,5,6]
 *
 * 求此数组的所有子集合中和为6的子集
 *
 * 输出：[6，[2,4]，[1,5]，[1,2,3]
 */
public class SubArray {
    public static void main(String[] args) {

        // 测试数组
        int[] list = {1,2,3,4,5,6} ;

        // 保存结果集
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();

        // 递归调用
        subList(list, 0, resultList, subList);

        // 求数组的子集
        System.out.println("数组的所有子集合：");
        for (List<Integer> sub : resultList) {
            System.out.println(Arrays.toString(sub.toArray()));
        }

        // 求各个子集中 和 为6的集合
        System.out.println("输出和为：6");
        for (List<Integer> sub : resultList) {
            int sum = sub.stream().reduce(0, Integer::sum);
            if (sum == 6) {
                System.out.println(Arrays.toString(sub.toArray()));
            }
        }
    }

    public static void subList(int[] list , int index,
                               List<List<Integer>> resultList, List<Integer> subList) {

        int size = list.length ;
        if(size == 0) {
            return;
        }
        resultList.add(new ArrayList<>(subList));

        for (int i = index; i < size; ) {
            subList.add(list[i]);
            subList(list, ++i, resultList, subList);
            subList.remove(subList.size() - 1);
        }
    }
}
