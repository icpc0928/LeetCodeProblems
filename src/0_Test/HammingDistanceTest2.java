public class HammingDistanceTest2 {

    public static void main(String[] args) {
        int[] nums= {1,2,3};

        Solution s = new Solution();
        System.out.println(s.totalHammingDistance(nums));


    }

    static class Solution {
        public int totalHammingDistance(int[] nums) {
            int totalH = 0;
            int result = 0;
            for(int i = 0; i < nums.length; i++){
                totalH = totalH ^ nums[i];
            }
            System.out.println(totalH);

            for(int i = 0; i < nums.length; i++){
                result += totalH ^ nums[i];
            }

            return result;
        }
    }


}
