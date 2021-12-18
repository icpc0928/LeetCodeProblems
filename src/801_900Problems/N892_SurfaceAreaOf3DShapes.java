public class N892_SurfaceAreaOf3DShapes {

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] grid = {
                {1,1,1,},
                {1,0,1,},
                {1,1,1,},
        };
        System.out.println(s.surfaceArea(grid));
    }

    static class Solution {
        public int surfaceArea(int[][] grid) {
            int ans = 0;
            //先算自己表面積 => ans += grid[i][j] * 6 - ((grid[i][j] - 1) * 2)
            //跟( 右,下 )的比較,重複幾個就 乘2 扣除掉 => ans -= Math.min(grid[i][j], grid[i+1][j+1]) * 2
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){

                    if(grid[i][j] == 0) continue;
                    //加上自己的表面積
                    ans += grid[i][j] * 4 + 2;
                    //右邊
                    if(j + 1 < grid[i].length){
                        ans -= (Math.min(grid[i][j], grid[i][j + 1]) * 2);
                    }
                    //下邊
                    if(i + 1 < grid.length){
                        ans -= Math.min(grid[i][j], grid[i + 1][j]) * 2;
                    }
                }
            }
            return ans;
        }
    }
}
