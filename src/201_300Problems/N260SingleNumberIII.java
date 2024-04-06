import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class N260SingleNumberIII {
    static class Solution {
        public int[] singleNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();

            for(int i = 0; i < nums.length; i++){
                if(set.contains(nums[i])){
                    set.remove(nums[i]);
                }else{
                    set.add(nums[i]);
                }
            }
            int[] result = new int[2];
            int index = 0;
            for(int num : set){
                result[index++] = num;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = {1,2,1,3,2,5};
        int[] result = s.singleNumber(nums);
        System.out.println(Arrays.toString(result));

        int i = 6;
        int diffI = i & -i;

        for(int num : nums){
            System.out.println(num & diffI);

        }
    }
    //這是copilot 建議的解法 但是我不太懂
    static class Solution2 {
        public int[] singleNumber(int[] nums) {
            int diff = 0;
            for(int num : nums){
                diff ^= num;
            }
            diff &= -diff;


            int[] result = new int[2];
            for(int num : nums){
                if((num & diff) == 0){
                    result[0] ^= num;
                }else{
                    result[1] ^= num;
                }
            }
            return result;
        }
    }

}
