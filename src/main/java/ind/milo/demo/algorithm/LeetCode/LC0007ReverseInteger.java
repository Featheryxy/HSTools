package ind.milo.demo.algorithm.LeetCode;

/**
 * @Date 2023/4/7 9:21
 * @Created by Milo
 * https://leetcode.cn/problems/reverse-integer/
 * 输入：x = -123
 * 输出：-321
 */
public class LC0007ReverseInteger {
    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverseOffice(x));

//        System.out.println(solution1(-1534236469));
        // 1534236469
        // 2147483647
        // 9646324351 超过了int类型的最大值
    }


    public static int reverse(int x) {
        long ret = 0;
//        boolean isNeg = x<0;

        int tmp = Math.abs(x);
        while (tmp!=0){
            int last = tmp % 10;
            //
            ret = ret*10+last;

            tmp = tmp/10;
        }

        return (int)ret == ret?(int)ret:0;
    }


    public static int reverseOffice(int x) {
        int res = 0;
        while (x != 0) {
            // a % 10 = b, i.e.: a = 10*n+b
            // e.g.: (-123 % 10) = -3 , -123 = -12*10 + (-3)
            // 负数取余也会带上符号，如 -123%10 = -3
            int temp = x % 10;
            int newRes = res * 10 + temp;
            // 是否有溢出
            if ((newRes - temp) / 10 != res) {
                return 0;
            }
            res = newRes;
            x /= 10;
        }
        return res;
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
