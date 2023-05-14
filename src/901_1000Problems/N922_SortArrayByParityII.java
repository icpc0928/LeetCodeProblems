import java.util.Arrays;

public class N922_SortArrayByParityII {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4,2,5,7};
        int[] result = s.sortArrayByParityII(nums);
        System.out.println(Arrays.toString(result));
    }

    static class Solution {
        public int[] sortArrayByParityII(int[] nums) {
            int[] result = new int[nums.length];
            int iEven = 0;
            int iOdd = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] % 2 == 0){
                    result[iEven * 2] = nums[i];
                    iEven++;
                }else{
                    result[iOdd * 2 + 1] = nums[i];
                    iOdd++;
                }

            }
            return result;
        }
    }
}
