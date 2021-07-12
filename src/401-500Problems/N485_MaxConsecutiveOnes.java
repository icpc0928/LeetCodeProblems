public class N485_MaxConsecutiveOnes {
    //Runtime: 3 ms, faster than 18.64% of Java online submissions for Max Consecutive Ones.
    //Memory Usage: 53.4 MB, less than 8.61% of Java online submissions for Max Consecutive Ones.

    //Runtime: 2 ms, faster than 58.84% of Java online submissions for Max Consecutive Ones.
    //Memory Usage: 40.4 MB, less than 55.17% of Java online submissions for Max Consecutive Ones.

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {0,1,1,1,0,0,1,1,1,1,0,0,1,1,};
        System.out.println(sol.findMaxConsecutiveOnes(nums));
    }


    static class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int maxOnes = 0;
            int tempOnes = 0;

//            for(int i = 0; i < nums.length; i++){
//                if(nums[i] == 1){
//                    tempOnes++;
//                }else{
//                    maxOnes = Math.max(maxOnes, tempOnes);
//                    tempOnes = 0;
//                }
//            }
//            return Math.max(tempOnes, maxOnes);
            for(int num : nums)
                maxOnes = Math.max(maxOnes, tempOnes = num == 1 ? tempOnes + 1 : 0 );

            return maxOnes;
        }
    }
}
