import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class N217_ContainsDuplicate {

    public static void main(String[] args){

        int[] nums = {1,2,3,4,1};
        Solution solution = new Solution();

        System.out.println(solution.containsDuplicate(nums));

    }

    static class Solution {

        public boolean containsDuplicate(int[] nums) {
//            HashMap<Integer, Integer> hashMap = new HashMap<>();
//            for(int i = 0; i < nums.length; i++){
//                if(hashMap.containsKey(nums[i])){
//                    return true;
//                }else{
//                    hashMap.put(nums[i], 1);
//                }
//            }
//            return false;
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < nums.length; i++){
                if(!set.add(nums[i])){
                    return true;
                }
            }
            return false;
        }
    }
}
