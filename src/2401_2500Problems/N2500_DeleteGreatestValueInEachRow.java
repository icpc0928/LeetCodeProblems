import java.util.Arrays;

public class N2500_DeleteGreatestValueInEachRow {

    class Solution {
        public int deleteGreatestValue(int[][] grid) {
            int result = 0;
            for (int[] ints : grid) {
                Arrays.sort(ints);
            }
            for(int j = 0; j < grid[0].length; j++){
                int maxV = 0;
                for(int i = 0; i < grid.length; i++){
                    maxV = Math.max(grid[i][j], maxV);
                }
                result += maxV;
            }
            return result;
        }
    }
}
