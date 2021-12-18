public class N883_ProjectionAreaOf3DShapes {

    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Projection Area of 3D Shapes.
    //Memory Usage: 38.5 MB, less than 85.20% of Java online submissions for Projection Area of 3D Shapes.

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] grid = {
                {1,2,},
                {3,4,},
        };
        System.out.println(s.projectionArea(grid));
    }

    static class Solution {
        public int projectionArea(int[][] grid) {
            //格最大 + 軸最大 + 俯視若>0則++
            int ans = 0;
            for(int i = 0; i < grid.length; i++){
                int wheelMax = 0;
                int gridMax = 0;
                for(int j = 0; j < grid[i].length; j++){
                    wheelMax = Math.max(wheelMax, grid[i][j]);
                    gridMax = Math.max(gridMax, grid[j][i]);
                    if(grid[i][j] > 0) ans++;
                }
                ans += (wheelMax + gridMax);
            }
            return ans;
        }
    }
}
