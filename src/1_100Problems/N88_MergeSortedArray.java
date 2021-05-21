import java.util.Arrays;

public class N88_MergeSortedArray {

    //Runtime: 1 ms, faster than 13.41% of Java online submissions for Merge Sorted Array.
    //Memory Usage: 38.9 MB, less than 76.95% of Java online submissions for Merge Sorted Array.
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);

        for(int i = 0; i < nums1.length;  i++){
            System.out.println(nums1[i]);
        }
    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if(n == 0) return;

            System.arraycopy(nums2, 0, nums1, m, n);
            Arrays.sort(nums1);
        }
    }
}
