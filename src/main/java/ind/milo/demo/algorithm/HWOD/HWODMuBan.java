package ind.milo.demo.algorithm.HWOD;

import java.util.Arrays;

/**
 * @Date 2023/4/6 9:41
 * @Created by Milo
 * 示例1
 * 输入：
 * 5 3
 * 4 5 3 5 5
 * 输出：
 * 5
 * 说明：
 * 给第1块木板长度增加1，给第3块木板长度增加2后，这5块木板长度变为[5,5,5,5,5]，最短的木板的长度最大为5。
 */
public class HWODMuBan {
    public static void main(String[] args) {
        int m = 5;
        int n = 5;
        int [] arr = new int[] {4, 5, 3, 5, 5};
        // 先对数组排序，{3，4，5，5，5}
        // 从第二根模板开始遍历数组，如果当前的木板大于左边木板，为左边的木板长度加一
        // 遍历后都没有增加木板长度，则在最后一根木板添加
        Arrays.sort(arr);
        while (n-- > 0){
            for (int i=1; i<m; i++) {
                if(arr[i] > arr[i-1]){
                    arr[i-1] = arr[i-1] + 1;
                    break;
                }
                // 所有木材一样长则在最后一根上加一截
                if(i== m-1){
                    arr[i] ++;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
