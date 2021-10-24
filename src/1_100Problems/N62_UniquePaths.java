public class N62_UniquePaths {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
     * Memory Usage: 35.6 MB, less than 92.78% of Java online submissions for Unique Paths.
     */

    public static void main(String[] args){
        Solution solution = new Solution();
        int m = 3;
        int n = 7;
        System.out.println(solution.uniquePaths(m,n));
    }

    static class Solution {
        public int uniquePaths(int m, int n) {
            int[][] grid = new int[m][n];

            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    if(i == 0 || j == 0){
                        grid[i][j] = 1;
                    }else{
                        grid[i][j] = grid[i-1][j] + grid[i][j-1];
                    }

                    System.out.print(grid[i][j] + " ");

                }
                System.out.println();
            }
            return grid[grid.length-1][grid[grid.length-1].length-1];
        }
    }
}
