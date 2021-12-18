import java.util.HashMap;

public class N219_ContainsDuplicateII {

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {99,99,};
        int k = 2;
        System.out.println(s.containsNearbyDuplicate(nums, k));
    }

    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if(nums.length == 1) return false;

            HashMap<Integer, Integer> hashMap = new HashMap<>();

            for(int i = 0; i < nums.length; i++){
                if(hashMap.containsKey(nums[i])){
                    if(Math.abs(hashMap.get(nums[i]) - i) <= k){
                        return true;
                    }else{
                        //之前put過的就不用了,因為是一直往後找,前面的離更遠沒意義
                        hashMap.put(nums[i], i);
                    }
                }else{
                    hashMap.put(nums[i], i);
                }
            }
            return false;
        }
    }
}
