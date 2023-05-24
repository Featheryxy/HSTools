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
        ArrayList<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(3);
        l.add(1);
        l.add(6);
        l.add(0, 4);
        l.remove(1);
        System.out.println(l);

        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a, b);
        System.out.println(a+","+b);
    }

    public static void operator(StringBuffer x, StringBuffer y){
        x.append(y);
        y = x;
    }
}
