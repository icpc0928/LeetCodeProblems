import java.util.Arrays;

public class N384_ShuffleAnArray {

    //Runtime: 71 ms, faster than 93.32% of Java online submissions for Shuffle an Array.
    //Memory Usage: 47.6 MB, less than 23.41% of Java online submissions for Shuffle an Array.

    public static void main(String[] args){
        int[] nums = {1,2,3};
        Solution solution = new Solution(nums);

    }

    static class Solution {

        int[] nums;

        public Solution(int[] nums) {
            this.nums = Arrays.copyOf(nums, nums.length);
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return this.nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] newNums = Arrays.copyOf(nums, nums.length);

            for(int i = 0; i < newNums.length; i++){
                int temp = newNums[i];
                int rand = (int)(Math.random() * newNums.length);
                newNums[i] = newNums[rand];
                newNums[rand] = temp;
            }
            return newNums;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */


}
