import java.util.ArrayList;
import java.util.List;

public class N1260_Shift2DGrid {

    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            //start K
            k = (grid.length * grid[0].length) - (k % (grid.length * grid[0].length));
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> innerList = new ArrayList<>();

            for(int i = 0; i < (grid.length * grid[0].length); i++){
                if(i % grid[0].length == 0){
                    innerList = new ArrayList<>();
                }
                innerList.add(getValueInGrid(grid, k + i));
                if((i % grid[0].length) == grid[0].length - 1){
                    result.add(innerList);
                }

            }
            return result;
        }

        private Integer getValueInGrid(int[][] grid, int pos) {
            pos = pos % (grid.length * grid[0].length);
            return grid[pos / grid[0].length][pos % grid[0].length];
        }
    }
}
