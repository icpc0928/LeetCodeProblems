import java.util.Arrays;

public class N2679_SumInMatrix {

    class Solution {
        public int matrixSum(int[][] nums) {
            for(int i = 0; i < nums.length; i++){
                Arrays.sort(nums[i]);
            }
            int result = 0;
            for(int j = 0 ; j < nums[0].length; j++){
                int max = 0;
                for(int i = 0; i < nums.length; i++){
                    max = Math.max(max, nums[i][j]);
                }
                result += max;
            }
            return result;
        }
    }
}
