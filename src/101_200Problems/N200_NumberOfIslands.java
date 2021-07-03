public class N200_NumberOfIslands {

    //Runtime: 1 ms, faster than 99.95% of Java online submissions for Number of Islands.
    //Memory Usage: 41.2 MB, less than 88.02% of Java online submissions for Number of Islands.

    public static void main(String[] args){
        Solution solution = new Solution();
        char[][] grid = {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        };
        //[
        //{'1','1','0','0','0'},
        //{'1','1','0','0','0'},
        //{'0','0','1','0','0'},
        //{'0','0','0','1','1'}
        System.out.println(solution.numIslands(grid));

    }


    static class Solution {
        public int numIslands(char[][] grid) {
            int ans = 0;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    if(grid[i][j] == '1'){
                        ans++;
                        System.out.println("ANS: " + ans + "    grid: " + i + " " + j);
                        //doDFS
                        depthFirstSearch(grid, i, j);
                    }
                }
            }
            return ans;
        }


        public void depthFirstSearch(char[][] grid, int i, int j){
            if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;

            grid[i][j] = '0';
            System.out.println("Grid: " + i + " , " + j);
            depthFirstSearch(grid, i, j + 1);
            depthFirstSearch(grid, i + 1, j);
            depthFirstSearch(grid, i, j - 1);
            depthFirstSearch(grid, i - 1, j);


        }
    }
}
