import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//Runtime: 8 ms, faster than 31.33% of Java online submissions for Majority Element II.
//Memory Usage: 41.7 MB, less than 93.81% of Java online submissions for Majority Element II.

public class N229_MajorityElementII {

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {3,2,3};
        List arrayList = sol.majorityElement(nums);
        System.out.println(arrayList.toString());
    }

    static class Solution {
        public List<Integer> majorityElement(int[] nums) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            ArrayList ans = new ArrayList();
            for(int i = 0 ; i < nums.length; i++){
                if(hashMap.containsKey(nums[i])){
                    hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
                }else{
                    hashMap.put(nums[i], 1);
                }
            }
            for(int key : hashMap.keySet()){
                if(hashMap.get(key) > nums.length / 3){
                    ans.add(key);
                }
            }
            return ans;
        }
    }
}
