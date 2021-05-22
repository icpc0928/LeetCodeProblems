import java.util.Arrays;

public class N136_SingleNumber {

    public static void main(String[] args){

        Solution solution = new Solution();
        int[] nums = {2,2,1};
        System.out.println(solution.singleNumber(nums));
    }


    static class Solution {
        public int singleNumber(int[] nums) {
            //XOR  ^ 兩次會等於0 只有一個是1次的就是那個了
            int ans = 0;
            for(int i : nums){
                ans ^= i;
            }
            return ans;
        }

    }
}
