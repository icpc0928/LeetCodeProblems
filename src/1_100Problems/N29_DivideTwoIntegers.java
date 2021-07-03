public class N29_DivideTwoIntegers {

    //不熟,只知道要用<<

    public static void main(String[] args){
        Solution solution = new Solution();
        int dividend = 2147483647;
        int divisor = 3;
        int ans = solution.divide(dividend, divisor);
        System.out.println(ans);
    }


    static class Solution {
        public int divide(int dividend, int divisor) {
            //結果為正 or 負
            boolean positive = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0));
            //將除數與被除數轉long
            long dividendL = Math.abs((long)dividend);
            long divisorL = Math.abs((long)divisor);
            //
            long res = 0;   //結果
            //當被除數大於等於除數時
            while(dividendL >= divisorL){
                // 除數
                long d = divisorL;
                // 被除數>除數 至少有1個
                long count=1;
                // 當被除數 >= 兩倍的除數
                while(dividendL >= (d << 1)){
                    // 除數*2
                    d = (d<<1);
                    // 被除數包含除數的個數*2
                    count = (count << 1);
                }
                // 個數累加
                res += count;
                // 被除數減去除數
                dividendL -= d;
            }
            // 如果返回结果大于int最大值
            if(res > Integer.MAX_VALUE){
                // 如果结果是正数，返回int最大值，反之返回int最小值
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            return positive ? (int)res : (int)-res;

        }
    }
}
