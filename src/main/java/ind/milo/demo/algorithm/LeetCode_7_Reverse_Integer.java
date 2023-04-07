package ind.milo.demo.algorithm;

/**
 * @Date 2023/4/7 9:21
 * @Created by Milo
 */
public class LeetCode_7_Reverse_Integer {
    public static void main(String[] args) {
        byte b = 127;
        System.out.println(" 127: "+String.format("%032d", Integer.parseInt(Integer.toBinaryString(b))));
        System.out.println("-128: "+Integer.toBinaryString((byte)(b+1)));
        double allOne = Math.pow(2, 31)-1;
        System.out.println(allOne);
        String s = Integer.toBinaryString((int) allOne);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));

//        System.out.println("补码: "+ format);
//        System.out.println(-128 | allOne);

        System.out.println(solution(1534236469));
        // 1534236469
        // 2147483647
        // 9646324351
    }


    public static int solution(int x) {
        StringBuilder stringBuilder = new StringBuilder(x+"");
        String xStr = stringBuilder.reverse().toString();
        if (xStr.contains("-")){
            String replace = xStr.replace("-", "");
            xStr = "-"+replace;
        }

        int ret = 0;
        try {
            ret = Integer.parseInt(xStr);
        } catch (Exception e){
            return 0;
        }

        return ret;
    }
}
