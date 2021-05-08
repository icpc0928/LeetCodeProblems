import java.util.Arrays;

public class N41_FirstMissingPositive {

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {0,0,1,2,3,4,};
        int ans = solution.firstMissingPositive(nums);
        System.out.println(ans);
    }

    static class Solution {
        public int firstMissingPositive(int[] nums) {
            Arrays.sort(nums);
            int N = nums.length - 1;
            if(nums.length == 1) return nums[0] == 1 ? 2 : 1;
            //二元搜尋找1的索引值  返回陣列中最早出現1的索引值
            int oneIndex = Arrays.binarySearch(nums, 1);
            System.out.println(oneIndex);
            //如果陣列中沒有1 會返回負數,則return1 即是最小正整數
            if(oneIndex < 0)
                return 1;
            //如果陣列中有1,則從該索引值中往後找相差大於1的,return前值+1(即兩數中間的最小正整數)
            else{
                for(int i = oneIndex; i < nums.length - 1; i++){
                    if(nums[i + 1] - nums[i] > 1)
                        return nums[i] + 1;
                }
                return nums[N] +1;
            }
        }
    }
}
