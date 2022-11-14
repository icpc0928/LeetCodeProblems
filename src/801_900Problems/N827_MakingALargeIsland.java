import java.util.*;

public class N827_MakingALargeIsland {
    //Runtime: 293 ms, faster than 46.25% of Java online submissions for Making A Large Island.
    //Memory Usage: 214.8 MB, less than 21.21% of Java online submissions for Making A Large Island.

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0},
//                {1,1,},
//                {1,1,},
        };
        System.out.println(solution.largestIsland(grid));
    }


    static class Solution {
        int maxArea = 0;
        int thisArea = 0;
        List<Integer> counter = new ArrayList<>();      //從1開始 各區域的island大小
        List<int[]> emptyPos = new ArrayList<>();
        int[] x = {1, -1, 0,  0,};
        int[] y = {0,  0, 1, -1,};
        public int largestIsland(int[][] grid) {
            int[][] islandMark = new int[grid.length][grid[0].length];

            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    if(grid[i][j] == 1 && islandMark[i][j] == 0){
                        //DO DFS
                        DFS(grid, i, j, islandMark, counter.size() + 1);
                        maxArea = Math.max(thisArea, maxArea);
                        counter.add(thisArea);

                        thisArea = 0;
                    }
                    if(grid[i][j] == 0){
                        emptyPos.add(new int[]{i, j});
                    }
                }
            }
            for (int[] pos : emptyPos) {
                maxArea = Math.max(getMaxArea(islandMark, counter, pos), maxArea);
            }
            return maxArea;
        }

        public int getMaxArea(int[][] islandMark, List<Integer> counter, int[] pos){
            Set<Integer> set = new HashSet<>();
            for(int i = 0;i  < x.length; i++){
                if(pos[0] + x[i] < 0 ||
                        pos[0] + x[i] >= islandMark.length ||
                        pos[1] + y[i] < 0 ||
                        pos[1] +y[i]>= islandMark[pos[0]].length ||
                        islandMark[pos[0]+x[i]][pos[1]+y[i]] == 0) continue;
                set.add(islandMark[pos[0]+x[i]][pos[1]+y[i]] - 1);
            }
            int result = 0;
            for(Integer mark : set){
                result += counter.get(mark);
            }
//            System.out.println(result);
            return result + 1;
        }

        public void DFS(int[][] grid, int i, int j, int[][] islandMark, int count){
            if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || islandMark[i][j] != 0 || grid[i][j] == 0) return;

//            grid[i][j] = 0;
            islandMark[i][j] = count;
            thisArea++;

            DFS(grid, i, j + 1, islandMark, count);
            DFS(grid, i, j - 1, islandMark, count);
            DFS(grid, i + 1, j, islandMark, count);
            DFS(grid, i - 1, j, islandMark, count);
        }

        public void printGrid(int[][] grid){
            for(int i = 0; i < grid.length; i++){
                System.out.println(Arrays.toString(grid[i]));
            }
        }
    }
}
