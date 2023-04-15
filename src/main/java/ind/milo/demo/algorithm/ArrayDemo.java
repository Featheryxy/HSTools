package ind.milo.demo.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Date 2023/4/3 11:12
 * @Created by Milo
 */
public class ArrayDemo  {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 3, 7, 9, 2, 10);
        integers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }
}
