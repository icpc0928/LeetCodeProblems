import java.util.*;
//Runtime: 12 ms, faster than 12.78% of Java online submissions for Intersection of Two Arrays II.
//Memory Usage: 44.5 MB, less than 14.01% of Java online submissions for Intersection of Two Arrays II.

public class N350_IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
    }

    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> num1Map = new HashMap<>();
            List<Integer> result = new ArrayList<>();

            for (int j : nums1) {
                num1Map.put(j, num1Map.getOrDefault(j, 0) + 1);
            }

            for (int i : nums2){
                if(num1Map.getOrDefault(i, 0) > 0){
                    result.add(i);
                    num1Map.put(i, num1Map.get(i) - 1);
                }
            }

            return result.stream().mapToInt(i -> i).toArray();

        }
    }
}
