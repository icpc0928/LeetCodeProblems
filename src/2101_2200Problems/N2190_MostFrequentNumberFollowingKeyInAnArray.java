import java.util.HashMap;

/**
 * Runtime: 3 ms, faster than 70.03% of Java online submissions for Most Frequent Number Following Key In an Array.
 * Memory Usage: 46.7 MB, less than 31.98% of Java online submissions for Most Frequent Number Following Key In an Array.
 */

public class N2190_MostFrequentNumberFollowingKeyInAnArray {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,100,200,1,100};
        int key = 1;
        System.out.println(s.mostFrequent(nums, key));
    }

    static class Solution {
        public int mostFrequent(int[] nums, int key) {

            HashMap<Integer, Integer> counter = new HashMap<>();
            int maxValueKey = 0;
            int maxValue = 0;

            for(int i = 0; i < nums.length - 1; i++){
                if(nums[i] == key){

                    counter.put(nums[i + 1], counter.getOrDefault(nums[i + 1], 0) + 1);
                    if(counter.get(nums[i + 1]) > maxValue){
                        maxValue = counter.get(nums[i + 1]);
                        maxValueKey = nums[i + 1];
                    }
                }
            }
            System.out.println(maxValueKey);

//            for(int countersKey : counter.keySet()){
//                if(counter.get(countersKey) > maxValue){
//                    maxValue = counter.get(countersKey);
//                    maxValueKey = countersKey;
//                }
//            }

            return maxValueKey;
        }
    }
}
