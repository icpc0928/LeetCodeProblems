public class N50_Pow_x_n {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Pow(x, n).
    //Memory Usage: 37.8 MB, less than 91.99% of Java online submissions for Pow(x, n).

    public static void main(String[] args){
        Solution solution = new Solution();
        double x = 2;
        int n = -10;
        System.out.println(solution.myPow(x, n));
    }

    static class Solution {
        public double myPow(double x, int n) {
            double ans = 1.0;
            long num = n;
            if(num < 0) num *= -1;  //n 轉正數
            while(num > 0){
                //能平方就平方,不能平方就乘上自己一次 n = n/2 直到n == 0
                if(num % 2 == 1){
                    ans *= x;
                    num--;
                }else{
                    x *= x;
                    num /= 2;
                }
            }
            if(n < 0){
                ans = 1.0 / ans;
            }
            return ans;
        }
    }

}
