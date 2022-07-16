import java.util.*;

/**
 * Runtime: 105 ms, faster than 5.23% of Java online submissions for Find All Numbers Disappeared in an Array.
 * Memory Usage: 75.9 MB, less than 5.16% of Java online submissions for Find All Numbers Disappeared in an Array.
 */
public class N448_FindAllNumbersDisappearedInAnArray {

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new ArrayList<>();

            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i = 0; i < nums.length; i++){
                Math.abs(nums[i]);
                map.put(i + 1, map.getOrDefault(i + 1, 0) - 1);
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            for(Integer key : map.keySet()){
                if(map.get(key) == -1){
                    result.add(key);
                }
            }
            return result;
        }
    }

    /**
     * Runtime: 10 ms, faster than 49.30% of Java online submissions for Find All Numbers Disappeared in an Array.
     * Memory Usage: 69 MB, less than 25.57% of Java online submissions for Find All Numbers Disappeared in an Array.
     * 將取得的元素值 改寫到 相對應的位置地值改成負數, 第一輪過後, 陣列內元素值>0 該index+1 就是缺少的數
     */
    class Solution2 {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new ArrayList<>();

            int len = nums.length;
            for(int i = 0; i < len; i++){
                int n = Math.abs(nums[i]);
                if(nums[n - 1] > 0){
                    nums[n - 1] *= -1;
                }
            }
            for(int i = 0; i < len; i++){
                if(nums[i] > 0){
                    result.add(i + 1);
                }
            }


            return result;
        }
    }


}
