import java.util.Arrays;
import java.util.HashSet;

/**
 * Runtime: 7 ms, faster than 28.48% of Java online submissions for Set Mismatch.
 * Memory Usage: 43.6 MB, less than 97.29% of Java online submissions for Set Mismatch.
 */
public class N645_SetMismatch {



    public static void main(String[] args) {
        int[] nums = new int[]{
                6,8,7,8,3,4,2,1,
        };
        Solution s = new Solution();
        System.err.println(Arrays.toString(s.findErrorNums(nums)));
    }
    //一陣列其元素為 1~陣列.len,  找出其中1個重複的元素,及缺失的元素
    //這題很有意思,應該要在一次迴圈內做完
    static class Solution {
        public int[] findErrorNums(int[] nums) {

            int[] result = new int[2];
            int sum = 0;
            int needSum = ((1 + nums.length) * nums.length) / 2;
            HashSet<Integer> checkSet = new HashSet<>();
            int size = 0;
            for(int i = 0; i < nums.length; i++){
                sum += nums[i];

                if(result[0] == 0){
                    checkSet.add(nums[i]);
                    //出現重複元素
                    if(checkSet.size() == size){
                        result[0] = nums[i];
                    }
                    size++;
                }
            }

            result[1] = needSum - sum + result[0];
            return result;
        }
    }
}
