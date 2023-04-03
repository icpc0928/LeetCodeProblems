import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N264_UglyNumberII {

    public static void main(String[] args) {
        int i = 20;
        Solution s = new Solution();
        System.out.println(s.nthUglyNumber(i));
    }

    static class Solution {
        public int nthUglyNumber(int n) {
            int[] uglyArr = new int[n];
            uglyArr[0] = 1;
            int index2 = 0, index3 = 0, index5 = 0; //這是要加總的個別個數
            int f2 = 2, f3 = 3, f5 = 5;  //這是目前最小個數 到時候算出要乘以幾

            for(int i = 1; i < n; i++){
                int min = Math.min(Math.min(f2, f3), f5);
                uglyArr[i] = min;
                if(f2 == min){
                    f2 = uglyArr[++index2] * 2; //預存下一個可能的最小值
                }
                if (f3 == min){
                    f3 = uglyArr[++index3] * 3; //預存下一個可能的最小值
                }
                if (f5 == min){
                    f5 = uglyArr[++index5] * 5;//預存下一個可能的最小值
                }
                System.out.println("f2: " + f2 + " , f3: " + f3 + " , f5: " + f5 + " , uglyNum: " + uglyArr[i] + " , i2: "+ index2 + " ,i3: "+ index3 + " , i5: " + index5);
                System.out.println(Arrays.toString(uglyArr));
            }
            return uglyArr[n - 1];
        }



    }
}
