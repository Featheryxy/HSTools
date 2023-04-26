package ind.milo.demo.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Date 2023/4/25 19:06
 * @Created by Milo
 */
public class test {
    public static void main(String[] args) {
        int target = 10;
        int[] nums = {0, 2, 2, 3, 5, 5, 5};

        Arrays.stream(nums).map((num1) -> (num1 + 1)).forEach(
                System.out::println
        );

    }
}
