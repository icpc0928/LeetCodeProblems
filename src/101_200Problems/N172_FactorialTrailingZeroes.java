public class N172_FactorialTrailingZeroes {
//Runtime: 1 ms, faster than 30.95% of Java online submissions for Factorial Trailing Zeroes.
//Memory Usage: 37.8 MB, less than 11.12% of Java online submissions for Factorial Trailing Zeroes.

    //階乘
    //n 5 => 5! = 120 後綴有1個0 輸出1
    //要算多少個後綴0 -> 要看乘上幾次10  , 10 = 2 * 5 ,在階乘中,2已經很多了,所以只看5
    //5的倍數,每5個值會多出一個後綴0
    //但當25,50,75,100 =>會多出2個後綴0
    //所以解法為 n/=5 累加

    static class Solution {
        public int trailingZeroes(int n) {
//            //除法解法
//            int ans = 0;
//            while(n > 0){
//                n /= 5;
//                ans += n;
//
//            }
//            return ans;

            //乘法解法  速度較快
            int s = 0;
            int t = 5;
            while(t <= n){
                s += n / t;
                t *= 5;
            }
            return s;
        }
    }
}
