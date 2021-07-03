import java.util.Arrays;

public class N189_RotateArray {
    //Runtime: 12 ms, faster than 16.99% of Java online submissions for Majority Element.
    //Memory Usage: 43.1 MB, less than 63.13% of Java online submissions for Majority Element.


    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {1,2};
        int k = 1;
        sol.rotate(nums, k);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " , ");
        }
    }


    static class Solution {
        public void rotate(int[] nums, int k) {

            int rotateTimes = k % nums.length;
            if(rotateTimes == 0) return;
            int[] newNums = Arrays.copyOf(nums, nums.length);
            for(int i = 0; i < nums.length; i++){
                nums[i] = newNums[(nums.length + i - rotateTimes) % nums.length];
            }
        }
    }

}
