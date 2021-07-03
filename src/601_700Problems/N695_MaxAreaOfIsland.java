public class N695_MaxAreaOfIsland {

    //Runtime: 2 ms, faster than 99.50% of Java online submissions for Max Area of Island.
    //Memory Usage: 39.4 MB, less than 77.27% of Java online submissions for Max Area of Island.

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] grid = {
                 {0,0,1,0,0,0,0,1,0,0,0,0,0},
                 {0,0,0,0,0,0,0,1,1,1,0,0,0},
                 {0,1,1,0,1,0,0,0,0,0,0,0,0},
                 {0,1,0,0,1,1,0,0,1,0,1,0,0},
                 {0,1,0,0,1,1,0,0,1,1,1,0,0},
                 {0,0,0,0,0,0,0,0,0,0,1,0,0},
                 {0,0,0,0,0,0,0,1,1,1,0,0,0},
                 {0,0,0,0,0,0,0,1,1,0,0,0,0},
        };
        System.out.println(sol.maxAreaOfIsland(grid));
    }


    static class Solution {
        int maxArea = 0;
        int thisArea = 0;

        public int maxAreaOfIsland(int[][] grid) {
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    if(grid[i][j] == 1){
                        //DO DFS
                        DFS(grid, i, j);
                        maxArea = Math.max(maxArea, thisArea);
                        thisArea = 0;
                    }
                }
            }
            return maxArea;
        }

        public void DFS(int[][] grid, int i, int j){
            if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) return;

            grid[i][j] = 0;
            thisArea++;
            DFS(grid, i, j + 1);
            DFS(grid, i, j - 1);
            DFS(grid, i + 1, j);
            DFS(grid, i - 1, j);
        }
    }
}
