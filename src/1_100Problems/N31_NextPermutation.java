import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class N31_NextPermutation {

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1,3,2};
        solution.nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }


    static class Solution {
        public void nextPermutation(int[] nums) {
            if(nums.length == 1) return;
            int i = nums.length - 2;
            while(i >= 0 && nums[i + 1] <= nums[i]){
                i--;
            }
            if(i >= 0){
                int j = nums.length - 1;
                while(j >= 0 && nums[j] <= nums[i]){
                    j--;
                }
                change(nums,  i, j);
            }
            reverse(nums, i + 1);
        }

        public void reverse(int[] nums, int start){
            int i = start, j = nums.length - 1;
            while(i < j){
                change(nums, i, j);
                i++;
                j--;
            }
        }
        public void change(int[] nums, int i , int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


}
