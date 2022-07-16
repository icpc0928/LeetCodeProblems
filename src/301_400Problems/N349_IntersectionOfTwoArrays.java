import java.util.*;

public class N349_IntersectionOfTwoArrays {


    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1,};
        int[] nums2 = {2,2,};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.intersection(nums1, nums2)));
    }

    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            int maxLen = Math.max(nums1.length, nums2.length);
            HashMap<Integer, Integer> map = new HashMap<>();
            Set<Integer> result = new HashSet<>();

            for(int i = 0; i < maxLen; i++){
                if(i < nums1.length){
                    if(map.getOrDefault(nums1[i], 0) == 2){
                        result.add(nums1[i]);
                    }
                    map.put(nums1[i], 1);

                }
                if(i < nums2.length){
                    if(map.getOrDefault(nums2[i], 0) == 1){
                        result.add(nums2[i]);
                    }
                    map.put(nums2[i], 2);
                }
            }
            return result.stream().mapToInt(i -> i).toArray();
        }
    }
}
