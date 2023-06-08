package ind.milo.demo.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class computeIfAbsentDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);

        Integer value = map.computeIfAbsent("two", key -> key.length());
        System.out.println(value); // 输出：3，因为"two"的长度为3，作为默认值放入Map中

        value = map.computeIfAbsent("one", String::length);
        System.out.println(value);

        Integer three = map.computeIfAbsent("three", key -> -1);
        System.out.println(three);


        Map<String, List<String>> listMap = new HashMap<>();

        listMap.computeIfAbsent("Color", key -> new ArrayList()).add("Blue");


        System.out.println(listMap);
    }
}
