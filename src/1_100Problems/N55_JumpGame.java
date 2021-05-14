public class N55_JumpGame {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Jump Game.
    //Memory Usage: 41.1 MB, less than 37.17% of Java online submissions for Jump Game.
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {3,2,1,0,4};
        System.out.println(solution.canJump(nums));
    }

    static class Solution {
        public boolean canJump(int[] nums) {
            //最後一個元素的索引值為 nums.length() - 1
            //從最後第二個元素開始往前找 找到 該元素值 >= 該元素索引值 與 最後一個元素索引值的距離
            int lastIndex = nums.length - 1;
            for(int i = nums.length - 1; i >= 0; i--){
                if(nums[i] >= (lastIndex - i)){
                    lastIndex = i;
                }
            }
            return nums[0] >= lastIndex;
        }
    }
}
