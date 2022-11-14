
public class N565_ArrayNesting {
//Runtime: 21 ms, faster than 27.01% of Java online submissions for Array Nesting.
//Memory Usage: 85.3 MB, less than 22.19% of Java online submissions for Array Nesting.
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {5,4,0,3,1,6,2,};
        System.out.println(solution.arrayNesting(nums));
    }


    static class Solution {
        public int arrayNesting(int[] nums) {

            int[] check = new int[nums.length];
            int result = 0;

            for(int i = 0; i < nums.length; i++){
                dfs(nums, check, i, 1);
                result = Math.max(result, check[i]);

            }

            return result;
        }

        public void dfs(int[] nums, int[] check, int i, int move){
            if( check[i] > 0) return;

            check[i] = move;
            dfs(nums, check, nums[i], move + 1);

        }
    }
}
