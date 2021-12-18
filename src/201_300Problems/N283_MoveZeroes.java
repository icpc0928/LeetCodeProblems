import java.util.Arrays;

public class N283_MoveZeroes {

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {0,1,0,3,12};
        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            int zerosCounter = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    nums[i - zerosCounter] = nums[i];
                }else{
                    zerosCounter++;
                }
            }
            for(int i = zerosCounter ; i > 0; i--){
                nums[nums.length - i] = 0;
            }
        }
    }
}
