package ind.milo.demo.algorithm.SwordOffer;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2023/4/11 16:48
 * @Created by Milo
 */
public class Offer20 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//        Map<String, Integer>[] states = {
//                new HashMap<>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
//                new HashMap<>() {{ put('d', 2); put('.', 4); }},                           // 1.
//                new HashMap<>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
//                new HashMap<>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
//                new HashMap<>() {{ put('d', 3); }},                                        // 4.
//                new HashMap<>() {{ put('s', 6); put('d', 7); }},                           // 5.
//                new HashMap<>() {{ put('d', 7); }},                                        // 6.
//                new HashMap<>() {{ put('d', 7); put(' ', 8); }},                           // 7.
//                new HashMap<>() {{ put(' ', 8); }}                                         // 8.
//        };


        HashMap<Object, Object> map = new HashMap<>();
        // 匿名内部类并且重写了父类Hashmap的size方法
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<String, Integer>(){
            // 等价于代码块，
            {put("1", 2);}

            @Override
            public int size() {
                return 2*super.size();
            }
        };

        HashMap hashMap = stringIntegerHashMap.getClass().newInstance();
        System.out.println(stringIntegerHashMap.getClass());
        System.out.println(hashMap.getClass());
        System.out.println(map.getClass().getClassLoader()); //
        System.out.println(stringIntegerHashMap.getClass().getClassLoader()); // AppClassLoader
        System.out.println(hashMap.getClass().getClassLoader());

        System.out.println(map.getClass().isAssignableFrom(stringIntegerHashMap.getClass()));
        Method[] methods = stringIntegerHashMap.getClass().getMethods();
        System.out.println(Arrays.toString(methods));
        System.out.println(stringIntegerHashMap.size());
//        HashMap<String, Integer> stringIntegerHashMap2 = new HashMap<>() {{ put(' ', 8); }};

        int[] arr = {1, 2,3};
        System.out.println(arr);
    }

    public static boolean isNumber(String s) {

        return false;
    }
}
