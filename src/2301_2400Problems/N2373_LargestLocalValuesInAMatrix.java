public class N2373_LargestLocalValuesInAMatrix {

    static class Solution {
        public int[][] largestLocal(int[][] grid) {
            int[][] result = new int[grid.length - 2][grid[0].length - 2];

            for(int i = 0; i < result.length; i++){
                for(int j = 0; j < result[i].length; j++){
                    result[i][j] = getMaxValueIn3X3(grid, i+1, j+1);
                }
            }
            return result;
        }

        private int getMaxValueIn3X3(int[][] grid, int r, int c) {
            int max = 0;
            for(int i = r - 1; i <= r +1; i++){
                for(int j = c -1; j <= c +1; j++){
                    max = Math.max(max, grid[i][j]);
                }
            }
            return max;
        }


    }

}
