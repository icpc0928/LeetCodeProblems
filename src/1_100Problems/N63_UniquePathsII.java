public class N63_UniquePathsII {

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] grid = {
                {0,0,0},
                {0,1,0},
                {0,0,0,},

        };

        System.out.println(solution.uniquePathsWithObstacles(grid));
    }

    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if(obstacleGrid[0][0] == 1) return 0;
            int[][] grid = new int[obstacleGrid.length][obstacleGrid[0].length];
            //邊
            grid[0][0] = 1;
            for(int i = 1; i < grid.length; i++){
                if(obstacleGrid[i][0] == 1) grid[i][0] = 0;
                else grid[i][0] = grid[i-1][0];
            }
            for(int i = 1; i < grid[0].length; i++){
                if(obstacleGrid[0][i] == 1) grid[0][i] = 0;
                else grid[0][i] = grid[0][i-1];
            }

            for(int i = 1; i < grid.length; i++){
                for(int j = 1; j < grid[i].length; j++){
                    grid[i][j] = obstacleGrid[i][j] == 1 ? 0 : grid[i-1][j] + grid[i][j-1];
                }
            }

            return grid[grid.length-1][grid[0].length-1];
        }
    }
}
