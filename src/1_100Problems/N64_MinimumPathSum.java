public class N64_MinimumPathSum {

    //Runtime: 2 ms, faster than 84.89% of Java online submissions for Minimum Path Sum.
    //Memory Usage: 41.9 MB, less than 48.79% of Java online submissions for Minimum Path Sum.

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] grid = {
                {1,3,1,},
                {1,5,1,},
                {4,2,1,},
        };

        System.out.println(solution.minPathSum(grid));
    }

    static class Solution {
        public int minPathSum(int[][] grid) {

            if(grid.length == 1 || grid[0].length == 1){
                int sum = 0;
                for (int[] ints : grid) {
                    for (int anInt : ints) {
                        sum += anInt;
                    }
                }
                return sum;
            }

            for(int i = 1; i < grid.length; i++){
                grid[i][0] += grid[i - 1][0];
            }
            for(int j = 1; j < grid[0].length; j++){
                grid[0][j] += grid[0][j - 1];
            }


            for(int i = 1; i < grid.length; i++){
                for(int j = 1; j < grid[i].length; j++){
                    grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                }
            }
            return grid[grid.length - 1][grid[0].length - 1];
        }
    }
}
