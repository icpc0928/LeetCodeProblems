import java.util.HashMap;
import java.util.Map;

/**
 * 寫得有夠爛 想太多了 有更簡潔的判斷方式
 */
public class N1391_CheckIfThereIsAValidPathInAGrid {



    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] grid = new int[][]{
                {4,1,3},
                {6,1,2},
        };

        System.out.println(s.hasValidPath(grid));

    }

    static class Solution {
        public boolean hasValidPath(int[][] grid) {
            //取得第一個路要往哪走
            int firstStep = grid[0][0];
            int fromSide;
            boolean[][] checkGo = new boolean[grid.length][grid[0].length];
            //出入口定義: 0:右, 1:下, 2:左, 3:上
            if(firstStep == 1 || firstStep == 3){
                fromSide = 2;
                return checkIsValid(grid, 0, 0, fromSide, checkGo);
            }else if(firstStep == 2 || firstStep == 6){
                fromSide = 3;
                return checkIsValid(grid, 0, 0, fromSide, checkGo);
            }else if(firstStep == 5){
                return false;
            }else {
                //firstStep == 4  , from: 0 or 1
                boolean doubleCheck = checkIsValid(grid, 0,0,0, checkGo);
                if(doubleCheck) return true;
                else {
                    checkGo = new boolean[grid.length][grid[0].length];
                    return checkIsValid(grid, 0,0,1, checkGo);
                }

            }
        }

        private boolean checkIsValid(int[][] grid, int i, int j, int fromSide, boolean[][] checkGo){
            if(i >= grid.length || i < 0 || j >= grid[i].length || j < 0) return false; //撞牆了
            if(checkGo[i][j]) return false;     //走回頭路了
            checkGo[i][j] = true;
            int thisGrid = grid[i][j];
            int[] forwards = sideMap.get(thisGrid);
            boolean checkContain = false;
            int toSide = 0;
            for (int forward : forwards) {
                toSide += forward;
                if(forward == fromSide) checkContain = true;
            }
            if(!checkContain) return false;
            if(i == grid.length -1 && j == grid[i].length -1) return true;      //到達目標
            toSide = toSide - fromSide;
            int nextFromSide = (toSide + 2) % 4;
            return checkIsValid(grid, i + x[toSide], j + y[toSide], nextFromSide, checkGo);
        }

        //出入口定義: 0:右, 1:下, 2:左, 3:上
        private final int[] x = {0,1,0,-1,};
        private final int[] y = {1,0,-1,0,};

        //每個路的入口跟出口方向對應圖
        private final Map<Integer, int[]> sideMap = new HashMap<>(){
            {
                put(1, new int[]{0,2});
                put(2, new int[]{1,3});
                put(3, new int[]{1,2});
                put(4, new int[]{0,1});
                put(5, new int[]{2,3});
                put(6, new int[]{0,3});
            }
        };

    }
}
