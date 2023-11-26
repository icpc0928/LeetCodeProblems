import java.util.ArrayList;
import java.util.List;

public class N1559_DetectCyclesIn2DGrid {

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grid = new char[][]{
//                {'a','a','a','a'},
//                {'a','b','b','a'},
//                {'a','b','b','a'},
//                {'a','a','a','a'},
//                {'a','b','b'},
//                {'b','z','b'},
//                {'b','b','a'},
                {'c','a','d'},
                {'a','a','a'},
                {'a','a','d'},
                {'a','c','d'},
                {'a','b','c'},
        };
        System.out.println(s.containsCycle(grid));
    }

    static class Solution {
        public boolean containsCycle(char[][] grid) {
            int[][] checkGrid = new int[grid.length][grid[0].length];

            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    if(checkGrid[i][j] > 0) continue;
                    List<Boolean> resultCheck = new ArrayList<>();
                    DFS(grid, checkGrid, i, j, 1, resultCheck, grid[i][j]);
                    if(resultCheck.size() > 0) return true;
                }
            }
            return false;
        }

        public void DFS(char[][] grid, int[][] check, int i, int j, int count, List<Boolean> resultCheck, char checkChar){
            if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) return;   //超出界線
            //不一樣的東西
            if(checkChar != grid[i][j]) return;
            //有循環
            if(check[i][j] > 0 && count - check[i][j] >= 3){
                resultCheck.add(true);
            }
            if(check[i][j] != 0) return;

            check[i][j] = count;
            count++;

            DFS(grid, check, i+1, j, count, resultCheck, checkChar);
            DFS(grid, check, i-1, j, count, resultCheck, checkChar);
            DFS(grid, check, i, j+1, count, resultCheck, checkChar);
            DFS(grid, check, i, j-1, count, resultCheck, checkChar);
        }


    }
}
