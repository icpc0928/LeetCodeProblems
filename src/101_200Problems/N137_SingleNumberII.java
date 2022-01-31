import java.util.Arrays;

public class N137_SingleNumberII {

    public static void main(String[] args){
        int[] nums = {30000,500,100,30000,100,30000,100};
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(nums));
    }
    //[]


    static class Solution {
        public int singleNumber(int[] nums) {
            Arrays.sort(nums);
            if(nums.length < 3){
                return nums[0];
            }
            for(int i = 0; i < nums.length/3*3; i=i+3){

                int x = 0;
                for(int j = 0; j < 3; j++){
                    System.out.println(nums[i + j]);
                    x = x ^ nums[i+j];
                    System.out.println("x: " + x);
                }

                if(x != nums[i+1]){
                    return x;
                }
            }
            return nums[nums.length - 1];
        }
    }
}
