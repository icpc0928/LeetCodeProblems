
import java.util.HashMap;
import java.util.Map;

public class N26_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1,1,2,2,3};
        int ans = solution.removeDuplicates(nums);
//        System.out.println(ans);
        for(int i = 0; i < nums.length ;i++){
            System.out.println(nums[i]);
        }
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) return 0;
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;

        }
    }
}
