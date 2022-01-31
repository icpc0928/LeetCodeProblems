public class N807_MaxIncreaseToKeepCitySkyline {

    //Runtime: 1 ms, faster than 98.18% of Java online submissions for Max Increase to Keep City Skyline.
    //Memory Usage: 44.3 MB, less than 5.35% of Java online submissions for Max Increase to Keep City Skyline.

    public static void main(String[] args){

    }



    static class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int[] maxCells = new int[grid.length];       //該軸的最大格
            int[] maxRolls = new int[grid[0].length];    //該格的最大軸
            int maxIncrease = 0;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    maxCells[i] = Math.max(maxCells[i], grid[i][j]);
                    maxRolls[j] = Math.max(maxRolls[j], grid[i][j]);
                }
            }
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    maxIncrease += Math.min(maxCells[j], maxRolls[i]) - grid[i][j];
                }
            }
            return maxIncrease;

        }
    }
}
