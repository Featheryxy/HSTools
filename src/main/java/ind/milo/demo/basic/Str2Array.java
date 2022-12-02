package ind.milo.demo.basic;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * @Date 2022/12/2 13:58
 * @Created by Milo
 */
public class Str2Array {
    public static void main(String[] args)
    {
        String s = "string of words";
        String[] strArr = s.split("\\s+");//Splitting using whitespace
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(strArr));
        System.out.println("The String is: " + s);
        System.out.println("The ArrayList is: " + list);

        int[] test_int = new int[] { 1, 2, 3, 4, 5};

        int[] test_int1 = Arrays.copyOfRange(test_int, 0, 3);
        int[] test_int2 = Arrays.copyOfRange(test_int, 3, 9);
        System.out.println(Arrays.toString(test_int1));
        System.out.println(Arrays.toString(test_int2));
    }

}
