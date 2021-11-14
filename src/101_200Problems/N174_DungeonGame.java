public class N174_DungeonGame {
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Dungeon Game.
//Memory Usage: 38.7 MB, less than 65.66% of Java online submissions for Dungeon Game.

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] dungeon = {
                {-2, -3, 3,},
                {-5, -10, 1},
                {10, 30, -5},
        };
        System.out.println(sol.calculateMinimumHP(dungeon));
    }

    static class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            int m = dungeon.length;
            int n = dungeon[0].length;
            int[][] memo = new int[m][n];   //備忘紀錄
//            Math.max(1, 1 - traverse(dungeon, 0, 0, memo));
//            printArray(memo);
            return Math.max(1, 1 - traverse(dungeon, 0, 0, memo));

        }

        //DFS
        private int traverse(int[][] dungeon, int r, int c, int[][] memo){
            if(r == dungeon.length - 1 && c == dungeon[0].length - 1)
                return dungeon[r][c];
            if(memo[r][c] != 0)
                return memo[r][c];

            int res = Integer.MIN_VALUE;

            if(r + 1 < dungeon.length){
                res = Math.max(res, traverse(dungeon, r + 1, c, memo));
            }
            if(c + 1 < dungeon[0].length){
                res = Math.max(res, traverse(dungeon, r, c + 1, memo));
            }
            res = Math.min(dungeon[r][c], res + dungeon[r][c]);
            memo[r][c] = res;
            System.out.println("RES: " + res);
            return res;
        }


    }
    static void printArray(int[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                System.out.print(grid[i][j] + " , ");
            }
            System.out.println();
        }
    }
}
