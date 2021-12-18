public class N463_IslandPerimeter {

    //Runtime: 5 ms, faster than 99.42% of Java online submissions for Island Perimeter.
    //Memory Usage: 40.5 MB, less than 45.64% of Java online submissions for Island Perimeter.

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] grid =
                {
                        {0,1,0,0,},
                        {1,1,1,0,},
                        {0,1,0,0,},
                        {1,1,0,0,},
        };
    }

    static class Solution {
        public int islandPerimeter(int[][] grid) {
            //若該元素為1則+4
            //若該元素的 前面那格 以及 上面那格 是否為1 如果是則 -2 (上左都是即 -2-2)
            int ans = 0;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    if(grid[i][j] == 1){
                        ans += 4;
                        ans -= needReducePerimeter(grid, i, j);
                    }
                }
            }

            return ans;
        }

        public int needReducePerimeter(int[][] grid, int i, int j){
            int reduceP = 0;
            //檢查左邊那格
            if(j - 1 >= 0)
                if(grid[i][j - 1] == 1)
                    reduceP += 2;

            if(i - 1 >= 0)
                if(grid[i - 1][j] == 1)
                    reduceP += 2;

            return reduceP;
        }
    }
}
