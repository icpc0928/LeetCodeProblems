public class N70_ClimbingStairs {

    public static void main(String[] args){
        Solution solution = new Solution();
        int n = 45;
        for(int i = 1; i <= n; i++){
            int ans = solution.climbStairs(i);
            System.out.println(i + ": " + ans);
            int ans2 = solution.climbStairs1(i);
            System.out.println(i + ": " + ans2);
        }

    }

    //費波納奇數列
    static class Solution {
        public int climbStairs(int n) {
            /**
             * dp[i] represent the number of ways to reach the ith index;
             * ith index can be reached from the last or last second index only
             * Time Complexity - O(N)
             * Space Complexity - O(N)
             */

             if (n <= 2) return n;
             int[] dp = new int[n];
             dp[0] = 1;
             dp[1] = 2;
             for (int i = 2; i < n; i++) {
                 dp[i] = dp[i - 1] + dp[i - 2];
             }
             return dp[n - 1];

        }
        /**
         * Reducing space complexity.
         * lastSecond represent the number of ways to reach the lastSecond traversed index;
         * last represent the number of ways to reach the last traversed index;
         * Time Complexity - O(N)
         * Space Complexity - O(1)
         */

        public int climbStairs1(int n) {
            if (n <= 2) return n;
            int lastSecond = 1;
            int last = 2;
            for (int i = 2; i < n; i++) {
                int lastSecondTemp = lastSecond;
                int lastTemp = last;
                lastSecond = lastTemp;
                last = lastSecondTemp + lastTemp;
            }
            return last;
        }
    }


}
