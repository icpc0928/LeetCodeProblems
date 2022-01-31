public class N221_MaximalSquare {

    public static void main(String[] args){
//[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
        char[][] matrix = {
                {'1', '0', '1', '0', '0',},
                {'1', '0', '1', '1', '1',},
                {'1', '1', '1', '1', '1',},
                {'1', '0', '0', '1', '0',},
        };

    }


    static class Solution {
        public int maximalSquare(char[][] matrix) {
            int[][] intMatrix = new int[matrix.length][matrix[0].length];
            int max = 0;
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    intMatrix[i][j] = matrix[i][j] == '0' ? 0 : 1;
//                    if(intMatrix[i][j] == 1){
//                        max = Math.max(max, 1);
//                    }

                    if(i - 1 >= 0 && j - 1 >=0 && intMatrix[i][j] == 1){
                        intMatrix[i][j] = Math.min(Math.min(intMatrix[i - 1][j], intMatrix[i][j - 1]), intMatrix[i-1][j-1])+ 1;
//                        max = Math.max(max, intMatrix[i][j]);
                    }
                }
            }

            for(int i = 0;i < intMatrix.length; i++){
                for(int j = 0; j < intMatrix[i].length; j++){
                    max = Math.max(max, intMatrix[i][j]);
                }
            }


            return max * max;
        }
    }
}
