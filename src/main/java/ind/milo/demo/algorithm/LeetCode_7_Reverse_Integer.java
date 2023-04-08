package ind.milo.demo.algorithm;

/**
 * @Date 2023/4/7 9:21
 * @Created by Milo
 * https://leetcode.cn/problems/reverse-integer/
 * 输入：x = -123
 * 输出：-321
 */
public class LeetCode_7_Reverse_Integer {
    public static void main(String[] args) {
        int x = 1534236469;
        int ret = 0;
        boolean isNeg = false;
        if (x<0) {
            isNeg = true;
        }
        int tmp = Math.abs(x);
        while (tmp>0){
            int last = tmp % 10;
            ret = ret*10+last;

            tmp = tmp/10;
        }

        if (ret<Integer.MIN_VALUE || ret >Integer.MAX_VALUE) {
            System.out.println(0);
        }
        // 964632435
        // 2147483647

        if (isNeg) {
            System.out.println(-ret);
        } else {
            System.out.println(ret);
        }

        System.out.println((int)(1056389759));
//        System.out.println(solution1(-1534236469));
        // 1534236469
        // 2147483647
        // 9646324351 超过了int类型的最大值
    }

    private static void test() {
        byte b = 127;
        System.out.println(" 127: "+String.format("%032d", Integer.parseInt(Integer.toBinaryString(b))));
        System.out.println("-128: "+Integer.toBinaryString((byte)(b+1)));
        double allOne = Math.pow(2, 31)-1;
        System.out.println(allOne);
        String s = Integer.toBinaryString((int) allOne);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
    }


    public static int solution1(int x) {
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
