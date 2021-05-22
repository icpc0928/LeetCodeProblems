import java.util.Arrays;

public class N45_JumpGameII {

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {2,3,1,1,4}; //=>5
        System.out.println(solution.jump(nums));
    }

    static class Solution {
        public int jump(int[] nums) {
            if(nums.length==1) return 0;
            int[] dp = new int[nums.length];
            Arrays.fill(dp, Integer.MAX_VALUE); //將每個點設定為: 走到該點至少需要的次數
            dp[0]=0;                            //一開始是0
            for(int i = 0; i < nums.length - 1; i++){
                for(int j = i + 1; j < nums.length && j <= i + nums[i]; j++){   //從下一個開始找直到 i能走的最大步數(或是終點)
                    dp[j] = Math.min(dp[i] + 1, dp[j]);                         //求出走到該點最少需要的次數
                }
            }

            return dp[nums.length-1];
        }
    }
}
