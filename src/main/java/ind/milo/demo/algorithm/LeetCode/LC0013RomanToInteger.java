package ind.milo.demo.algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC0013RomanToInteger {
    public static void main(String[] args) {


        System.out.println(romanToInt("XLIX")); // 49
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ret = 0;
        for (int i = 0; i < s.length(); ) {
//            if ()
            i++;
        }
        return ret;
    }
}
