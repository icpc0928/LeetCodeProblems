public class N53_MaximumSubarray {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int ans = solution.maxSubArray(nums);
        System.out.println(ans);

    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int sum = 0;                    //暫存過程中每加一個值是否是正收益
            int max = Integer.MIN_VALUE;    //紀錄最大
            for (int num : nums) {
                sum += num;
                max = Math.max(sum, max);

                if (sum < 0)
                    sum = 0;
            }
            return max;
        }
    }
}
