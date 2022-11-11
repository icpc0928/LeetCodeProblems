import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Runtime: 10 ms, faster than 96.95% of Java online submissions for Find the Difference of Two Arrays.
//Memory Usage: 43.3 MB, less than 85.16% of Java online submissions for Find the Difference of Two Arrays.

public class N2215_FindTheDifferenceOfTwoArrays {

    public static void main(String[] args) {

    }

    class Solution {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            Set<Integer> innerSet = new HashSet<>();
            List<List<Integer>> result = new ArrayList<>();

            for (int j : nums1) {
                set1.add(j);
            }

            for (int j : nums2) {
                if (set1.contains(j) || innerSet.contains(j)) {
                    set1.remove(j);
                    innerSet.add(j);
                } else {
                    set2.add(j);
                }
            }
            result.add(new ArrayList<>(set1));
            result.add(new ArrayList<>(set2));
            return result;
        }
    }
}
