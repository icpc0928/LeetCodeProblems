import java.util.TreeMap;

public class N215_KthLargestElementInAnArray {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(s.findKthLargest(nums, k));
    }
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            //create a treemap descending order
            TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> b - a);
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            while(k > 0){
                int key = map.firstKey();
                int value = map.get(key);
                if(value < k){
                    k -= value;
                    map.remove(key);
                }else{
                    return key;
                }
            }
            return 0;


        }
    }
}
