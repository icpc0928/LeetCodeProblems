
public class N329_LongestIncreasingPathInAMatrix {

    //Runtime: 71 ms, faster than 11.88% of Java online submissions for Longest Increasing Path in a Matrix.
    //Memory Usage: 53.7 MB, less than 64.67% of Java online submissions for Longest Increasing Path in a Matrix.

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix =
                {
                {0,1,2,3,4,5,6,7,8,9},
                {19,18,17,16,15,14,13,12,11,10},
                {20,21,22,23,24,25,26,27,28,29},
                {39,38,37,36,35,34,33,32,31,30},
                {40,41,42,43,44,45,46,47,48,49},
                {59,58,57,56,55,54,53,52,51,50},
                {60,61,62,63,64,65,66,67,68,69},
                {79,78,77,76,75,74,73,72,71,70},
                {80,81,82,83,84,85,86,87,88,89},
                {99,98,97,96,95,94,93,92,91,90},
                {100,101,102,103,104,105,106,107,108,109},
                {119,118,117,116,115,114,113,112,111,110},
                {120,121,122,123,124,125,126,127,128,129},
                {139,138,137,136,135,134,133,132,131,130},
                {0,0,0,0,0,0,0,0,0,0}
        };

        System.out.println(solution.longestIncreasingPath(matrix));
    }

    static class Solution {
        public int longestIncreasingPath(int[][] matrix) {

            Max max = new Max();
            int[][] memo = new int[matrix.length][matrix[0].length];
//            maxMove(matrix, 0, 0, -1, 0, result);
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    //todo dfs
                    maxMove(matrix,memo, i, j, -1, 1, max);
//                    System.out.println(result);
                }
            }

            return max.getMaxMove();
        }


        public void maxMove(int[][] matrix,int[][] memo, int r, int c, int last, int moved, Max moveSet){
            if(r == matrix.length || r < 0 || c == matrix[r].length || c < 0 || matrix[r][c] <= last || moved <= memo[r][c]) return;

            moveSet.setMaxMove(moved);
            memo[r][c] = moved;

//            System.out.println(moveSet);
//            System.out.println(moved);

            maxMove(matrix, memo, r + 1, c, matrix[r][c], moved+1, moveSet);
            maxMove(matrix, memo, r - 1, c, matrix[r][c], moved+1, moveSet);
            maxMove(matrix, memo, r, c + 1, matrix[r][c], moved+1, moveSet);
            maxMove(matrix, memo, r, c - 1, matrix[r][c], moved+1, moveSet);
        }


    }
    static class Max{
        int maxMove = 0;

        public int getMaxMove() {
            return maxMove;
        }

        public void setMaxMove(int maxMove) {
            this.maxMove = Math.max(getMaxMove(),maxMove);
        }
    }
}
