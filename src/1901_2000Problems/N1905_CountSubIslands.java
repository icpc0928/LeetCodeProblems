public class N1905_CountSubIslands {
    //Runtime: 36 ms, faster than 73.30% of Java online submissions for Count Sub Islands.
    //Memory Usage: 140.4 MB, less than 23.26% of Java online submissions for Count Sub Islands.

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid1 = {
                {1,0,1,0,1},
                {1,1,1,1,1},
                {0,0,0,0,0},
                {1,1,1,1,1},
                {1,0,1,0,1},
        };
        int[][] grid2 = {
                {0,0,0,0,0},
                {1,1,1,1,1},
                {0,1,0,1,0},
                {0,1,0,1,0},
                {1,0,0,0,1},
        };

        System.out.println(s.countSubIslands(grid1, grid2));
    }



    static class Solution {
        int islandCount = 0;
        boolean isInIsland = true;

        public int countSubIslands(int[][] grid1, int[][] grid2) {

            int[][] grid2Checked = new int[grid1.length][grid1[0].length];

            for(int i = 0; i < grid2.length; i++){
                for(int j = 0; j < grid2[i].length; j++){
                    if(grid2[i][j] == 1 && grid2Checked[i][j] == 0){
                        isInIsland = true;
                        //todo dfs
                        DFS(grid1, grid2, i, j, grid2Checked);

                        if(isInIsland){
                            islandCount++;
                        }
                    }
                }
            }

            return islandCount;
        }


        public void DFS(int[][] grid1, int[][] grid2, int r, int c, int[][] grid2Checked){
            if(r < 0 || r == grid1.length || c < 0 || c == grid1[r].length || grid2[r][c] == 0 || grid2Checked[r][c] == 1) return;

            //grid2 == 1 but grid1 == 0
            if(grid2[r][c] != grid1[r][c]){
                isInIsland = false;
            }

            grid2Checked[r][c] = 1;

            DFS(grid1, grid2, r+1, c, grid2Checked);
            DFS(grid1, grid2, r-1, c, grid2Checked);
            DFS(grid1, grid2, r, c+1, grid2Checked);
            DFS(grid1, grid2, r, c-1, grid2Checked);

        }
    }
}
