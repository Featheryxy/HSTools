package ind.milo.demo.function.loop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Date 2022/10/5 23:07
 * @Created by Milo
 */
public class Loop {
    public static void oriLoop(List<Double> oldList){
        List<Double> newList = new ArrayList<>();
        for (int i = 0; i < oldList.size(); i++) {
            newList.add(oldList.get(i) * 1.2);
        }
    }

    Function<Integer , Double> addTwentyPercent = x -> x * 1.2 ;

//    List<Double> map(List<Integer> list, Function<Integer, Double> f) {
//        List<Double> newList = new ArrayList<>();
//        for (Integer value : list) {
//            newList.add(f.apply(value));
//        }
//    }

    <T, U> List<U> map(List<T> list, Function<T, U> f) {
        List<U> newList = new ArrayList<>();
        for (T value : list) {
            newList.add(f.apply(value));
        }
        return newList;
    }

    @Test
    public void test() {
        Optional<Object> o = Optional.ofNullable(null);

        System.out.println(o.orElseGet(()->"1"));
    }

}
