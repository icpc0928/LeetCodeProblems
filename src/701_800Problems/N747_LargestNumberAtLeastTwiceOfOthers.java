public class N747_LargestNumberAtLeastTwiceOfOthers {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,6,1,0};
        System.out.println(s.dominantIndex(nums));
    }


    static class Solution {
        public int dominantIndex(int[] nums) {
            int maxNum = 0;
            int secMax = 0;
            int maxInd = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > maxNum) {
                    secMax = maxNum;
                    maxNum = nums[i];
                    maxInd = i;
                }
                else if (nums[i] > secMax) {
                    secMax = nums[i];
                }
            }

            return maxNum >= secMax * 2 ? maxInd : -1;

        }
    }
}
