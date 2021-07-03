import java.util.HashMap;

public class N169_MajorityElement {

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(sol.majorityElement(nums));
    }

    static class Solution {
        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int maxTimes = 1;
            for(int i = 0; i < nums.length; i++){
                if(hashMap.containsKey(nums[i])){
                    hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
                    maxTimes = Math.max(hashMap.get(nums[i]), maxTimes);
                }else{
                    hashMap.put(nums[i], 1);
                }
            }

            for(int key : hashMap.keySet()){
                if(hashMap.get(key) == maxTimes){
                    return key;
                }
            }
            return 0;
        }
    }
}
