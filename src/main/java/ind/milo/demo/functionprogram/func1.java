package ind.milo.demo.functionprogram;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

@Slf4j
public class func1 {


    public static int div(int a, int b) {
        return (int) (a / (float) b);
    }

    public static int add(int a, int b) {
        log.info("a: {}, b: {}, a+b={}", a, b, a + b);
        return a + b;
    }

    public static int mult(int a, int b) {
        return a * b;
    }

    Function<Integer, Integer> square = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer arg) {
            return arg * arg;
        }
    };

//    Function compose(final Function f1, final Function f2) {
//        return new Function() {
//            @Override
//            public Object apply(Object o) {
//                return f1.apply(f2.apply(o));
//            }
//        };
//    }

    static Function<Integer, Integer> compose(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        return arg -> f1.apply(f2.apply(arg));
//        return new Function<Integer, Integer>() {
//            @Override
//            public Integer apply(Integer arg) {
//                return f1.apply(f2.apply(arg));
//            }
//        };
    }

    @Test
    public void test1() {
        // <para1, para2> para1为定义域的类型,para2为陪域类型
        // Function<Integer, Function<Integer, Integer>>
        // 上式等价于 Integer -> (Integer -> Integer) i.e.: <Integer , <Integer -> Integer>>
        Function<Integer, String> add = arg -> String.valueOf(arg + 1.3);
        System.out.println(add.apply(1));
    }

    @Test
    public void test2() {
        Function<Integer, Function<Integer, Integer>> add = x -> y -> x+y;
        System.out.println(add.apply(1).apply(2));
    }


    private static void overflow() {
        int fnum = 10000;
        Function<Integer, Integer> g = x -> x;
        Function<Integer, Integer> f = y -> y + 1;
        for (int i = 0; i < fnum; i++) {
            g = compose(f, g);
            System.out.println(i);
        }
        System.out.println(g.apply(0));
    }

    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> add = x -> y -> x + y;
        System.out.println(add.apply(3).apply(5));
        // scale 可以写成 add(3)(5)

    }


}
