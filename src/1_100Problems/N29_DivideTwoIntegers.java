public class N29_DivideTwoIntegers {


    public static void main(String[] args){
        Solution solution = new Solution();
        int dividend = 2147483647;
        int divisor = 3;
        int ans = solution.divide(dividend, divisor);
        System.out.println(ans);
    }


    static class Solution {
        public int divide(int dividend, int divisor) {
            boolean positive = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0));

            if(dividend == Integer.MIN_VALUE && divisor == -1){
                return Integer.MAX_VALUE;
            } else if(divisor == Integer.MIN_VALUE && dividend != Integer.MIN_VALUE){
                return 0;
            }

            //轉負數
            if(dividend > 0){
                dividend = ~dividend + 1;
            }
            if(divisor > 0){
                divisor = ~divisor + 1;
            }

            int quotient = 0;

            //做除法取商
            while(dividend <= divisor){
                int q = -1;
                int r = divisor;
                while(r > dividend){
                    r = r << 1;     //除以2的1次方
                    q = q << 1;
                }
                if(r < dividend){
                    r = r >> 1;     //乘以2的1次方
                    q = q >> 1;
                }
                dividend -= r;
                quotient += q;
            }

            //取正確的商
            if(positive){
                if(quotient == Integer.MIN_VALUE){
                    quotient++;
                }
                quotient = ~quotient + 1;
            }
            return quotient;

        }
    }
}
