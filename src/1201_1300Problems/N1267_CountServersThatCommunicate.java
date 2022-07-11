import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 9 ms, faster than 23.31% of Java online submissions for Count Servers that Communicate.
 * Memory Usage: 66 MB, less than 11.50% of Java online submissions for Count Servers that Communicate.
 */

public class N1267_CountServersThatCommunicate {

    public static void main(String[] args) {
        int[][] grid = {
//                {1,1,0,0},
//                {0,0,1,0},
//                {0,0,1,0},
//                {0,0,0,1},
                {1,0,},
                {1,1,},

        };
        Solution s = new Solution();
        System.out.println(s.countServers(grid));
    }

    static class Solution {
        public int countServers(int[][] grid) {
            int[][] checkGrid = new int[grid.length][grid[0].length];

            int counter = 0;

            for(int i = 0; i < grid.length; i++){
                List<Integer> counterList = new ArrayList<>();
                for(int j = 0; j < grid[i].length; j++){
                    if(grid[i][j] == 1){
                        counterList.add(j);
                    }
                }
                if(counterList.size() >= 2){
                    counter += counterList.size();
                    //checkGrid
                    for(int j = 0; j < counterList.size(); j++){
                        checkGrid[i][counterList.get(j)] = 1;
                    }
                }
            }

            for(int j = 0; j < grid[0].length; j++){
                List<Integer> counterList = new ArrayList<>();
                for(int i = 0; i < grid.length; i++){
                    if(grid[i][j] == 1){
                        counterList.add(i);
                    }
                }
                if(counterList.size() >= 2){
                    for(int i = 0; i < counterList.size(); i++){
                        if(checkGrid[counterList.get(i)][j] == 0){

                            counter++;
                        }
                    }
                }
            }

            return counter;
        }
    }
}
