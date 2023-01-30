package ind.milo.demo.basic;

import java.util.Arrays;

/**
 * @Date 2023/1/29 13:56
 * @Created by Milo
 */
public class CompareTest implements Comparable{
    private int a;

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        //
        Arrays.sort(arr, (a, b)->{
            return -a.compareTo(b);
        });

        System.out.println(Arrays.toString(arr));
    }


}
