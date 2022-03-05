import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class N287_FindTheDuplicateNumber {

    public static void main(String[] args){
        int[] nums = {1,3,4,2,2,};
        Solution solution = new Solution();
        System.out.println(solution.findDuplicate(nums));
    }

    static class Solution {
        public int findDuplicate(int[] nums) {
            Set<Integer> seen = new HashSet<Integer>();
            for (int num : nums) {
                if (seen.contains(num))
                    return num;
                seen.add(num);
            }
            return -1;
        }
    }
}
