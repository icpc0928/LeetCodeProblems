import java.util.Arrays;

public class N628_MaximumProductOfNumbers {

    public static void main(String[] args) {

    }

    static class Solution {
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);

            int firstResult = nums[0] * nums[1] * nums[nums.length - 1];
            int secResult = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
            return Math.max(firstResult, secResult);
        }
    }
}
