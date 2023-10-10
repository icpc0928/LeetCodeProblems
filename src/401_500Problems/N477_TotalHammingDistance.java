public class N477_TotalHammingDistance {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4,14,2};
        System.out.println(s.totalHammingDistance(nums));
    }

    static class Solution {
        public int totalHammingDistance(int[] nums) {
            int result = 0;
            for(int i = 0; i < nums.length - 1; i++){
                for(int j = i + 1; j < nums.length; j++){
                    result += Integer.bitCount(nums[i] ^ nums[j]);
//                    result += getHammingDistance(nums[i] ^ nums[j]);
                }
            }

            return result;
        }


        private int getHammingDistance(int h){
            return Integer.toBinaryString(h).replaceAll("0", "").length();
        }
    }


}
