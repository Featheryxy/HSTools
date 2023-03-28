package ind.milo.demo.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Date 2023/3/3 17:44
 * @Created by Milo
 */
public class StringStream {
    @Test
    public void test1() {
        String str = "0,1,2,3,4,5,6,7,8,9";
        String[] split = str.split(",");
//        String reduce = Arrays.stream(split).reduce("(", (x, y) -> x = x + "','" + y);
//        System.out.println(reduce);
        String collect = Arrays.stream(split)
                .map(s -> "'" + s + "'")
                .collect(Collectors.joining(",", "(", ")"));
        String collect1 = Arrays.stream(str.split(","))
                .map(s -> "'" + s + "'")
                .collect(Collectors.joining(","));
        System.out.println(collect);
        System.out.println(collect1);

        Integer a = 13;
        int i = a;

        int i1 = Integer.parseInt("13");
        Integer integer = Integer.valueOf("13");
    }

    @Test
    public void test2() {
        String str = "0,1,2,3,4,9,5,6,7,8";
        String[] split = str.split(",");
        Stream<String> split1 = Stream.of(split);
//        split1.sorted(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                Character
//            }
//        })
    }
}

